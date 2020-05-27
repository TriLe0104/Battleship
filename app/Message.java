package edu.sjsu.cs.cs151.app;
import java.io.Serializable;

/**
 * <h1>Message class</h1>
 * <p>
 * The message super class, mainly to distinguish the messages for each player
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public abstract class Message implements Serializable{
	
	private String playerName;

	/**
	 * This method gets the player's name
	 * @param Nothing
	 * @return playerName current player
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * This method sets the player's name
	 * @param playerName to be set
	 * @return Nothing
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	
	




	
}
