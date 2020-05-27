package edu.sjsu.cs.cs151.controller;
import java.awt.Color;

/**
 * <h1>GameInfo Class</h1>
 * <p>
 * Stores and keep track of various information in the game, such as current state of the game and actions made by each player
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public class GameInfo {
	
	
	private String state;
	private String player;
	private Boolean hit;
	private int rowForAttack;
	private int columnForAttack;
	private Color color;
	private String shipName;
	private Boolean Sunken;
	
	private Boolean isShipPlaceSuccessfully;
	private int[] rowsForPlacingShip;
	private int[] columnsForPlacingShip;
	
	/**
	 * This method initalizes and sets up GameInfo class
	 * @param Nothing
	 * @return Nothing
	 */
	public GameInfo()
	{
		state = "";
		player = "";
		hit = null;
		rowForAttack = -1;
		columnForAttack = -1;
		
		isShipPlaceSuccessfully = null;
		rowsForPlacingShip = null;
		columnsForPlacingShip = null;
		String shipName = null;
		Sunken = null;
	}

	/**
	 * This method gets the current state of the game
	 * @param Nothing
	 * @return state of the game
	 */
	public String getState() {
		return state;
	}

	/**
	 * This method sets the current state of the game
	 * @param state to set the state of the game
	 * @return Nothing
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * This method gets the current player
	 * @param Nothing
	 * @return player currently 
	 */
	public String getPlayer() {
		return player;
	}

	/**
	 * This method sets the current player
	 * @param player to set the current player
	 * @return Nothing
	 */
	public void setPlayer(String player) {
		this.player = player;
	}

	/**
	 * This method checks if a ship was hit
	 * @param Nothing
	 * @return hit boolean true/false
	 */
	public Boolean isHit() {
		return hit;
	}

	/**
	 * This method set the hit boolean
	 * @param hit is true if a ship was hit, false otherwise
	 * @return Nothing
	 */
	public void setHit(Boolean hit) {
		this.hit = hit;
	}

	/**
	 * This method gets the row position to attack
	 * @param Nothing
	 * @return rowForAttack value chosen for attack
	 */
	public int getRowForAttack() {
		return rowForAttack;
	}
	
	/**
	 * This method sets the row value to attack
	 * @param rowForAttack value to change the row being attacked
	 * @return Nothing
	 */
	public void setRowForAttack(int rowForAttack) {
		this.rowForAttack = rowForAttack;
	}
	
	/**
	 * This method gets the column position to attack
	 * @param Nothing
	 * @return columnForAttack value chosen for attack
	 */
	public int getColumnForAttack() {
		return columnForAttack;
	}
	
	/**
	 * This method sets the row value to attack
	 * @param columnforAttack value to change the column being attacked
	 * @return Nothing
	 */
	public void setColumnForAttack(int columnForAttack) {
		this.columnForAttack = columnForAttack;
	}
	
	/**
	 * This method checks if a ship was placed successfully
	 * @param Nothing
	 * @return isShipPlaceSuccessfully boolean if a ship was placed within the grid boundary
	 */
	public Boolean isShipPlaceSuccessfully() {
		return isShipPlaceSuccessfully;
	}
	
	/**
	 * This method sets the isShipPlaceSuccessfully boolean when player places the ship
	 * @param isShipPlaceSuccessfully is true if ship was successfully placed, false otherwise
	 * @return Nothing
	 */
	public void setShipPlaceSuccessfully(Boolean isShipPlaceSuccessfully) {
		this.isShipPlaceSuccessfully = isShipPlaceSuccessfully;
	}
	
	/**
	 * This method gets the row to place the ship
	 * @param Nothing
	 * @return rowsForPlacingShip 
	 */
	public int[] getRowsForPlacingShip() {
		return rowsForPlacingShip;
	}
	
	/**
	 * This method sets row to place the ship
	 * @param rowsForPlacingShip value chosen by player to position the ship
	 * @return Nothing
	 */
	public void setRowsForPlacingShip(int[] rowsForPlacingShip) {
		this.rowsForPlacingShip = rowsForPlacingShip;
	}
	
	/**
	 * This method gets the column to place the ship
	 * @param Nothing
	 * @return columnsForPlacingShip 
	 */
	public int[] getColumnsForPlacingShip() {
		return columnsForPlacingShip;
	}
	
	/**
	 * This method sets column to place the ship
	 * @param columnsForPlacingShip value chosen by player to position the ship
	 * @return Nothing
	 */
	public void setColumnsForPlacingShip(int[] columnsForPlacingShip) {
		this.columnsForPlacingShip = columnsForPlacingShip;
	}
	
	/**
	 * This method gets the color of the cell
	 * @param Nothing
	 * @return color of the cell
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * This method sets the color of the cell
	 * @param color to sets the current color of a cell
	 * @return Nothing
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * This method gets the name of the ship
	 * @param Nothing
	 * @return shipName current name of the ship
	 */
	public String getShipName() {
		return shipName;
	}
	
	/**
	 * This method sets the name of a ship
	 * @param shipName to set the current name of a ship
	 * @return Nothing
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	/**
	 * This method checks if a ship was destroyed
	 * @param Nothing
	 * @return Sunken boolean is true when ship health reaches 0, false otherwise
	 */
	public Boolean isSunken() {
		return Sunken;
	}
	
	/**
	 * This method sets the state of a ship
	 * @param Sunken boolean true if a ship health reached 0, false otherwise
	 * @return Nothing
	 */
	public void setSunken(Boolean Sunken) {
		this.Sunken = Sunken;
	}
	
	


	

	
}
