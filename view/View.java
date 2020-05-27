package edu.sjsu.cs.cs151.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


import edu.sjsu.cs.cs151.app.*;
import edu.sjsu.cs.cs151.controller.GameInfo;

/**
 * <h1>View Class</h1>
 * <p>
 * The GUI of the game, displaying two grids for each player, one for placing ships and one for attacking
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */

public class View{

	private LinkedBlockingQueue<Message> messageQueue;
	private	JFrame MainFrame;
	private JPanel mainPanel;
	private JPanel welcomePanel;
	private JPanel ButtonBox;
	private JPanel player1Group;
	private JPanel player2Group;
	private JPanel player1GridBox;
	private JPanel player2GridBox;
	private JPanel player1EnemyGridBox;
	private JPanel player2EnemyGridBox;
	private JPanel player1GridPanel;
	private JButton[][] player1GridButtons;
	private JLabel player1GridLabel;
	private JPanel player1EnemyGridPanel;
	private JButton[][] player1EnemyGridButtons;
	private JLabel player1EnemyGridLabel;
	private JPanel player2GridPanel;
	private JButton[][] player2GridButtons;
	private JLabel player2GridLabel;
	private JPanel player2EnemyGridPanel;
	private JButton[][] player2EnemyGridButtons;
	private JLabel player2EnemyGridLabel;
	private JTextField text;
	private JTextField text2;
	private JButton placeBattleShipButton;
	private JButton placeCruiserButton;
	private JButton placeSubmarineButton;
	private JButton placeDestroyerButton;
	private JButton placeCarrierButton;

	
	private JPanel player1Options;
	private JPanel player2Options;
	
	private JButton player1AttackButton;
	private JButton player2AttackButton;
	private JButton player1SurrenderButton;
	private JButton player2SurrenderButton;
	
	private static JButton lastButtonPressed = new JButton();

	/**
	 * This method initalizes the view of the game, creating two 10x10 grid for each player, ship placement and attack buttons.
	 * @param Nothing
	 * @return Nothing
	 */
	public View()
	{
		MainFrame = new JFrame();
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		welcomePanel = new JPanel();
		ButtonBox = new JPanel();
		ButtonBox.setLayout(new FlowLayout());
		player1Group = new JPanel();
		player1Group.setLayout(new BorderLayout());
		player2Group = new JPanel();
		player2Group.setLayout(new BorderLayout());
		player1GridBox = new JPanel();
		player1GridBox.setLayout(new BoxLayout(player1GridBox, BoxLayout.PAGE_AXIS));
		player1EnemyGridBox = new JPanel();
		player1EnemyGridBox.setLayout(new BoxLayout(player1EnemyGridBox, BoxLayout.PAGE_AXIS));
		player2GridBox = new JPanel();
		player2GridBox.setLayout(new BoxLayout(player2GridBox, BoxLayout.PAGE_AXIS));
		player2EnemyGridBox = new JPanel();
		player2EnemyGridBox.setLayout(new BoxLayout(player2EnemyGridBox, BoxLayout.PAGE_AXIS));
		player1GridPanel = new JPanel();
		player1GridLabel = new JLabel();
		player1EnemyGridPanel = new JPanel();
		player1EnemyGridLabel = new JLabel();
		player2GridPanel = new JPanel();
		player2GridLabel = new JLabel();
		player2EnemyGridPanel = new JPanel();
		player2EnemyGridLabel = new JLabel();
		placeBattleShipButton = new JButton(); 
		placeBattleShipButton.setText("Place Battleship(4)");
		placeBattleShipButton.setForeground(Color.YELLOW);
		placeCruiserButton = new JButton(); 
		placeCruiserButton.setText("Place Cruiser(3)");
		placeCruiserButton.setForeground(Color.CYAN);
		placeSubmarineButton = new JButton(); 
		placeSubmarineButton.setText("Place Submarine(3)");
		placeSubmarineButton.setForeground(Color.MAGENTA);
		placeDestroyerButton = new JButton(); 
		placeDestroyerButton.setText("Place Destroyer(2)");
		placeDestroyerButton.setForeground(Color.PINK);
		placeCarrierButton = new JButton(); 
		placeCarrierButton.setText("Place Carrier(5)");
		placeCarrierButton.setForeground(Color.BLUE);
		player1GridButtons = new JButton[11][11];
		player1EnemyGridButtons = new JButton[11][11];
		player2GridButtons = new JButton[11][11];
		player2EnemyGridButtons = new JButton[11][11];
		text = new JTextField();
		text.setPreferredSize(new Dimension(600, 20));
		text.setBackground(Color.WHITE);
		text2 = new JTextField();
		text2.setPreferredSize(new Dimension(600, 20));
		text2.setBackground(Color.WHITE);
		
		player1Options = new JPanel();
		player2Options = new JPanel();
		player1Options.setLayout(new FlowLayout());
		player2Options.setLayout(new FlowLayout());
		player1AttackButton = new JButton();
		player1AttackButton.setText("Attack");
		player1SurrenderButton = new JButton();
		player1SurrenderButton.setText("Surrender");
		player2AttackButton = new JButton();
		player2AttackButton.setText("Attack");
		player2SurrenderButton = new JButton();
		player2SurrenderButton.setText("Surrender");
		
		
		
	}
	
