package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends GeometricalShape{

	/** Ending point of line (x2, y2) */
	private int x2;
	private int y2;
	
	
	/**
	 * Construct a line from two positions and a color. 
	 * 
	 * @param x1 Horizontal first position of the line.
	 * @param y1 Vertical first position of the line.
	 * @param x2 Horizontal second position of the line.
	 * @param y2 Vertical second position of the line.
	 * @param c The color of the line.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	public Line( int x1, int y1, int x2, int y2, Color c )
	           throws IllegalPositionException {
		  
	}
	  
	/**
	 * Construct a line from two GeometricalForms and a color. 
	 * 
	 * @param f1 Form with coordinates for first position.
	 * @param f2 Form with coordinates for second position.
	 * @param c The color of the line.
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
	public void fill(Graphics g) {
		// TODO Auto-generated method stub

	}
	
	/**
    * Move the line the given distances. 
    * Both the start and ending point of the line will be moved.
    * Check if the new coordinates are legal and
    * if they are, set the position to the new coordinates.
    * Otherwise an <tt>IllegalPositionException</tt> is thrown.
    * Origo is (0,0) and only positive coordinates are legal.
    *
    * @param dx move the form dx points to the right.
    * @param dy move the form dy points down.
    * @throws IllegalPositionException if any coordinate
    *                                  becomes negative.
    */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		// TODO Auto-generated method stub

	}
	
   /**
    * Place the form on given coordinates.
    * The starting point will be set according to the parameters and
    * the ending point will be placed relative to this position.
    * Check if the coordinates are legal.
    * Origo is (0,0) and only positive
    * coordinates are legal.
    * If they are legal, update the position with the new coordinates.
    * Otherwise an <tt>IllegalPositionException</tt> is thrown.
    *
    * @param x Distance right from origo.
    * @param y Distance down from origo.
    * @throws <tt>IllegalPositionException</tt> if any coordinate
    *                                           is negative.
    */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
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

}
