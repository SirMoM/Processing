/**
 * 
 */
package processing.platformer;

import processing.core.PApplet;

/**
 * @author Student
 *
 */
public class Platformer extends PApplet{

	private final Player player;
	private final int width = 1500;
	private final int height = 500;
	private final Rect base = new Rect(0, (height / 2) - 15, width, -10);
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(Platformer.class);
	}
	
	

	public Platformer() {
		player = new Player(10, 10, 0.1d);
	}



	public void setup() {
		background(0);
	}
	
	public void draw() {
		frameRate(120);
		background(0);
		drawRect(base);
		player.update();

		if (player.getyPos() >= height-(height / 2)) {
//			player.setOnGround(true);
			player.setyVel(0);
			player.setyPos(height-(height / 2));
		}else {
//			player.setOnGround(false);
		}
		drawPlayer();
	}
	
	private void drawRect(Rect rect) {
		rect(rect.getxPos(), rect.getyPos(), rect.getWidth(), rect.getHeight());
	}



	private void drawPlayer() {
		rect((int) player.getxPos(), (int) player.getyPos(), 5, 15);
	}

	public void settings() {
		size(width, height);
	}
	
	public void keyPressed() {
		switch (keyCode) {
		case ButtonCodes.SPACE:
			player.setyVel(-5);
			break;

		case ButtonCodes.A:
			player.setxVel(-2);
			System.out.println("A");
			break;
		
		case ButtonCodes.D:
			player.setxVel(2);
			System.out.println("D");
			break;

		default:
			System.out.println(keyCode);
			break;
		}
	}

}
