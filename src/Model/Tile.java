package Model;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;


public class Tile implements Entity, Comparable<Tile> {


	/**Tile dimensions*/
	public final int size = 10;
	/**Bounding box*/
	private Rectangle2D bounds;
	/**Path cost to current node*/
	private float cost;
	/**heuristic estimate for location*/
	private float heuristic;
	/**Where the tile came from*/
	private Tile parent;
	/**List of neighbours*/
	private HashSet<Tile> adjacencyList;
	/**Has the node been visited yet in the search*/
    boolean visited;

    public Tile(int x, int y) {

    	this.parent = null; //parent
    	this.visited = false; //visited
    	this.adjacencyList = null; //neighbours

    	this.cost = 0; //path length
    	this.heuristic = 0; //estimate

    	this.bounds = new Rectangle(x, y, size, size);//bounding box

    }

    /**Features*/

	@Override
	public Rectangle2D bounds() {
		// TODO Auto-generated method stub
		return bounds;
	}

	@Override
	public void setBounds(Rectangle2D box) {
		// TODO Auto-generated method stub
		this.bounds = box;
	}

	@Override
	public void drawEntity(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Tile o) {
		// TODO Auto-generated method stub
		double f = heuristic + cost;
		double of = o.heuristic + o.cost;

		if (f < of) {
			return -1;
		} else if (f > of) {
			return 1;
		} else {
			return 0;
		}
	}

	/** Getters && Setters */

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(float heuristic) {
		this.heuristic = heuristic;
	}

	public Tile getParent() {
		return parent;
	}

	public void setParent(Tile parent) {
		this.parent = parent;
	}

	public HashSet<Tile> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(HashSet<Tile> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	//method for adding neighbours to tile in constructing graph
	public void addNeighbour(Tile tile) {
		if(tile !=null)
		this.adjacencyList.add(tile);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}




}
