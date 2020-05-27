package edu.sjsu.cs.cs151.controller;
/**
 * <h1>Controller class</h1>
 * <p>
 * Controls the various states of the game, including:
 * 1. Starting the game
 * 2. Player's ships placement
 * 3. Playing the game, switching turns after every attack
 * 4. Ending the game when there's a winner
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;
import edu.sjsu.cs.cs151.app.*;


public class Controller {
	private Model model;
	private View view;
	private LinkedBlockingQueue<Message> messageQueue;
	private GameInfo gameinfo;
	private List<Valve> valves;
	

	/**
	 * This method initalizes the controller, and creating valves for various states of the game
	 * @param model containing all the objects in the game
	 * @param view the ui displaying the game
	 * @param messageQueue handling the sequence of commands performed
	 * @return Nothing
	 */
	public Controller(Model model, View view, LinkedBlockingQueue<Message> messageQueue)
	{
		gameinfo = new GameInfo();
		this.model = model;
		this.view = view;
		this.messageQueue = messageQueue;
		valves = new LinkedList<Valve>();
		valves.add(new DoNewGameValve());
		valves.add(new PlayerSetupShipValve());
		valves.add(new placeShipValve());
		valves.add(new startGameValve());
		valves.add(new changeTurnValve());
		valves.add(new AttackValve());
		valves.add(new surrenderValve());
		valves.add(new GameOverValve());

		
	}
	
	/**
	 * This method is the main loop of the game, running until the game is over
	 * @param Nothing
	 * @return Nothing
	 */
	public void mainLoop() throws InterruptedException
	{
		Controller.Valve.ValveResponse valveResponse = Controller.Valve.ValveResponse.EXECUTED;
		Message message = null;

		while(valveResponse != Controller.Valve.ValveResponse.FINISHGAME)
		{
			try {
				message = (Message) messageQueue.take();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			for(Valve v: valves)
			{
				valveResponse = v.execute(message);
				if(valveResponse != Controller.Valve.ValveResponse.FAIL)
					break;
			}
			
		}
		
		System.out.println("Game over");
		
	}
	
	
	private interface Valve
	{
		public ValveResponse execute(Message message);
		
		enum ValveResponse{
		FAIL,
		EXECUTED,
		FINISHGAME
		}
	}
	
	
	private class DoNewGameValve implements Valve
	{
		
		/**
		 * This method starts the game when it receives a message command
		 * @param message tells the controller to initiate a new game
		 * @return ValveResponse.EXECUTED when message is valid
		 */	
	@Override
	public ValveResponse execute(Message message) {
		if(!(message instanceof NewGameMessage))
			return ValveResponse.FAIL;
		//actions
		model.getPlayer1().getGrid().setupGrid();
		model.getPlayer2().getGrid().setupGrid();
		gameinfo.setState("Setup grid");
		try {
			view.change(gameinfo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ValveResponse.EXECUTED;
	}
	}
	private class PlayerSetupShipValve implements Valve
	{
		/**
		 * This method starts the ship placement state of the game
		 * @param message tells the controller to initiate ship placement module
		 * @return ValveResponse.EXECUTED when message is valid
		 */	
		@Override
		public ValveResponse execute(Message message) {
			if(!(message instanceof PlayerSetupShipMessage))
				return ValveResponse.FAIL;
			
			gameinfo.setState(message.getPlayerName() + " setup ship");
			gameinfo.setPlayer(message.getPlayerName());

			try {
				view.change(gameinfo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return ValveResponse.EXECUTED;
		}
		
	}

	private class placeShipValve implements Valve
	{

		/**
		 * This method places the ship after a player selected its position
		 * @param message tells the controller if a ship was placed successfully
		 * @return ValveResponse.EXECUTED when message is valid
		 */	
		@Override
		public ValveResponse execute(Message message) {
			if(!(message instanceof PlaceShipMessage))
				return ValveResponse.FAIL;

			PlaceShipMessage temp = (PlaceShipMessage) message;
			
			Boolean isShipPlacedSuccessful = model.placeShip(temp.getRow(), temp.getCol(), temp.getPlayerName(), temp.getShipName());
			gameinfo.setShipPlaceSuccessfully(isShipPlacedSuccessful);
			gameinfo.setRowsForPlacingShip(temp.getRow());
			gameinfo.setColumnsForPlacingShip(temp.getCol());
			gameinfo.setColor(temp.getColor());
			return ValveResponse.EXECUTED;
		}
		
	}

	private class startGameValve implements Valve
	{
		/**
		 * This method starts the game after all the ships were successfully placed
		 * @param message command to start the game
		 * @return ValveResponse.EXECUTED when message is valid
		 */	
 		@Override
		public ValveResponse execute(Message message) {
			if(!(message instanceof StartGameMessage))
				return ValveResponse.FAIL;
			gameinfo.setState("Start game");
			try {
				view.change(gameinfo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ValveResponse.EXECUTED;
		}
		
	}
	
	
	private class changeTurnValve implements Valve
	{
		/**
		 * This method switches the player's turn
		 * @param message commanand to switch the current player's turn to the other
		 * @return ValveResponse.EXECUTED when message is valid
		 */	
		public ValveResponse execute(Message message)
		{
			if(!(message instanceof changeTurnMessage))
				return ValveResponse.FAIL;
			changeTurnMessage temp = (changeTurnMessage) message;
			gameinfo.setState(temp.getPlayerName());
			if(temp.getPlayerName().equals("Player 1's turn"))
				gameinfo.setPlayer("Player 1");
			else if(temp.getPlayerName().equals("Player 2's turn"))
				gameinfo.setPlayer("Player 2");
			
			try {
				view.change(gameinfo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ValveResponse.EXECUTED;
		}
	}

	private class AttackValve implements Valve
	{
		/**
		 * This method initiates the attack phase
		 * @param message command to start the game
		 * @return ValveResponse.EXECUTED when message is valid
		 */	
		public ValveResponse execute(Message message)
		{
			if(!(message instanceof AttackMessage))
				return ValveResponse.FAIL;

			
			AttackMessage temp = (AttackMessage) message;
			Boolean isHit = model.attack(temp.getRow(), temp.getCol(), temp.getPlayerName());
			if(isHit == true)
			{
				gameinfo.setHit(true);
				gameinfo.setShipName(model.getShipAttacked(temp.getRow(), temp.getCol(), temp.getPlayerName()));
				gameinfo.setSunken(model.isShipSunk(temp.getRow(), temp.getCol(), temp.getPlayerName()));
			}else
			{
				gameinfo.setHit(false);
			}
			gameinfo.setColumnForAttack(temp.getCol());
			gameinfo.setRowForAttack(temp.getRow());
			
			String player = null;
			if(gameinfo.getPlayer().equals("Player 1"))
				player = "Player 2";
			else if(gameinfo.getPlayer().equals("Player 2"))
				player = "Player 1";
			if(model.checkifLost(player) == true)
			{
				gameinfo.setState("Game over");
				try {
					view.change(gameinfo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return ValveResponse.EXECUTED;
		}
	}
	
	
	private class surrenderValve implements Valve
	{
		/**
		 * This method initiates surrender phase if player chooses the option
		 * @param message command to surrender and end the game
		 * @return ValveResponse.EXECUTED when message is valid
		 */	
		@Override
		public ValveResponse execute(Message message) {
			if(!(message instanceof SurrenderMessage))
				return ValveResponse.FAIL;
			if(gameinfo.getPlayer().equals("Player 1"))
				gameinfo.setPlayer("Player 2");
			else if(gameinfo.getPlayer().equals("Player 2"))
				gameinfo.setPlayer("Player 1");
			gameinfo.setState("Game over");
			try {
				view.change(gameinfo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ValveResponse.EXECUTED;
		}
		
	}
	private class GameOverValve implements Valve
	{
		/**
		 * This method ends the game
		 * @param message command to end the game
		 * @return ValveResponse.EXECUTED when message is valid
		 */	
		@Override
		public ValveResponse execute(Message message) {
			if(!(message instanceof GameOverMessage))
				return ValveResponse.FAIL;
			
			return ValveResponse.FINISHGAME;
		}
		
	}
}

