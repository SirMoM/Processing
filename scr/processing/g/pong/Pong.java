package processing.g.pong;

import processing.core.PApplet;

public class Pong extends PApplet{

	// Größe des Fensters
	// breite
	int width = 1200;
	// höhe
	int height = 600;

	// Ball X und Y-Position abhäning von der Fenstergröße
	int ballX = this.width / 2;
	int ballY = this.height / 2;

	// Geschwindigkeit des balles
	int Geschwindigkeit = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args){
		PApplet.main(Pong.class);
	}

	@Override
	public void draw(){

		// Hintergrund Grau
		this.background(100, 100, 100);
		// Ball Farbe
		this.fill(255, 0, 0);
		// Ball zeichnen
		this.ellipse(this.ballX, this.ballY, 50, 50);

		// X Bewegung des Balles
		this.ballX = this.ballX + this.Geschwindigkeit;

		// Check ob der Ball die X-Seiten überschreitet
		// rechts
		if(this.ballX >= this.width - 25){
			this.Geschwindigkeit = this.Geschwindigkeit * -2;
		}
		// links
		if(this.ballX <= 0 + 25){
			this.Geschwindigkeit = this.Geschwindigkeit * -2;
		}
	}

	@Override
	public void settings(){
		// Größe des Fensters setzen
		this.size(this.width, this.height);
	}

	@Override
	public void setup(){
		// Wie viele Bilder(Frames) pro Sekunde gezeichnet werden
		this.frameRate(200);
	}

}
