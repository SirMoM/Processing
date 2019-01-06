/**
 * 
 */
package processing.platformer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import processing.core.PApplet;

/**
 * @author Noah Ruben
 *
 */
public class Platformer extends PApplet{

	private final Player player;
	private final int width = 1500;
	private final int height = 500;
	private final Rect base = new Rect(0, (this.height / 2), this.width, 25);
	private List<Rect> platforms = new ArrayList<Rect>();

	public Platformer(){
		this.player = new Player(10, 10, 0.01);
		this.platforms.add(this.base);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args){
		PApplet.main(Platformer.class);
	}

	@Override
	public void draw(){
		this.frameRate(120);
		this.background(0);
		this.drawRect(this.base);
		this.drawRect(this.player.body);

		for(Iterator iterator = this.platforms.iterator(); iterator.hasNext();){
			Rect rect = (Rect) iterator.next();
			if(rect.isCollided(this.player.body)){
				this.player.setOnGround(true);
			}
		}

		this.player.update();
	}

	@Override
	public void keyPressed(){
		switch (this.keyCode) {
			case ButtonCodes.SPACE:
				if(this.player.isOnGround()){
					this.player.setyVel(-5);
				}
				break;

			case ButtonCodes.A:
				if(!this.player.isOnGround()){
					this.player.setxVel(-20);
				} else{
					this.player.setxVel(-40);
				}
				break;

			case ButtonCodes.D:
				if(!this.player.isOnGround()){
					this.player.setxVel(20);
				} else{
					this.player.setxVel(40);
				}
				break;

			default:
				System.out.println(this.key + this.keyCode);
				break;
		}
	}

	@Override
	public void settings(){
		this.size(this.width, this.height);
	}

	@Override
	public void setup(){
		this.background(0);
		this.fill(204, 102, 0);
	}

	private void drawRect(Rect rect){
		this.rect((float) rect.getxPos(), (float) rect.getyPos(), (float) rect.getWidth(), (float) rect.getHeight());
	}

}
