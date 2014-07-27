package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class OmegaRace extends JFrame implements KeyListener
{
	private static final long	serialVersionUID	= 5888602070505118431L;
	private OmegaCanvas	canvas;

	public OmegaRace( /*GraphicsConfiguration gc*/ )
	{
		super("OmegaRace");
		canvas = new OmegaCanvas();
		// create canvas
		setLayout(new BorderLayout());
		// use border layout
		add(canvas, BorderLayout.CENTER);
		// add canvas
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		// pack components tightly together
		setResizable(false);
		// prevent us from being resize-able
		setVisible(true);
		// make sure we are visible!
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension( 800, 600 );
	}

	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed( KeyEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased( KeyEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped( KeyEvent e )
	{
		// TODO Auto-generated method stub
		
	}

}
