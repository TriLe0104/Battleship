package edu.sjsu.cs.cs151.model;

/**
 * <h1>Grid Class</h1>
 * <p>
 * Grid board of size 10x10. Each player will have two grids of their own, one to place their ships and the other to make and mark attacks.
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public class Grid {
	
	private Cell[][] gridCells;
	/**
	 * This method initalizes a a grid object of size 10x10
	 * @param Nothing
	 * @return Nothing
	 */
	public Grid()
	{
		gridCells = new Cell[10][10];
	}
	
	/**
	 * This method setups the grid by creating 100 cell objects
	 * @param Nothing
	 * @return Nothing
	 */
	public void setupGrid()
	{
		for(int i = 0; i < gridCells.length; i++)
		{
			for(int j = 0; j < gridCells.length; j++)
			{
				gridCells[i][j] = new Cell();
			}
		}
	}
	
	/**
	 * This method places a ship on a cell, following strict guidelines in model
	 * @param row the vertical index (1-10)
	 * @param col the horizontal index (1-10)
	 * @param ship object to be placed in the cell.
	 * @return Nothing
	 */
	public void placeShipOntoCell(int row, int column, Ship ship)
	{
		gridCells[row][column].setShip(ship);
	}
	
	/**
	 * This method gets the double array of cells
	 * @param Nothing
	 * @return Nothing
	 */
	public Cell[][] getGridCells() {
		return gridCells;
	}

	/**
	 * This method sets the grid cells
	 * @param gridCells double array of cells to change the current gridCells 
	 * @return Nothing
	 */
	public void setGridCells(Cell[][] gridCells) {
		this.gridCells = gridCells;
	}


}
