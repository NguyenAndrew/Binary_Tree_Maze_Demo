package com.firecopyx;

public class BinaryTreeDemo
{
	public static void main(String[] args)
	{
		Grid grid = new Grid(4,4);
		BinaryTree.apply(grid);
		System.out.println(grid);
	}
}
