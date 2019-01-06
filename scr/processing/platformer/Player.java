/**
 * 
 */
package processing.platformer;

/**
 * @author Noah Ruben
 *
 */
public class Player {

	private double yPos;
	private double xPos;
	private double yVel = 0.0;
	private boolean onGround = false;
	private double xVel = 0.0;
	private double gravityRatio;
	public static final int HEIGHT = 15;
	public static final int WIDTH = 5;
	public Rect body;

	public Player(int xPos, int yPos, double gravityRatio) {
		this.yPos = yPos;
		this.xPos = xPos;
		this.gravityRatio = gravityRatio;
		body = new Rect(xPos, yPos, WIDTH, HEIGHT);
	}

	public void update() {
		if (onGround) {
			xVel *= 0.5;
		} else {
			yVel += gravityRatio;
		}
		this.yPos += yVel;
		this.xPos += xVel;

		this.body.setxPos(xPos);
		this.body.setyPos(yPos);

	}

	/**
	 * @return the yPos
	 */
	public double getyPos() {
		return yPos;
	}

	/**
	 * @return the xPos
	 */
	public double getxPos() {
		return xPos;
	}

	/**
	 * @return the yVel
	 */
	public double getyVel() {
		return yVel;
	}

	/**
	 * @return the xVel
	 */
	public double getxVel() {
		return xVel;
	}

	/**
	 * @return the onGround
	 */
	public boolean isOnGround() {
		return onGround;
	}

	/**
	 * @param onGround the onGround to set
	 */
	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}

	/**
	 * @param yVel the yVel to set
	 */
	public void setyVel(double yVel) {
		this.yVel = yVel;
	}

	/**
	 * @param xVel the xVel to set
	 */
	public void setxVel(double xVel) {
		this.xVel = xVel;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
		this.body.setyPos(yPos);
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
		this.body.setxPos(xPos);
	}
}
