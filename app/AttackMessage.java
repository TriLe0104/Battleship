package edu.sjsu.cs.cs151.app;
/**
 * <h1>AttackMessage class</h1>
 * <p>
 * Sends message to the controller to initiate an attack
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public class AttackMessage extends Message{

	
	int row;
	int column;
	
	/**
	 * This method initalizes AttackMessage class
	 * @param row point (1-10)
	 * @param col point (1-10)
	 * @param playerName (player 1 or player 2)
	 * @return Nothing
	 */
	public AttackMessage(int row, int column, String playerName)
	{
		this.row = row;
		this.column = column;
		super.setPlayerName(playerName);
	}
	
	/**
	 * This method gets the row to be attack
	 * @param Nothing
	 * @return row to be attack
	 */
	public int getRow()
	{
		return row;
	}
	/**
	 * This method gets the column to be attack
	 * @param Nothing
	 * @return column to be attack
	 */
	public int getCol()
	{
		return column;
	}
	/**
	 * This method sets the row to be attack
	 * @param row chosen for attack
	 * @return Nothing
	 */
	public void setRow(int row)
	{
		this.row = row;
	}
	
	/**
	 * This method sets the column to be attack
	 * @param column chosen for attack
	 * @return Nothing
	 */
	public void setCol(int column)
	{
		this.column = column;
	}
	/**
	 * This method gets the current player
	 * @param Nothing
	 * @return getPlayerName from the super message class
	 */
	public String getPlayerName()
	{
		return super.getPlayerName();
	}
	/**
	 * This method sets player name in the message super class
	 * @param playerName to set the playerName parameter in message super class
	 * @return Nothing
	 */
	public void setPlayerName(String playerName)
	{
		super.setPlayerName(playerName);
	}
}