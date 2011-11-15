package geometri;

import java.awt.Color;

public abstract class GeometricalShape implements GeometricalForm {
	
	/** The object's position */
	private int x;
	private int y;
	
	/** The object's color */
	private Color color;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm f) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getX() {
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
    public int getY() {
    	return 0;
    }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Set the position of the object according to the parameters.
	 * @param x Horizontal position of the point.
	 * @param y Vertical position of the point.
	 */
	public void setPosition( int x, int y ) {
		
	}
	
}