	/**
	 * This method is the start menu of the game
	 * @param queue message telling the controller to start this module first
	 * @return Nothing
	 */
	public void init(LinkedBlockingQueue<Message> queue)
	{
		messageQueue = queue;
		welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.PAGE_AXIS));
		JLabel welcome = new JLabel();
		welcome.setText("Welcome to Battleship!");
		JButton welcomeButton = new JButton();
		welcomeButton.setText("Start game!");
		welcomeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					try {
						messageQueue.put(new NewGameMessage());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		});
		welcomePanel.add(welcome);
		welcomePanel.add(welcomeButton);
		
		MainFrame.add(welcomePanel);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.pack();
		MainFrame.setVisible(true);
	}
	
	/**
	 * This method displays the ship placement module of the game then the battle view of both players
	 * @param info of GameInfo class to keep track of players' actions such as: ship placement position, attacked positions, and ships remaining
	 * @return Nothing
	 */
	public void change(GameInfo info) throws InterruptedException
	{

		switch(info.getState())
		{
			
		case "Setup grid":
			MainFrame.remove(welcomePanel);
			MainFrame.setVisible(false);
			drawGrid(player1GridPanel, player1GridButtons);
			drawGrid(player1EnemyGridPanel, player1EnemyGridButtons);
			drawGrid(player2GridPanel, player2GridButtons);
			drawGrid(player2EnemyGridPanel, player2EnemyGridButtons);
			player1GridLabel.setText("Player 1's Grid");
			player1EnemyGridLabel.setText("Player 1 Enemy's grid");
			player2GridLabel.setText("Player 2's Grid");
			player2EnemyGridLabel.setText("Player 2 Enemy's grid");
			player1GridBox.add(player1GridLabel);
			player1GridBox.add(player1GridPanel);
			player1EnemyGridBox.add(player1EnemyGridLabel);
			player1EnemyGridBox.add(player1EnemyGridPanel);
			player2GridBox.add(player2GridLabel);
			player2GridBox.add(player2GridPanel);
			player2EnemyGridBox.add(player2EnemyGridLabel);
			player2EnemyGridBox.add(player2EnemyGridPanel);
			player1Group.add(player1GridBox, BorderLayout.LINE_START);
			player1Group.add(player1EnemyGridBox, BorderLayout.LINE_END);
			player2Group.add(player2GridBox, BorderLayout.LINE_START);
			player2Group.add(player2EnemyGridBox, BorderLayout.LINE_END);
			ButtonBox.add(placeCruiserButton);
			ButtonBox.add(placeSubmarineButton);
			ButtonBox.add(placeDestroyerButton);
			ButtonBox.add(placeBattleShipButton);
			ButtonBox.add(placeCarrierButton);
			player1Group.add(ButtonBox, BorderLayout.NORTH);
			player1Group.add(text, BorderLayout.SOUTH);
			//mainPanel.add(player1Group);
			//mainPanel.add(player2Group);
			

			messageQueue.put(new PlayerSetupShipMessage("Player 1"));

			//MainFrame.add(player1Group);
			//MainFrame.pack();
			//MainFrame.setVisible(true);
			
			MainFrame.add(player1Group);			
			for(int i = 0; i < player1GridButtons.length; i++)
			{
				for(int j = 0; j < player1GridButtons.length; j++)
				{
					player1GridButtons[i][j].addActionListener(new ActionSetSelected());
				}
			}
			placeCruiserButton.addActionListener(new placeShipAction(player1GridButtons, info));
			placeSubmarineButton.addActionListener(new placeShipAction(player1GridButtons, info));
			placeDestroyerButton.addActionListener(new placeShipAction(player1GridButtons, info));
			placeBattleShipButton.addActionListener(new placeShipAction(player1GridButtons, info));
			placeCarrierButton.addActionListener(new placeShipAction(player1GridButtons, info));
			
			MainFrame.pack();
			MainFrame.setVisible(true);

			break;
			
		case "Player 1 setup ship":
			
			if(info.isShipPlaceSuccessfully() != null)
			{
				int[] rowsForPlacingShip = info.getRowsForPlacingShip();
				int[] colsForPlacingShip = info.getColumnsForPlacingShip();
				if(info.isShipPlaceSuccessfully() == true)
				{
					lastButtonPressed.setEnabled(false);
					text.setText((lastButtonPressed.getText() + " placed successfully!"));
					for(int i = 0; i < rowsForPlacingShip.length; i++)
					{
						Border border = BorderFactory.createLineBorder(info.getColor(), 5);
						player1GridButtons[rowsForPlacingShip[i]][colsForPlacingShip[i]].setBorder(border);
						player1GridButtons[rowsForPlacingShip[i]][colsForPlacingShip[i]].setBackground(Color.WHITE);
						player1GridButtons[rowsForPlacingShip[i]][colsForPlacingShip[i]].setEnabled(false);
					}
				}else
				{
					for(int i = 0; i < rowsForPlacingShip.length; i++)
					{
						player1GridButtons[rowsForPlacingShip[i]][colsForPlacingShip[i]].setBackground(Color.WHITE);
					}
					text.setText("Error: place the ship in vertical or horizontal direction on the grid.");
				}
			}
			
			if(placeCarrierButton.isEnabled() == false && placeDestroyerButton.isEnabled() == false && placeSubmarineButton.isEnabled() == false && placeCruiserButton.isEnabled() == false && placeBattleShipButton.isEnabled() == false)
			{
				messageQueue.put(new PlayerSetupShipMessage("Player 2"));
				
				info.setShipPlaceSuccessfully(null);
				
				MainFrame.remove(player1Group);
				player1Group.remove(ButtonBox);
				player1Group.remove(text);
				player2Group.add(ButtonBox, BorderLayout.NORTH);
				player2Group.add(text, BorderLayout.SOUTH);
				MainFrame.add(player2Group);
				for(int i = 0; i < player2GridButtons.length; i++)
				{
					for(int j = 0; j < player2GridButtons.length; j++)
					{
						player2GridButtons[i][j].addActionListener(new ActionSetSelected());
					}
				}
				placeCruiserButton.setEnabled(true);
				placeBattleShipButton.setEnabled(true);
				placeCarrierButton.setEnabled(true);
				placeSubmarineButton.setEnabled(true);
				placeDestroyerButton.setEnabled(true);
				
				removeAllActionListener(placeCruiserButton);
				removeAllActionListener(placeBattleShipButton);
				removeAllActionListener(placeCarrierButton);
				removeAllActionListener(placeSubmarineButton);
				removeAllActionListener(placeDestroyerButton);
				
				placeCruiserButton.addActionListener(new placeShipAction(player2GridButtons, info));
				placeSubmarineButton.addActionListener(new placeShipAction(player2GridButtons, info));
				placeDestroyerButton.addActionListener(new placeShipAction(player2GridButtons, info));
				placeBattleShipButton.addActionListener(new placeShipAction(player2GridButtons, info));
				placeCarrierButton.addActionListener(new placeShipAction(player2GridButtons, info));
				MainFrame.pack();
				MainFrame.setVisible(true);
			}else
			{
				Message message = messageQueue.take();
				messageQueue.put(message);
				messageQueue.put(new PlayerSetupShipMessage("Player 1"));
			}
			
			break;
			
		case "Player 2 setup ship":
			
			
			if(info.isShipPlaceSuccessfully() != null)
			{
				int[] rowsForPlacingShip = info.getRowsForPlacingShip();
				int[] colsForPlacingShip = info.getColumnsForPlacingShip();
				if(info.isShipPlaceSuccessfully() == true)
				{
					lastButtonPressed.setEnabled(false);
					text.setText((lastButtonPressed.getText() + " placed successfully!"));
					for(int i = 0; i < rowsForPlacingShip.length; i++)
					{
						Border border = BorderFactory.createLineBorder(info.getColor(), 5);
						player2GridButtons[rowsForPlacingShip[i]][colsForPlacingShip[i]].setBorder(border);
						player2GridButtons[rowsForPlacingShip[i]][colsForPlacingShip[i]].setBackground(Color.WHITE);
						player2GridButtons[rowsForPlacingShip[i]][colsForPlacingShip[i]].setEnabled(false);
					}
				}else 
				{
					for(int i = 0; i < rowsForPlacingShip.length; i++)
					{
						player2GridButtons[rowsForPlacingShip[i]][colsForPlacingShip[i]].setBackground(Color.WHITE);
					}
					text.setText("Error: place the ship in vertical or horizontal direction on the grid.");
				}
			}
			
			if(placeCarrierButton.isEnabled() == false && placeDestroyerButton.isEnabled() == false && placeSubmarineButton.isEnabled() == false && placeCruiserButton.isEnabled() == false && placeBattleShipButton.isEnabled() == false)
			{
				messageQueue.put(new StartGameMessage());
				player2Group.remove(ButtonBox);
				MainFrame.remove(player2Group);
			}else {
				Message message = messageQueue.take();
				messageQueue.put(message);
				messageQueue.put(new PlayerSetupShipMessage("Player 2"));
			}

			
			break;
			
		case "Start game":
			
			for(int i = 0; i < player1GridButtons.length;i++)
			{
				for(int j = 0; j < player1GridButtons.length;j++)
				{
					player1EnemyGridButtons[i][j].addActionListener(new ActionSetSelected());
					player2EnemyGridButtons[i][j].addActionListener(new ActionSetSelected());
					player1GridButtons[i][j].setEnabled(false);
					player2GridButtons[i][j].setEnabled(false);
				}
			}
			player1Options.add(player1AttackButton);
			player1Options.add(player1SurrenderButton);
			player2Options.add(player2AttackButton);
			player2Options.add(player2SurrenderButton);
			player1AttackButton.addActionListener(new AttackListener(info, player1EnemyGridButtons));
			player2AttackButton.addActionListener(new AttackListener(info, player2EnemyGridButtons));
			player1Group.add(player1Options, BorderLayout.NORTH);
			player1Group.add(text, BorderLayout.SOUTH);
			player2Group.add(player2Options, BorderLayout.NORTH);
			player2Group.add(text2, BorderLayout.SOUTH);
			
			JPanel panel1 = new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
			panel1.add(player1Group);
			panel1.add(player2Group);
			MainFrame.add(panel1);
			MainFrame.pack();
			MainFrame.setVisible(true);
			player1GridBox.setEnabled(false);
			player2SurrenderButton.setEnabled(false);
			player2SurrenderButton.addActionListener(new SurrenderListener(info));
			player1SurrenderButton.addActionListener(new SurrenderListener(info));
			player2AttackButton.setEnabled(false);
			player2GridBox.setEnabled(false);
			player2EnemyGridBox.setEnabled(false);
			messageQueue.put(new changeTurnMessage("Player 1's turn"));
			
			break;
			
		case "Player 1's turn":
			
			player1EnemyGridBox.setEnabled(true);
			player1AttackButton.setEnabled(true);
			player1SurrenderButton.setEnabled(true);
			deactivateGridButtons(player2EnemyGridButtons, false);
			
			if(info.isHit() != null)
			{
				if(info.isHit() == true)
				{
					player2EnemyGridButtons[info.getRowForAttack()][info.getColumnForAttack()].setBackground(Color.RED);
					player1GridButtons[info.getRowForAttack()][info.getColumnForAttack()].setBackground(Color.RED);
					if(info.isSunken() != true)
					{
						text2.setText("Hit: " + info.isHit() + " Ship: " + info.getShipName() + " at Row: " + info.getRowForAttack() + " Column: " + info.getColumnForAttack());
						text.setText("Enemy attack hit: " + info.isHit() + " Ship: " + info.getShipName() + " at Row: " + info.getRowForAttack() + " Column: " + info.getColumnForAttack());
					}else
					{
						text2.setText("Sunk ship " + info.getShipName());
						text.setText("Enemy sunk ship " + info.getShipName());
					}
				}else if(info.isHit() == false)
				{
					player2EnemyGridButtons[info.getRowForAttack()][info.getColumnForAttack()].setBackground(Color.GREEN);
					player1GridButtons[info.getRowForAttack()][info.getColumnForAttack()].setBackground(Color.GREEN);
					text2.setText("Hit: " + info.isHit() + " at Row: " + info.getRowForAttack() + " Column: " + info.getColumnForAttack());
					text.setText("Enemy attack hit: " + info.isHit() + " at Row: " + info.getRowForAttack() + " Column: " + info.getColumnForAttack());
				}
			}
		
			
			Message message = messageQueue.take();
			messageQueue.put(message);
			if(!(message instanceof SurrenderMessage))				
				messageQueue.put(new changeTurnMessage("Player 2's turn"));
			
			player1AttackButton.setEnabled(false);
			player1SurrenderButton.setEnabled(false);
			player1EnemyGridBox.setEnabled(false);
			deactivateGridButtons(player2EnemyGridButtons, true);
			break;
			
		case "Player 2's turn":
			player2EnemyGridBox.setEnabled(true);
			player2AttackButton.setEnabled(true);
			player2SurrenderButton.setEnabled(true);
			deactivateGridButtons(player1EnemyGridButtons, false);
			

			if(info.isHit() == true)
			{
				player1EnemyGridButtons[info.getRowForAttack()][info.getColumnForAttack()].setBackground(Color.RED);
				player2GridButtons[info.getRowForAttack()][info.getColumnForAttack()].setBackground(Color.RED);
				if(info.isSunken() != true)
				{
					text.setText("Hit: " + info.isHit() + " Ship: " + info.getShipName() + " at Row: " + info.getRowForAttack() + " Column: " + info.getColumnForAttack());
					text2.setText("Enemy attack hit: " + info.isHit() + " Ship: " + info.getShipName() + " at Row: " + info.getRowForAttack() + " Column: " + info.getColumnForAttack());
				}
				else
				{
					text.setText("Sunk ship " + info.getShipName());
					text2.setText("Enemy sunk ship " + info.getShipName());
				}
			}else if(info.isHit() == false)
			{
				player1EnemyGridButtons[info.getRowForAttack()][info.getColumnForAttack()].setBackground(Color.GREEN);
				player2GridButtons[info.getRowForAttack()][info.getColumnForAttack()].setBackground(Color.GREEN);
				text.setText("Hit: " + info.isHit() + " at Row: " + info.getRowForAttack() + " Column: " + info.getColumnForAttack());
				text2.setText("Enemy attack hit: " + info.isHit() + " at Row: " + info.getRowForAttack() + " Column: " + info.getColumnForAttack());
			}

			
			message = messageQueue.take();
			messageQueue.put(message);
			if(!(message instanceof SurrenderMessage))
				messageQueue.put(new changeTurnMessage("Player 1's turn"));
			
			player2EnemyGridBox.setEnabled(false);
			player2AttackButton.setEnabled(false);
			player2SurrenderButton.setEnabled(false);
			deactivateGridButtons(player1EnemyGridButtons, true);
			break;
			
		case "Game over":
			MainFrame.setVisible(false);
			MainFrame = new JFrame();
			JPanel t = new JPanel();
			JTextField txt = new JTextField();
			t.setLayout(new FlowLayout());
			t.add(txt);
			txt.setText("Game over! " + info.getPlayer() + " won!");
			JButton exitButton = new JButton();
			exitButton.setText("Exit");
			exitButton.addActionListener(new ExitListener());
			t.add(exitButton);
			
			MainFrame.add(t);
			MainFrame.pack();
			MainFrame.setVisible(true);
			
			message = messageQueue.take();
			messageQueue.put(message);
		
			
			break;
			
		}

	}
	
	/**
	 * This method deactivates the entire grid of a player, mainly during battling phase when players take their respective turns
	 * @param buttons on the grid
	 * @param flag boolean true/false to toggle grid button
	 * @return Nothing
	 */
	public void deactivateGridButtons(JButton[][] buttons, boolean flag) {
		for(int i = 1; i < buttons.length; i++) //row
		{
			for(int j = 1; j < buttons.length; j++) //col
			{
				buttons[i][j].setEnabled(flag);
			}
		}
	}
	
	/**
	 * This method displays the grid matrix, row represents by numbers 1-10, columns represents by letters A-J
	 * @param panel to make each tile on the grid
	 * @param buttons to interact with each panel
	 * @return Nothing
	 */
	public void drawGrid(JPanel panel, JButton[][] buttons)
	{
		panel.setLayout(new GridLayout(11, 11));
		panel.setBorder(new LineBorder(Color.black));
		for(int i = 0; i < buttons.length; i++)
		{
			for(int j = 0; j < buttons.length; j++)
			{
				buttons[i][j] = new JButton();
				buttons[i][j].setMargin(new Insets(6, 6, 6, 6));
				buttons[i][j].setBackground(Color.WHITE);
				panel.add(buttons[i][j]);
			}
		}
		String[] letters = new String[] {"A","B","C","D","E","F","G","H","I","J","1","2","3","4","5","6","7","8","9","10"};
		buttons[0][0].setOpaque(false);
		buttons[0][0].setEnabled(false);
		for(int i = 1; i < buttons.length; i ++)
		{
			buttons[0][i].setText(letters[i-1]);
			buttons[0][i].setEnabled(false);
		}
		for(int j = 1; j < buttons[0].length; j++)
		{
			buttons[j][0].setText(letters[j+9]);
			buttons[j][0].setEnabled(false);
		}
	}
	

	/**
	 * This method destroys the Mainframe
	 * @param Nothing
	 * @return Nothing
	 */
	public void dispose()
	{
		MainFrame.dispose();
	}
	
	
