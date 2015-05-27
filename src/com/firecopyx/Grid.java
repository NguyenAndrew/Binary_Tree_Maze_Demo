package com.firecopyx;

public class Grid
{
	int rows, columns;
	public Cell[][] grid;
	
	/**
	 * Constructs the grid given rows and columns. 
	 * @param rows
	 * @param columns
	 */
	Grid(int rows, int columns)
	{
		this.rows = rows;
		this.columns = columns;
		
		grid = prepareGrid();
		configureCells();
	}
	
	/**
	 * Fills the grid with empty cells
	 * @return Cell[][]
	 */
	private Cell[][] prepareGrid()
	{
		Cell[][] grid = new Cell[rows][columns];
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				grid[i][j] = new Cell(i,j);
			}
		}
		return grid;
	}
	
	/**
	 * Connects the cells in the grid with its adjacent cells.
	 */
	private void configureCells()
	{
		for(int rowInd = 0; rowInd < rows; rowInd++)
		{
			for(int colInd = 0; colInd < columns; colInd++)
			{
				Cell cellReference = grid[rowInd][colInd];
				cellReference.north = getCell(rowInd - 1, colInd);
				cellReference.south = getCell(rowInd + 1, colInd);
				cellReference.west = getCell(rowInd, colInd - 1);
				cellReference.east =  getCell(rowInd, colInd + 1);
			}
		}
	}

	/**
	 * Gets the cell at the given row and column. If row or column is invalid, returns null.
	 * @param row
	 * @param column
	 * @return
	 */
	Cell getCell(int row, int column)
	{
		if (row < 0 || row >= this.rows || column < 0 || column >= this.columns)
		{
			return null;
		} 
		return grid[row][column];
	}

	@Override
	public String toString()
	{
		StringBuilder output = new StringBuilder("+");

		for (int i = 0; i < columns; i++)
		{
			output.append("---+");
		}
		output.append("\n");
		
		
		for(int rowInd = 0; rowInd < rows; rowInd++)
		{
			StringBuilder top = new StringBuilder("|");
			StringBuilder bottom = new StringBuilder("+");
			
			for (int colInd = 0; colInd < columns; colInd++)
			{
				Cell cell = getCell(rowInd, colInd);
				if (cell == null)
				{
					cell = new Cell(-1, -1);
				}
				
				String body = "   ";
				String eastBoundary =  cell.isLinked(cell.east) ? " " : "|";
				top.append(body);
				top.append(eastBoundary);
				
				String southBoundary = cell.isLinked(cell.south) ? "   " : "---";
				String corner = "+";
				bottom.append(southBoundary);
				bottom.append(corner);
			}
			
			output.append(top);
			output.append("\n");
			output.append(bottom);
			output.append("\n");
		}
		
		return output.toString();
	}
	
}
