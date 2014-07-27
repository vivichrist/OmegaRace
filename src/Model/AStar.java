package Model;

import java.util.ArrayList;


public interface AStar {

	public abstract double getEstimatedDistanceToGoal(Ship target, Ship origin); //calculate estimated distance (heuristic to goal)

	public abstract ArrayList<Tile> calculatePathToGoal(Ship target, Ship origin); //calculate the AStar path to goal, used by missiles and enemy;

}
