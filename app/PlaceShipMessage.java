package edu.sjsu.cs.cs151.app;
import java.awt.Color;

/**
 * <h1>PlaceShipMessage class</h1>
 * <p>
 * Sends message to the controller to initiate ship placement module
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public class PlaceShipMessage extends Message{
	
	private int[] row;
	private int[] col;
	private String shipName;
	private Color color;
	
	/**
	 * This method initalizes AttackMessage class
	 * @param row point (1-10)
	 * @param col point (1-10)
	 * @param playerName (player 1 or player 2)
	 * @param shipName (ship type; carrier, battleship, cruiser, submarine, destroyer)
	 * @return Nothing
	 */
	public PlaceShipMessage(int[] row, int[] col, String playerName, String shipName, Color color)
	{
		this.row = row;
		this.col = col;
		super.setPlayerName(playerName);
		this.shipName = shipName;
		this.color = color;
	}
	
	/**
	 * This method gets the row to place the ship
	 * @param Nothing
	 * @return row chosen to place the ship
	 */
	public int[] getRow() {
		return row;
	}
	
	/**
	 * This method sets the row to place the ship
	 * @param row chosen to place ship
	 * @return Nothing
	 */
	public void setRow(int[] row) {
		this.row = row;
	}
	
	/**
	 * This method gets the column to place the ship
	 * @param Nothing
	 * @return column to place ship
	 */
	public int[] getCol() {
		return col;
	}
	
	/**
	 * This method sets the column to place the ship
	 * @param column chosen to place the ship
	 * @return Nothing
	 */
	public void setCol(int[] col) {
		this.col = col;
	}
	
	/**
	 * This method gets the current player
	 * @param Nothing
	 * @return getPlayerName from the super message class
	 */
	public String getPlayerName() {
		return super.getPlayerName();
	}
	
	/**
	 * This method sets player name in the message super class
	 * @param playerName to set the playerName parameter in message super class
	 * @return Nothing
	 */
	public void setPlayerName(String playerName) {
		super.setPlayerName(playerName);
	}
	
	/**
	 * This method gets the ship type to be place
	 * @param Nothing
	 * @return shipName type of ship
	 */
	public String getShipName() {
		return shipName;
	}
	
	/**
	 * This method sets the ship to be place
	 * @param shipName ship type to be place 
	 * @return Nothing
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	/**
	 * This method gets the color of the ship type
	 * @param Nothing
	 * @return color of the ship 
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * This method sets the color of the ship type
	 * @param color of the ship 
	 * @return Nothing
	 */
	public void setColor(Color color) {
		this.color = color;
	}


}
