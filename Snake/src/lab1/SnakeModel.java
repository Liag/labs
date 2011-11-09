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
	
	private static final GameTile SNAKE_BODY_TILE = new RoundTile(Color.BLACK,
			Color.GREEN, 2.0);
	
	/** Graphical representation of a blank tile. */
	private static final GameTile BLANK_TILE = new GameTile();

	/** A list containing the positions of all food. */
	private final List<Position> food = new ArrayList<Position>();
	
	private final List<Position> snakeBody = new ArrayList<Position>();
	
	/** The position of the snake's head. */
	private Position snakeHeadPos;
	
	/** The direction of the snake. */
	private Directions direction = Directions.NORTH;

	/** The number of food eaten. */
	private int score;
	
	/** Something */
	private boolean foodEaten = false;
	/** Something */
	private Position lastPos;

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
		this.lastPos = this.snakeHeadPos;
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

	/**
	 * Get next position of the Snake.
	 */
	private Position getNextSnakePos() {
		return new Position(
				this.snakeHeadPos.getX() + this.direction.getXDelta(),
				this.snakeHeadPos.getY() + this.direction.getYDelta());
	}
	
	@Override
	public void gameUpdate(int lastKey) throws GameOverException
	{	
		updateDirection(lastKey);
		
		//Assigns the position of the last snake "bit" to lastPos before
		lastPos = snakeBody.size() > 0 ? snakeBody.get(snakeBody.size() - 1) : this.snakeHeadPos;

		Position oldSnakeHeadPos = this.snakeHeadPos;
		this.snakeHeadPos = getNextSnakePos();
		
		if (snakeBody.size() > 0 ) {
			for (int i = snakeBody.size() - 1; i >= 0; i--) {
				if ( i != 0) {
					snakeBody.set(i, snakeBody.get(i - 1)); 
				} else {
					snakeBody.set(i, oldSnakeHeadPos); 
				}
			}
		}
		
		if (isOutOfBounds(this.snakeHeadPos)) {
			throw new GameOverException(this.score);
		}
		
		//Checks if the snake's head touches its body.
		if (snakeBody.size() > 0) {
			for (int i = 0; i < snakeBody.size(); i++) {
				if (snakeHeadPos.equals(snakeBody.get(i))) {
					throw new GameOverException(this.score);
				}
			}
		}
		
		if (foodEaten) {
			snakeBody.add(lastPos);
			foodEaten = false;
		} else {
			// Erase the previous position.
			setGameboardState(this.lastPos, BLANK_TILE);
		}
		
		// Draw the snake
		setGameboardState(this.snakeHeadPos, SNAKE_HEAD_TILE);
		for (int i = 0; i < snakeBody.size(); i++) {
			setGameboardState(snakeBody.get(i), SNAKE_BODY_TILE);
		}

		// Remove the coin at the new collector position (if any)
		if (this.food.remove(this.snakeHeadPos)) {
			foodEaten = true;
			this.score++;
			addFood();
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
