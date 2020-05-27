package edu.sjsu.cs.cs151.app;

/**
 * <h1>PlayerSetupMessage class</h1>
 * <p>
 * Sends message to the controller to initiate player setting up module
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public class PlayerSetupShipMessage extends Message{

	/**
	 * This method initalizes PlayerSetupShipMessage
	 * @param playerName (player 1 or player 2) to set the playerName in the message super class
	 * @return Nothing
	 */
	public PlayerSetupShipMessage(String playerName)
	{
		super.setPlayerName(playerName);
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
