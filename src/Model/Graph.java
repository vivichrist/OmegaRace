package Model;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;

public class Graph {

	private HashMap<Point2D,Tile> tileMap; //map of point addresses and tiles for navigation

	public Graph(int col, int row, ScoreBoard scoreBoard) {

		generateTileList(col, row, scoreBoard);//generate initial board of tiles
		generateGraph(); //generate graph data structure
	}

	/**
	 * Method responsible for connecting the tiles up according to the specified graph
	 * Structure, i.e. neighbours: N, NE, E, SE, S, SW, W, NW
	 */

	public void generateGraph() {
		for (Tile tile : tileMap.values()) {

			Rectangle2D bounds = tile.bounds();	//get tile bounds

			int x = (int) bounds.getX(); //xpos in map
			int y = (int) bounds.getY(); //ypos in map

				/**only adds to graph if value retrieved via key does not equal null*/

				//west
				tile.addNeighbour(tileMap.get(new Point(x-1,y)));
				//north-west
				tile.addNeighbour(tileMap.get(new Point(x-1,y-1)));
				//north
				tile.addNeighbour(tileMap.get(new Point(x,y-1)));
				//north-east
				tile.addNeighbour(tileMap.get(new Point(x+1,y-1)));
				//east
				tile.addNeighbour(tileMap.get(new Point(x+1,y)));
				//south-east
				tile.addNeighbour(tileMap.get(new Point(x+1,y+1)));
				//south
				tile.addNeighbour(tileMap.get(new Point(x,y+1)));
				//south-west
				tile.addNeighbour(tileMap.get(new Point(x-1,y+1)));
		}
	}

	/**
	 * Method for creating the initial board
	 * @param col
	 * @param row
	 * @param scoreBoard
	 */

	private void generateTileList(int col, int row, ScoreBoard scoreBoard) {

		Rectangle2D scoreBounds = scoreBoard.bounds(); //bounds on scoreboard on screen

		for(int x=0; x != col; x++) { //for each col
			for(int y=0; y != row; y++) { //for each row

				//add tile to tile list if in valid region of board
				if(!scoreBounds.contains(x,y)) {
					tileMap.put(new Point(x,y), new Tile(x, y));
				} else {
				//null if scoreboard in the way
					tileMap.put(new Point(x,y), null);
				}

			}
		}
	}





}
