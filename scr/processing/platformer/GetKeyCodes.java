/**
 * 
 */
package processing.platformer;

import processing.core.PApplet;
import processing.pong.PongEclipse;

/**
 * @author Student
 *
 */
public class GetKeyCodes extends PApplet{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(GetKeyCodes.class);

	}

	public void setup() {
		background(0);
	}
	
	public void draw() {
		frameRate(120);
		background(0);
	}
	
	public void settings() {
		size(100, 50);
	}
	
	public void keyPressed() {
		System.out.println(keyCode);
		System.out.println(key);
	}
}
