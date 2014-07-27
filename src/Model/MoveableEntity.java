package Model;
import java.awt.geom.Point2D;


public interface MoveableEntity extends Entity {

	public abstract boolean alive(); //all ships are either alive or dead

	public abstract Point2D direction(); //direction and magnitude of movement that ship (floating point x,y)

	public abstract void move(); //move the ship

}

