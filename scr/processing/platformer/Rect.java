/**
 * 
 */
package processing.platformer;

/**
 * @author Student
 *
 */
public class Rect {
	private int xPos;
	private int yPos;
	private int height;
	private int width;
	
	/**
	 * @param xPos
	 * @param yPos
	 * @param height
	 * @param width
	 */
	public Rect(int xPos, int yPos, int height, int width) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
	}

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

}