private class ActionSetSelected extends AbstractAction
	{

	/**
	 * This method changes the tile color to black when selected by player, white if not
	 * @param event to detects when player selected the tile
	 * @return Nothing
	 */
		public void actionPerformed(ActionEvent event)
		{
			JButton temp = (JButton) event.getSource();
			if(temp.isEnabled() == true)
			{
				if(temp.getBackground() == Color.WHITE)
				{
					temp.setBackground(Color.black);
				}else if(temp.getBackground() == Color.RED)
				{
					
				}else
				{
					temp.setBackground(Color.WHITE);
				}
			}
		}
		
	}
private class AttackListener extends AbstractAction{
		
		GameInfo info;
		JButton[][] buttons;
		

		/**
		 * This method initiates the AttackListener class
		 * @param info containing current information of the game
		 * @param buttons so each tile can react when a player interacts with it
		 * @return Nothing
		 */
		public AttackListener(GameInfo info,JButton[][] buttons)
		{
			this.info = info;
			this.buttons = buttons;
		}
		
		/**
		 * This method checks which player performed an attack action, and making sure player selected only 1 tile to attack 
		 * @param event ActionEvent to detect which action was made by a player
		 * @return Nothing
		 */
		public void actionPerformed(ActionEvent event)
		{
			String playerName = null;
			if(event.getSource() == player1AttackButton)
				playerName = "Player 2";
			else if(event.getSource() == player2AttackButton)
				playerName = "Player 1";
			int row = 0;
			int column = 0;
			int count = 0;
			for(int i = 0; i < buttons.length;i++)
			{
				for(int j = 0; j < buttons.length;j++)
				{
					if(buttons[i][j].getBackground() == Color.black)
					{
						count++;
						row = i;
						column = j;
					}
				}
			}
			if(count == 1)
			{
				buttons[row][column].setEnabled(false);
				buttons[row][column].setBackground(Color.black);
				try {
					messageQueue.put(new AttackMessage(row, column, playerName));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JButton source = (JButton) event.getSource();
				source.setEnabled(false);
			}
			else
				text.setText("Choose exactly 1 square for attacking");
		}
	}
	
private class SurrenderListener extends AbstractAction{
	GameInfo info;
	
