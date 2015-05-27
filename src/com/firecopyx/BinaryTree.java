package com.firecopyx;

import java.util.ArrayList;
import java.util.Random;

public class BinaryTree
{
	/**
	 * Applies the Binary Tree Maze algorithm to the given grid.
	 * @param grid
	 * @return
	 */
	public static void apply(Grid grid)
	{
		for (int i = 0; i < grid.rows; i++)
		{
			for (int j = 0; j < grid.columns; j++)
			{
				Cell cell = grid.grid[i][j];
				ArrayList<Cell> neighbors = new ArrayList<Cell>();
				
				if (cell.north != null)
				{
					neighbors.add(cell.north);
				}
				
				if (cell.east != null)
				{
					neighbors.add(cell.east);
				}
				
				// Empty Set of Neighbors (Top-Right corner of the maze).
				if (neighbors.size() == 0)
				{
					continue;
				}
				
				Random rand = new Random();
				int ind = rand.nextInt(neighbors.size());
				cell.link(neighbors.get(ind));
			}
		}

	}
}
