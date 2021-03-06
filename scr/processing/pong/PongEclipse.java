package processing.pong;
import processing.core.*;

/**
 * @author Noah Ruben
 *
 */

// Noah Ruben

// 87 => W
// 83 => S
// 38 => UP
// 40 => DOWN
// 32 => SPACE
public class PongEclipse extends PApplet {

	float xPosBall;
	float yPosBall;
	float durchmesserBall;
	float xMovBall;
	float yMovBall;

	float rectWidth;
	float rectHeight;

	float xPosRectP1;
	float yPosRectP1;
	float xMovRectP1;
	float yMoveRectP1;

	float xPosRectP2;
	float yPosRectP2;
	float xMovRectP2;
	float yMoveRectP2;

	int player1Score;
	int player2Score;

	public static void main(String[] args) {
		PApplet.main(PongEclipse.class);
	}

	public void settings() {
//		size(1000, 500);
		fullScreen();
	}

	public void setup() {

		background(0);
		noStroke();
		smooth();

		durchmesserBall = 30;

		rectHeight = 100;
		rectWidth = 10;

		xMovRectP1 = 0;
		yMoveRectP1 = 50;

		xMovRectP2 = 0;
		yMoveRectP2 = 50;

		player1Score = 10;
		player2Score = 10;

		reset();
		textSize(50);
		text("GO!!", width / 2 - 100, height / 2);
	}

	public void draw() {
		frameRate(120);
		background(0);
		centerLine();
		player1();
		player2();
		collideWithRectP1();
		collideWithRectP2();
		collideWithWall();
		ball(this.xPosBall, this.yPosBall, this.xMovBall, this.yMovBall);
		gameEnd();
	}

	void ball(float xPosBall, float yPosBall, float xMovBall, float yMovBall) {
		fill(255);
		ellipse(xPosBall, yPosBall, durchmesserBall, durchmesserBall);
		this.xPosBall = this.xPosBall + xMovBall;
		this.yPosBall = this.yPosBall + yMovBall;
		fill(0);
	}

	void player1() {
		fill(255);
		textSize(15);
		text(player1Score, 100, 100);
		rect(xPosRectP1, yPosRectP1, rectWidth, rectHeight);
		fill(0);
	}

	void player2() {
		fill(255);
		textSize(15);
		text(player2Score, 900, 100);
		rect(xPosRectP2, yPosRectP2, rectWidth, rectHeight);
		fill(0);
	}

	void collideWithWall() {
		if (xPosBall >= width + 15) {
			reset();
			player2Score--;
		}
		if (xPosBall <= -15) {
			reset();
			player1Score--;
		}
		if (yPosBall >= height) {
			yMovBall *= -1;
		}
		if (yPosBall <= 0) {
			yMovBall = sqrt(sq(yMovBall));
		}
	}

	void collideWithRectP1() {
		if (isOnYEdge(yPosRectP1)) {
			if (isOnXEdge(xPosRectP1)) {
				xMovBall *= -1.1;
			}
		}
	}

	void collideWithRectP2() {
		if (isOnYEdge(yPosRectP2)) {
			if (isOnXEdge(xPosRectP2)) {
				xMovBall *= -1.1;
			}
		}
	}

	void gameEnd() {

		if (player2Score <= 0) {
			textSize(50);
			fill(255);
			background(0);
			text("GAME OVER", width / 2 - 150, height / 2); // <>//
			text("PLAYER 1 WINS", width / 2 - 200, height / 2 + 50);
			textSize(15);
			text(player1Score, 100, 100);
			text(player2Score, 900, 100);
			noLoop();
		}
		if (player1Score <= 0) {
			textSize(50);
			fill(255);
			background(0);
			text("GAME OVER", width / 2 - 150, height / 2);
			text("PLAYER 2 WINS", width / 2 - 200, height / 2 + 50);
			text(player1Score, 100, 100);
			text(player2Score, 900, 100);
			noLoop();
		}
	}

	boolean isOnXEdge(float xPos) {
		if (xPosBall >= xPos && xPosBall < xPos + rectWidth) {
			return true;
		} else {
			return false;
		}
	}

	boolean isOnYEdge(float yPos) {
		if (yPosBall >= yPos && yPosBall <= (yPos + rectHeight)) {
			return true;
		} else {
			return false;
		}
	}

	void reset() {
		frameRate(1);
		xPosBall = width / 2;
		yPosBall = height / 2;
		ballMoveValue();
		xPosRectP1 = 20;
		yPosRectP1 = height / 2 - 50;
		xPosRectP2 = width - 30;
		yPosRectP2 = height / 2 - 50;
	}

	void ballMoveValue() {
		xMovBall = random(-5, 5);
		yMovBall = random(-5, 5);
		// xMovBall = 10;
		// yMovBall = 0;
		if (yMovBall == 0 || xMovBall == 0) { // <>//
			ballMoveValue();
		}
	}

	void centerLine() {
		fill(255);
		stroke(50);
		line(width / 2, 0, width / 2, height);
	}

	public void keyPressed() {
		if (keyCode == 87) {
			println("W");
			if (!(yPosRectP1 <= 0)) {
				this.yPosRectP1 = this.yPosRectP1 - yMoveRectP1;
			}
		}
		if (keyCode == 83) {
			println("S");
			if (!(yPosRectP1 >= height - rectHeight)) {
				this.yPosRectP1 = this.yPosRectP1 + yMoveRectP1;
			}
		}
		if (keyCode == 38) {
			println("UP");
			if (!(yPosRectP2 <= 0)) {
				this.yPosRectP2 = this.yPosRectP2 - yMoveRectP2;
			}
		}
		if (keyCode == 40) {
			println("DOWN");
			if (!(yPosRectP2 >= height - rectHeight)) {
				this.yPosRectP2 = this.yPosRectP2 + yMoveRectP2;
			}
		}
		if (keyCode == 32) {
			println("SPACE");
			reset();
		}

	}

}