	/**
	 * This method initiates the surrenderListener class
	 * @param info contains current game info
	 * @return Nothing
	 */
	public SurrenderListener(GameInfo info)
	{
		this.info = info;
	}
	
	/**
	 * This method detects when a player surrenders
	 * @param e ActionEvent to detect which action was made by a player
	 * @return Nothing
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			messageQueue.put(new SurrenderMessage(info.getPlayer()));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}

private class ExitListener extends AbstractAction{

	/**
	 * This method detects when a player exits the game
	 * @param e ActionEvent to detect which action was made by a player
	 * @return Nothing
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			messageQueue.put(new GameOverMessage());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}

	private class placeShipAction extends AbstractAction
	{
		private JButton[][] buttons;
		private GameInfo info;
		
		/**
		 * This method initializes placeShipAction class
		 * @param buttons so each tile can react when a player interacts with it
		 * @param info containing current information of the game
		 * @return Nothing
		 */
		public placeShipAction(JButton[][] buttons, GameInfo info)
		{
			this.buttons = buttons;
			this.info = info;
		}
		
		/**
		 * This method detects when a player places a ship on grid
		 * @param event ActionEvent to detect which action was made by a player
		 * @return Nothing
		 */
		public void actionPerformed(ActionEvent event)
		{
				ArrayList<Integer> rows = new ArrayList<Integer>();
				ArrayList<Integer> columns = new ArrayList<Integer>();
				for(int i = 0; i < buttons.length; i++)
				{
				for(int j = 0; j < buttons.length; j++)
				{
					if(buttons[i][j].getBackground() == Color.black)
					{
						rows.add(i);
						columns.add(j);
					}
				}
				}
				
				int[] row = new int[rows.size()];
				for(int i = 0; i < rows.size();i++)
				{
					row[i] = rows.get(i);
				}
				int[] column = new int[columns.size()];
				for(int i = 0; i < columns.size();i++)
				{
					column[i] = columns.get(i);
				}
				
			
				int length = -1;
				String ship = "";
				Message message = null;
				Color color = null;

				
				if(event.getSource() == (JButton) placeCruiserButton)
				{
					color = Color.CYAN;
					ship = "Cruiser";
					length = 3;
					message = new PlaceShipMessage(row, column, info.getPlayer(), "Cruiser", color);
				}else if(event.getSource() == (JButton) placeBattleShipButton)
				{
					color = Color.YELLOW;
					ship = "Battleship";
					length = 4;
					message = new PlaceShipMessage(row, column, info.getPlayer(), "Battleship", color);
				}else if(event.getSource() == (JButton) placeCarrierButton)
				{
					color = Color.BLUE;
					ship = "Carrier";
					length = 5;
					message = new PlaceShipMessage(row, column, info.getPlayer(), "Carrier", color);
				}else if(event.getSource() == (JButton) placeSubmarineButton)
				{
					color = Color.MAGENTA;
					ship = "Submarine";
					length = 3;
					message = new PlaceShipMessage(row, column, info.getPlayer(), "Submarine", color);
				}else if(event.getSource() == (JButton) placeDestroyerButton)
				{
					color = Color.PINK;
					ship = "Destroyer";
					length = 2;
					message = new PlaceShipMessage(row, column, info.getPlayer(), "Destroyer", color);
				}
				
				if(rows.size() != length)
				{
					text.setText("Error: Select " + length + " squares for a " + ship + " ship." );
					return;
				}
				try {
					messageQueue.put(message);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lastButtonPressed = (JButton) event.getSource();
				return;
			
				
					
		}
	}
	
/**
* This method removes all action listeners
* @param button JButtons to remove action listeners
* @return Nothing
*/
public void removeAllActionListener(JButton button)
{
	for(ActionListener action : button.getActionListeners()) {
        button.removeActionListener(action);
    }
}

}
