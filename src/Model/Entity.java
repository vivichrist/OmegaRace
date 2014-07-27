package Model;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public interface Entity {

	public abstract Rectangle2D bounds(); //get the bounding box of collidable object

	public abstract void setBounds(Rectangle2D box); //set the bounding box of collidable object

	public abstract void drawEntity(Graphics2D g);//draw method for entities

}
