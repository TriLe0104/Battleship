package edu.sjsu.cs.cs151.app;

/**
 * <h1>changeTurnMessage class</h1>
 * <p>
 * Sends message to the controller to switch player's turn
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public class changeTurnMessage extends Message{
	
	/**
	 * This method initialize changeTurnMessage for each player
	 * @param playerName to setup the turn message for the respective player
	 * @return Nothing
	 */
 	public changeTurnMessage(String playerName)
	{
		super.setPlayerName(playerName);
	}
	
	/**
	 * This method gets the player name
	 * @param Nothing
	 * @return getPlayName() method in the message super class
	 */
	public String getPlayerName()
	{
		return super.getPlayerName();
	}
	
	/**
	 * This method sets the player name
	 * @param playerName string value to set the playerName in the message super class
	 * @return Nothing
	 */
	public void setPlayerName(String playerName)
	{
		super.setPlayerName(playerName);
	}
}