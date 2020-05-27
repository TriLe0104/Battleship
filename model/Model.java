package edu.sjsu.cs.cs151.model;
public class Model {
	
	/**
	 * <h1>Model class</h1>
	 * <p>
	 * Allowing 2 players to place 5 ships on their own grid, checking a player's grid at a chosen coordinate for ship placement, and a victory condition if all the ships in a player's arsenal were destroyed.
	 * 
	 * @author Au, Phu, Tri
	 * @version 1.0
	 * @since 11-29-2018
	 */

	
	private Player player1;
	private Player player2;
	
	/**
	 * This method initalizes the model, creating 2 new player objects with their own ships
	 * @param Nothing
	 * @return Nothing
	 */
	public Model()
	{
		player1 = new Player(Ship.player1DESTROYER, Ship.player1SUBMARINE, Ship.player1CRUISER, Ship.player1BATTLESHIP, Ship.player1CARRIER);
		player2 = new Player(Ship.player2DESTROYER, Ship.player2SUBMARINE, Ship.player2CRUISER, Ship.player2BATTLESHIP, Ship.player2CARRIER);
		
	}
	
	/**
	 * This method gets Player 1
	 * @param Nothing
	 * @return player1
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * This method sets Player 1
	 * @param Player player1
	 * @return Nothing
	 */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	/**
	 * This method gets Player 2
	 * @param Nothing
	 * @return player2
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * This method sets Player 2
	 * @param Player player2
	 * @return Nothing
	 */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	/**
	 * This method allows a player to place all 5 ships on their grid vertically or horizontally
	 * @param row point (1-10)
	 * @param col point (1-10)
	 * @param playerName name of the player, use to identify player1 and player2
	 * @param shipName name of the ship, to identify which ship is being placed. (Not used, replaced with enum)
	 * @return boolean true/false
	 */
	public Boolean placeShip(int[] row, int[] col, String playerName, String shipName)
	{
		Player player = null;
		Ship ship = null;
		if(playerName.equals("Player 1"))
			player = this.getPlayer1();
		else if(playerName.equals("Player 2"))
			player = this.getPlayer2();
		if(shipName.equals("Battleship"))
			ship = player.getShips()[3];
		else if(shipName.equals("Carrier"))
			ship = player.getShips()[4];
		else if(shipName.equals("Destroyer"))
			ship = player.getShips()[0];
		else if(shipName.equals("Cruiser"))
			ship = player.getShips()[2];
		else if(shipName.equals("Submarine"))
			ship = player.getShips()[1];
		
		boolean Horizontal = true;
		boolean Vertical = false;
		for(int i = 0; i < row.length - 1; i++)
		{
			if(row[i] != row[i+1])
			{
				Horizontal = false;
				Vertical = true;
				break;
			}
		}
		
		if(Vertical == true)
		{
			for(int i = 0; i < col.length - 1; i++)
			{
				if(col[i] != col[i+1])
					Vertical = false;
			}
		}
		
		if(Horizontal == true)
		{
			for(int i = 0; i < col.length - 1;i++)
			{
				if(col[i] + 1 != col[i+1])
					return false;
			}
			for(int i = 0; i < col.length; i++)
			{
				player.getGrid().placeShipOntoCell(row[i]-1, col[i]-1, ship);
			}
			return true;
		
		}else if(Vertical == true)
		{
			for(int i = 0; i< row.length-1; i++)
			{
				if(row[i]+1 != row[i+1])
					return false;
			}
			for(int i = 0; i < row.length; i++)
			{
				player.getGrid().placeShipOntoCell(row[i]-1, col[i]-1, ship);
			}
			return true;
		}
		
		return false;

	}

	/**
	 * This method checks if an attack made by a player's chosen coordinate hit/miss a ship in the other player's grid
	 * @param row point (1-10)
	 * @param col point (1-10)
	 * @param playerName name of the player, use to identify player1 and player2
	 * @return boolean true/false
	 */
	public Boolean attack(int row, int col, String playerName)
	{
		Player player = null;
		if (playerName.equals("Player 1"))
			player = getPlayer1();
		else if(playerName.equals("Player 2"))
			player = getPlayer2();
		
		if(player.getGrid().getGridCells()[row - 1][col - 1].checkHit() == true)
		{
			System.out.println("Hit at row:" + row+ " column: " + col);
			return true;
		}
		
		return false;


	}
	
	/**
	 * This method finds the ship type that was attacked
	 * @param row point (1-10)
	 * @param col point (1-10)
	 * @param playerName (player 1 or player 2)
	 * @return player.getGrid().getGridCells()[row-1][col-1].getShip().getShipName() the ship type in a player's grid at position (row, col)
	 */
	public String getShipAttacked(int row, int col, String playerName)
	{
		Player player = null;
		if (playerName.equals("Player 1"))
			player = getPlayer1();
		else if(playerName.equals("Player 2"))
			player = getPlayer2();
		
		return player.getGrid().getGridCells()[row-1][col-1].getShip().getShipName();
	}
	
	/**
	 * This method checks if a ship is completely destroyed
	 * @param row point (1-10)
	 * @param col point (1-10)
	 * @param playerName (player 1 or player 2)
	 * @return boolean true or false, if a ship was completely sunk (when health reaches 0)
	 */
	public Boolean isShipSunk(int row, int col, String playerName)
	{
		Player player = null;
		if (playerName.equals("Player 1"))
			player = getPlayer1();
		else if(playerName.equals("Player 2"))
			player = getPlayer2();
		
		if(player.getGrid().getGridCells()[row-1][col-1].getShip().isSunken() == true)
		{
			return true;
		}
		
		return false;
	}
	

	/**
	 * This method checks ships remaining in a player's grid, if a player's ship count reaches 0, the other player is victorious
	 * @param playerName (player 1 or player 2)
	 * @return boolean true or false if a player have no ship remaining
	 */
	public boolean checkifLost(String playerName)
	{
		Player player = null;
		if(playerName.equals("Player 1"))
			player = getPlayer1();
		else if(playerName.equals("Player 2"))
			player = getPlayer2();
		
		if(player.getSunkenShips() == 5)
		{
			return true;
		}else
			return false;
	}
	
	
	
}
