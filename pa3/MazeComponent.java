//Name: Tianqi Ren
//USC loginid: tianqire
//CS 455 PA3
//Fall 2017

import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.ListIterator;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * MazeComponent class
 * 
 * A component that displays the maze and path through it if one has been found.
 */
public class MazeComponent extends JComponent {
	private Maze maze;
	private static final int START_X = 10; // top left of corner of maze in frame
	private static final int START_Y = 10;
	private static final int BOX_WIDTH = 20; // width and height of one maze "location"
	private static final int BOX_HEIGHT = 20;
	private static final int INSET = 2; // how much smaller on each side to make entry/exit inner box

	/**
	 * Constructs the component.
	 * 
	 * @param maze
	 *            the maze to display
	 */
	public MazeComponent(Maze maze) {
		this.maze = maze;
	}

	/**
	 * Draws the current state of maze including the path through it if one has been
	 * found.
	 * 
	 * @param g
	 *            the graphics context
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// draw the maze graph
		int rows = maze.numRows();
		int cols = maze.numCols();
		Rectangle mazeRec = new Rectangle(START_X, START_Y, cols * BOX_WIDTH, rows * BOX_HEIGHT);
		g2.draw(mazeRec);

		// draw the maze box inside (wall or free)
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Rectangle box = new Rectangle(START_X + j * BOX_WIDTH, START_Y + i * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
				MazeCoord temp = new MazeCoord(i, j);

				// if it is wall, fill it with black, or it is white
				if (maze.hasWallAt(temp)) {
					g2.setColor(Color.BLACK);
					g2.draw(box);
					g2.fill(box);
				}
			}
		}
		// draw the start box
		MazeCoord startLoc = maze.getEntryLoc();
		Rectangle startBox = new Rectangle(START_X + startLoc.getCol() * (BOX_HEIGHT) + INSET,
				START_Y + startLoc.getRow() * (BOX_WIDTH) + INSET, BOX_WIDTH - 2 * INSET, BOX_HEIGHT - 2 * INSET);
		g2.setColor(Color.YELLOW);
		g2.draw(startBox);
		g2.fill(startBox);

		// draw the exit box
		MazeCoord exitLoc = maze.getExitLoc();
		Rectangle exitBox = new Rectangle(START_X + exitLoc.getCol() * (BOX_HEIGHT) + INSET,
				START_Y + exitLoc.getRow() * (BOX_WIDTH) + INSET, BOX_WIDTH - 2 * INSET, BOX_HEIGHT - 2 * INSET);
		g2.setColor(Color.GREEN);
		g2.draw(exitBox);
		g2.fill(exitBox);

		// before the search, path is null. after the search, draw the path only if
		// there exits a path.
		LinkedList<MazeCoord> path = maze.getPath();
		for (int i = 1; i < path.size(); i++) {

			double xFirstPoint = START_X + 0.5 * BOX_WIDTH + BOX_WIDTH * path.get(i).getCol();
			double yFirstPoint = START_Y + 0.5 * BOX_HEIGHT + BOX_HEIGHT * path.get(i).getRow();
			double xSecondPoint = START_X + 0.5 * BOX_WIDTH + BOX_WIDTH * path.get(i - 1).getCol();
			double ySecondPoint = START_Y + 0.5 * BOX_HEIGHT + BOX_HEIGHT * path.get(i - 1).getRow();

			Line2D.Double line = new Line2D.Double(xFirstPoint, yFirstPoint, xSecondPoint, ySecondPoint);

			g2.setColor(Color.BLUE);
			g2.fill(line);
			g2.draw(line);
		}
		// in case that the startLoc is exitLoc: we just show a dot with the exitBox
		if (path.size() == 1) {
			double xPoint = START_X + 0.5 * BOX_WIDTH + BOX_WIDTH * path.get(0).getCol();
			double yPoint = START_Y + 0.5 * BOX_HEIGHT + BOX_HEIGHT * path.get(0).getRow();
			Line2D.Double lineDot = new Line2D.Double(xPoint, yPoint, xPoint, yPoint);
			g2.setColor(Color.BLUE);
			g2.fill(lineDot);
			g2.draw(lineDot);
		}
	}

}
