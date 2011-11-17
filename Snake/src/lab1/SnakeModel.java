package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
	
	/** Graphical representation of food. */
	private static final GameTile FOOD_TILE = new RoundTile(new Color(0, 0,
			0),
			new Color(0, 255, 255), 2.0);
	
	/** Graphical representation of the snake head */
	private static final GameTile SNAKE_HEAD_TILE = new SnakeTile(Color.BLACK,
			Color.RED, 2.0);
	
	private static final GameTile SNAKE_BODY_TILE = new SnakeTile(Color.BLACK,
			Color.GREEN, 2.0);
	
	/** Graphical representation of a blank tile. */
	private static final GameTile BLANK_TILE = new GameTile();

	/** Contains the position of the food tile */
	private Position food;

	
	private final Deque<Position> snakeBody = new LinkedList<Position>();
	
	/** The position of the snake's head. */
	private Position snakeHeadPos;
	
	/** The direction of the snake. */
	private Directions direction = Directions.NORTH;

	/** The number of food eaten. */
	private int score;
	
	/** For knowing when to make the snake longer */
	private boolean foodEaten = false;
	/** The position of the last tile of the snake */
	private Position lastSnakeTilePos;

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

		// Insert the snake in the middle of the gameboard.
		this.snakeHeadPos = new Position(size.width / 2, size.height / 2);
		this.lastSnakeTilePos = this.snakeHeadPos;
		setGameboardState(this.snakeHeadPos, FOOD_TILE);

		// Insert food onto the gameboard.
			addFood();
	}
	
	/**
	 * Update the direction of the snake
	 * according to the user's keypress.
	 */
	private void updateDirection(final int key) {
		//Check if the snake is only the head, 
		//in which case you can turn the opposite way
		boolean oneTile = false;
		if(snakeBody.isEmpty()) {
			oneTile = true;
		}
		switch (key) {

			case KeyEvent.VK_LEFT:
				if(oneTile || this.direction != Directions.EAST) {
					this.direction = Directions.WEST;
				}
				break;
			case KeyEvent.VK_UP:
				if(oneTile || this.direction != Directions.SOUTH) {
					this.direction = Directions.NORTH;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(oneTile || this.direction != Directions.WEST) {
					this.direction = Directions.EAST;
				}
				break;
			case KeyEvent.VK_DOWN:
				if(oneTile || this.direction != Directions.NORTH) {
					this.direction = Directions.SOUTH;
				}
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
		food = new Position(newFoodPos.getX(), newFoodPos.getY());
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
	
	private void moveSnake() {		
		if (snakeBody.size() > 0 ) {
			snakeBody.addFirst(new Position(snakeHeadPos.getX(), snakeHeadPos.getY()));
		    snakeBody.removeLast();
		}
	}
	
	private void drawSnake() {
		setGameboardState(this.snakeHeadPos, SNAKE_HEAD_TILE);
		if ( snakeBody.size() > 0 ) {
			setGameboardState(snakeBody.getFirst(), SNAKE_BODY_TILE);
		}
	}
	
	@Override
	public void gameUpdate(int lastKey) throws GameOverException
	{	
		updateDirection(lastKey);
		
		// save the position of the last snake tile
		this.lastSnakeTilePos = snakeBody.size() > 0 ? snakeBody.getLast() : this.snakeHeadPos;
		
		// move the snake
		moveSnake();
		
		this.snakeHeadPos = getNextSnakePos();
		
		if (isOutOfBounds(this.snakeHeadPos)) {
			throw new GameOverException(this.score);
		}
		
		//Checks if the snake's head touches its body.
		if (snakeBody.size() > 0) {
		    if(snakeBody.contains(snakeHeadPos)) {
		        throw new GameOverException(this.score);
		    }
		}
		
		// if food eaten make the snake longer
		if (foodEaten) {
			snakeBody.add(lastSnakeTilePos);
			foodEaten = false;
		} else {
			// Erase the previous position.
			setGameboardState(this.lastSnakeTilePos, BLANK_TILE);
		}

		// draw the snake
		drawSnake();
		
		// remove food at snake head position if any
		if (food.equals(snakeHeadPos)) {
			food = null;
		    foodEaten = true;
			this.score++;
			// Check if there is space left for food
			if(score < ((getGameboardSize().width * getGameboardSize().height) - 1)) {
			    addFood();
			}
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
