package com.firecopyx;

import java.util.HashSet;

public class Cell
{
	int row, column;
	
	public Cell north, south, east, west;
	
	public HashSet<Cell> linkedCells;
	
	/**
	 * Constructs the cell given the position in the grid.
	 * @param row
	 * @param column
	 */
	Cell(int row, int column)
	{
		this.row = row;
		this.column = column;
		linkedCells = new HashSet<Cell>();
	}
	
	/**
	 * Links two cells. bidirectional flag determines if other cell will link to this cell.
	 * @param cell
	 * @param bidirectional
	 */
	public void link(Cell cell, boolean bidirectional)
	{
		linkedCells.add(cell);
		if (bidirectional)
		{
			cell.link(this, false);
		}
	}
	
	/**
	 * Links two cells. Assumes bidirectional.
	 * @param cell
	 */
	public void link(Cell cell)
	{
		this.link(cell, true);
	}
	
	/**
	 * Returns if this cell is linked to the given cell.
	 * @param cell
	 * @return boolean
	 */
	public boolean isLinked(Cell cell)
	{
		return linkedCells.contains(cell);
	}
}
 