package geometri;

import java.awt.Color;

public abstract class GeometricalShape implements GeometricalForm {
	
	/** The object's position */
	private int x;
	private int y;
	
	/** The object's color */
	private Color color;
	
	public GeometricalShape ( int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.color = c;
	}
	
	public GeometricalShape ( GeometricalForm f, Color c ) {
		  this.x = f.getX();
		  this.y = f.getY();
		  this.color = c;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(GeometricalForm f) {
		if ( this.area() == f.area() ) {
			if ( this.perimeter() < f.perimeter() )
				return -2;
			if ( this.perimeter() > f.perimeter() )
				return 2;
			return 0;
		}
		
		if ( this.area() > f.area() )
			return 1;
		
		return -1;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getX() {
		return this.x;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
    public int getY() {
    	return this.y;
    }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		this.x += dx;
		this.y += dy;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns a hash code value for the object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeometricalShape other = (GeometricalShape) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	/**
	 * Returns a string representation of the object.
	 */
	@Override
	public String toString() {
		return "Color: " + color + " X: " + x + " Y: " + y;
	}
	
	
}
