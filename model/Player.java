package edu.sjsu.cs.cs151.model;

/**
 * <h1>Player class</h1>
 * <p>
 * Player class containing its own grid board and 5 ship objects
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public class Player {
	
	private final Ship[] ships = new Ship[5];
	private final Grid playergrid;
	private int sunkenShips;
	private int shotsFired;
	
	/**
	 * This method initalizes a player, creating the ships and grid
	 * @param one destroyer
	 * @param two submarine
	 * @param three cruiser
	 * @param four battleship
	 * @param five carrier
	 * 
	 * @return Nothing
	 */
	public Player(Ship one, Ship two, Ship three, Ship four, Ship five)
	{
		ships[0] = one;
		ships[1] = two;
		ships[2] = three;
		ships[3] = four;
		ships[4] = five;
		playergrid = new Grid();
	}

	/**
	 * This method gets the amount of ships that was destroyed by checking if each of the 5 ships was sunken
	 * @param Nothing
	 * @return sunkenShips amount of ships whose health reached 0
	 */
	public int getSunkenShips() {
		
		setSunkenShips(0);
		
		for(int i = 0; i < ships.length; i++)
		{
			if(ships[i].isSunken() == true)
			{
				sunkenShips++;
			}
		}
		return sunkenShips;
	}

	/**
	 * This method sets the amount of ships that were sunk
	 * @param sunkenShips amount of ships whose health reached 0
	 * @return Nothing
	 */
	public void setSunkenShips(int sunkenShips) {
		this.sunkenShips = sunkenShips;
	}

	/**
	 * This method checks if user fired a shot
	 * @param Nothing
	 * @return shotsFired
	 */
	public int getShotsFired() {
		return shotsFired;
	}

	/**
	 * This method sets shotsFired when player fired a shot
	 * @param shotsFired value to change player's current firing status
	 * @return Nothing
	 */
	public void setShotsFired(int shotsFired) {
		this.shotsFired = shotsFired;
	}
	
	/**
	 * This method gets all the ships in player's possession
	 * @param shipName, length, shipHealth
	 * @return ships
	 */
	public Ship[] getShips() {
		return ships;
	}

	/**
	 * This method gets player's grid board
	 * @param Nothing
	 * @return playergrid
	 */
	public Grid getGrid() {
		return playergrid;
	}

}
