package edu.sjsu.cs.cs151.model;

/**
 * <h1>Cell Class</h1>
 * <p>
 * Each cell is a box in the grid, and can hold a piece of a ship (ie ship have length 2, it would use up 2 cells to place)
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public class Cell {

	private boolean hasShip;
	private Ship ship;
	private boolean hit;
	
	/**
	 * This method initalizes a cell
	 * @param Nothing
	 * @return Nothing
	 */
	public Cell()
	{
		hasShip = false;
		ship = null;
		hit = false;
	}

	/**
	 * This method returns a ship
	 * @param Nothing
	 * @return ship object
	 */
	public Ship getShip()
	{
		return ship;
	}
	
	/**
	 * This method checks if cell contains a ship
	 * @param Nothing
	 * @return boolean hasShip
	 */
	public boolean hasShip()
	{
		return hasShip;
	}
	
	/**
	 * This method initalizes a cell
	 * @param Nothing
	 * @return Nothing
	 */
	public void setShip(Ship ship)
	{
		this.ship = ship;
		hasShip = true;
	}

	/**
	 * This method checks if an attack made on the cell is successful
	 * @param Nothing
	 * @return boolean hit
	 */
	public boolean checkHit()
	{
		if(this.hasShip == true)
		{
			hit = true;
			ship.setHealth(ship.getHealth() - 1);
			ship.isSunken();
			return hit;
		}
		return hit;
	}

}
