package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SnakeModel extends GameModel
{
	public enum Directions {
		EAST(1, 0),
		WEST(-1, 0),
		NORTH(0, -1),
		SOUTH(0, 1),
		NONE(0, 0);

		private final int xDelta;
		private final int yDelta;

		Directions(final int xDelta, final int yDelta) {
			this.xDelta = xDelta;
			this.yDelta = yDelta;
		}

		public int getXDelta() {
			return this.xDelta;
		}

		public int getYDelta() {
			return this.yDelta;
		}
	}
	
	private static final int FOOD_START_AMOUNT = 1;
	
	/** Graphical representation of food. */
	private static final GameTile FOOD_TILE = new RoundTile(new Color(255, 215,
			0),
			new Color(255, 255, 0), 2.0);
	
	/** Graphical representation of the snake head */
	private static final GameTile SNAKE_HEAD_TILE = new RoundTile(Color.BLACK,
			Color.RED, 2.0);
	
	/** Graphical representation of a blank tile. */
	private static final GameTile BLANK_TILE = new GameTile();

	/** A list containing the positions of all food. */
	private final List<Position> food = new ArrayList<Position>();
	
	/** The position of the snake's head. */
	private Position snakeHeadPos;
	
	/** The direction of the snake. */
	private Directions direction = Directions.NORTH;

	/** The number of food eaten. */
	private int score;

	/**
	 * Create a new model for the gold game.
	 */
	public SnakeModel() {
		Dimension size = getGameboardSize();

		// Blank out the whole gameboard
		for (int i = 0; i < size.width; i++) {
			for (int j = 0; j < size.height; j++) {
				setGameboardState(i, j, BLANK_TILE);
			}
		}

		// Insert the collector in the middle of the gameboard.
		this.snakeHeadPos = new Position(size.width / 2, size.height / 2);
		setGameboardState(this.snakeHeadPos, FOOD_TILE);

		// Insert coins into the gameboard.
		for (int i = 0; i < FOOD_START_AMOUNT; i++) {
			addFood();
		}
	}
	
	/**
	 * Update the direction of the snake
	 * according to the user's keypress.
	 */
	private void updateDirection(final int key) {
		switch (key) {
			case KeyEvent.VK_LEFT:
				this.direction = Directions.WEST;
				break;
			case KeyEvent.VK_UP:
				this.direction = Directions.NORTH;
				break;
			case KeyEvent.VK_RIGHT:
				this.direction = Directions.EAST;
				break;
			case KeyEvent.VK_DOWN:
				this.direction = Directions.SOUTH;
				break;
			default:
				// Don't change direction if another key is pressed
				break;
		}
	}
	
	/**
	 * Insert food onto the gameboard.
	 */
	private void addFood() {
		Position newFoodPos;
		Dimension size = getGameboardSize();
		// Loop until a blank position is found and ...
		do {
			newFoodPos = new Position((int) (Math.random() * size.width),
										(int) (Math.random() * size.height));
		} while (!isPositionEmpty(newFoodPos));

		// ... add a new coin to the empty tile.
		setGameboardState(newFoodPos, FOOD_TILE);
		this.food.add(newFoodPos);
	}
	
	/**
	 * Return whether the specified position is empty.
	 * 
	 * @param pos
	 *            The position to test.
	 * @return true if position is empty.
	 */
	private boolean isPositionEmpty(final Position pos) {
		return (getGameboardState(pos) == BLANK_TILE);
	}

	@Override
	public void gameUpdate(int lastKey) throws GameOverException
	{	
		updateDirection(lastKey);
		
		//TODO Move snake
		
		//TODO Check if the snake's head touches its body.
		if (isOutOfBounds(this.snakeHeadPos)) {
			throw new GameOverException(this.score);
		}
		
		// Remove the coin at the new collector position (if any)
		if (this.food.remove(this.snakeHeadPos)) {
			this.score++;
			addFood();
			
			//TODO make the snake longer
		}
	}
	
	/**
	 * 
	 * @param pos The position to test.
	 * @return <code>false</code> if the position is outside the playing field, <code>true</code> otherwise.
	 */
	private boolean isOutOfBounds(Position pos) {
		return pos.getX() < 0 || pos.getX() >= getGameboardSize().width
				|| pos.getY() < 0 || pos.getY() >= getGameboardSize().height;
	}

}
