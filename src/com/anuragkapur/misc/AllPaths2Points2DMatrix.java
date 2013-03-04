package com.anuragkapur.misc;

/**
 * Problem Statment: Refer README
 * 
 * Assumptions:
 * <li>
 * Starting point assumed (0,0), matrix top left point is (0,0)
 * </li>
 * <li>
 * Movement from a given path can only be downward or to the right. Diagonal not allowed.
 * </li>
 * 
 * @author anuragkapur
 */
public class AllPaths2Points2DMatrix {

	// matrix dimensions
	private static int maxRows = 5;
	private static int maxColumns = 4;
	
	// end point
	private static int endX = 2;
	private static int endY = 2;
	
	private static int count;
	
	/**
	 * Depth first search
	 * 
	 * @param x
	 * @param y
	 * @param path
	 */
	private static void dfs(int x, int y, String path) {
		
		if(x < endX) {
			dfs(x+1 ,y, path+"("+x+","+y+")");
		}
		if(y < endY) {
			dfs(x, y+1, path+"("+x+","+y+")");
		}
		if(x == endX && y == endY) {
			path += "("+x+","+y+")";
			System.out.format("Path number:%d found\n",++count);
			System.out.println("Path :: " + path);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// start from the origin
		dfs(0, 0, "");
	}
}