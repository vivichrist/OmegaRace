
package Model;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Player implements MoveableEntity {
	public static enum collision { COLLISIONX, COLLISIONY };
	private float x, y, dirX = 0.0f, dirY = 0.0f, radius = 5;
	private int ori;
	private boolean dead = false, dying = false;
	private Path2D.Float ship;
	public static final int radians = 48;
	
	public Player( int x, int y, int orientation ) {
		this.x = x; this.y = y; this.ori = orientation;
		ship = new Path2D.Float();
		ship.moveTo( radius, 0 );
		ship.lineTo( -(radius-1), radius-1 );
		ship.lineTo( -1, 0 );
		ship.lineTo( -(radius-1), radius-1 );
		ship.lineTo( radius, 0 );
	}
	@Override
	public Rectangle2D bounds() {
		return new Rectangle2D.Float( x-radius, y-radius, x+radius, y+radius );
	}

	@Override
	public void drawEntity(Graphics2D g) {
		AffineTransform trans = 
				AffineTransform.getRotateInstance( scaleRadians(ori) )
							   .getTranslateInstance( x, y );
		
	}

	@Override
	public boolean alive() {
		return !dead;
	}

	@Override
	public Point2D direction() {
		return new Point2D.Float( dirX, dirY );
	}

	public void thrust( boolean forward ) {
		dirX = (float) (((dirX+(Math.cos(ori)))*0.5f)*(forward?1.1f:0.9f));
		dirY = (float) (((dirY+(Math.sin(ori)))*0.5f)*(forward?1.1f:0.9f));
	}
	
	public void turn( int degrees ) {
		
	}
	
	@Override
	public void move() {
		// if the movement crosses the boundary of the 
		// screen
		// 
		
	}

	private void bounceX( int by ) {
		y -= by-(y+dirY);
		dirY = -dirY;
	}
	private void bounceY( int bx ) {
		x -= bx-(x+dirX);
		dirX = -dirX;
	}

	public float scaleRadians( int scale ) {
		return (float) (((scale % radians)/(float)radians) * Math.PI * 2.0f);
	}
	public void setOrientation( int rads ) {
		ori = rads % radians;
	}
	@Override
	public void setBounds(Rectangle2D box) {
		// TODO Auto-generated method stub
		
	}
}