package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line implements GeometricalForm {

	private Point position;
	
	private Point pos2;
	
	private Color color;
	
	
	/**
	 * Construct a line from two positions and a colour. 
	 * 
	 * @param x1 Horizontal first position of the line.
	 * @param y1 Vertical first position of the line.
	 * @param x2 Horizontal second position of the line.
	 * @param y2 Vertical second position of the line.
	 * @param c The colour of the line.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	public Line( int x1, int y1, int x2, int y2, Color c )
	           throws IllegalPositionException {
		  
	}
	  
	/**
	 * Construct a line from two GeometricalForms and a colour. 
	 * 
	 * @param f1 Form with coordinates for first position.
	 * @param f2 Form with coordinates for second position.
	 * @param c The colour of the line.
	 */
	public Line( GeometricalForm f1, GeometricalForm f2, Color c ) {
		  
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {
		// TODO Auto-generated method stub
		return 0;
	}

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
	public void fill(Graphics g) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
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
	public int perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		// TODO Auto-generated method stub

	}

}
