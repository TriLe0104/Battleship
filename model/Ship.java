package edu.sjsu.cs.cs151.model;
import java.awt.Color;

/**
 * <h1>Ship enum</h1>
 * <p>
 * Ship class containing the 5 ship types of varied lengths in a standard battleship game.
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public enum Ship{
	
	/**
	 * player1DESTROYER Ship of size 2
	 */
	player1DESTROYER("Destroyer", 2, 2), 
	/**
	 * player1SUBMARINE Ship of size 3
	 */
	player1SUBMARINE("Submarine", 3, 3),
	/**
	 * player1CRUISER Ship of size 3
	 */
	player1CRUISER("Cruiser", 3, 3),
	/**
	 * player1BATTLESHIP Ship of size 4
	 */
	player1BATTLESHIP("Battleship", 4, 4), 
	/**
	 * player1CARRIER Ship of size 5
	 */
	player1CARRIER("Carrier", 5, 5),
	
	/**
	 * player1DESTROYER Ship of size 2
	 */
	player2DESTROYER("Destroyer", 2, 2),
	/**
	 * player2SUBMARINE Ship of size 3
	 */
	player2SUBMARINE("Submarine", 3, 3), 
	/**
	 * player2CRUISER Ship of size 3
	 */
	player2CRUISER("Cruiser", 3, 3), 
	/**
	 * player2BATTLESHIP Ship of size 4
	 */
	player2BATTLESHIP("Battleship", 4, 4), 
	/**
	 * player2CARRIER Ship of size 5
	 */
	player2CARRIER("Carrier", 5, 5);

	private String shipName;
	private int length;
	private int shipHealth;
	private boolean sunken;
	
	/**
	 * This method initalizes a ship object
	 * @param shipName, length, shipHealth
	 * @return Nothing
	 */
	Ship(String shipName, int length, int shipHealth)
	{
		this.shipName = shipName;
		this.length = length;
		this.shipHealth = shipHealth;
		sunken = false;
	}
	
	/**
	 * This method prints the string representation of the ship
	 * @param Nothing
	 * @return shipName, length, shipHealth
	 */
	public String toString()
	{
		return ("Ship Name: " + shipName + " Length:" + length + " Health:" + shipHealth);
	}
	
	/**
	 * This method gets the name of the ship
	 * @param Nothing
	 * @return String shipName
	 */
	public String getShipName()
	{
		return shipName;
	}
	
	/**
	 * This method sets the name of the ship
	 * @param name string to change current name of a ship
	 * @return Nothing
	 */
	public void setShipName(String name)
	{
		this.shipName = name;
	}
	
	/**
	 * This method gets the length of the ship
	 * @param Nothing
	 * @return integer length
	 */
	public int getLength()
	{
		return this.length;
	}
	
	/**
	 * This method sets the length of the ship
	 * @param length value to change current length of a ship
	 * @return Nothing
	 */
	public void setLength(int length)
	{
		this.length = length;
	}
	
	/**
	 * This method gets the current health of the ship
	 * @param Nothing
	 * @return shipHealth
	 */
	public int getHealth()
	{
		return this.shipHealth;
	}
	
	/**
	 * This method sets the health of the ship
	 * @param Health value to change current health of the a ship
	 * @return Nothing
	 */
	public void setHealth(int Health)
	{
		this.shipHealth = Health;
	}
	
	/**
	 * This method returns the current state of the ship
	 * @param Nothing
	 * @return sunken = True if shipHealth equals 0, otherwise sunken = false
	 */
	public boolean isSunken()
	  {
	    if (shipHealth == 0)
	    {
	      sunken = true;
	      return sunken;
	    }
	    return sunken;
	  }
}