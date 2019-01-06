/**
 * 
 */
package processing.platformer;

/**
 * @author Noah Ruben
 *
 */
public class Rect{
	private double xPos;
	private double yPos;
	private double height;
	private double width;

	/**
	 * @param xPos
	 * @param yPos
	 * @param height
	 * @param width
	 */
	public Rect(int xPos, int yPos, int width, int height){
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight(){
		return this.height;
	}

	/**
	 * @return the width
	 */
	public double getWidth(){
		return this.width;
	}

	/**
	 * @return the xPos
	 */
	public double getxPos(){
		return this.xPos;
	}

	/**
	 * @return the yPos
	 */
	public double getyPos(){
		return this.yPos;
	}

	/**
	 * @param rect the rect to check
	 * @return if the rect collides
	 */
	public boolean isCollided(Rect rect){
		if(this.xPos < rect.getxPos() && rect.getxPos() < (this.xPos + this.width)){
			if(this.yPos <= rect.getyPos() && rect.getyPos() <= (this.yPos + this.width)){
				System.out.println("hit");
				return true;
			}
		}
		if(this.xPos < (rect.getxPos() + rect.getWidth()) && (rect.getxPos() + rect.getWidth()) < (this.xPos + this.width)){
			if(this.yPos <= (rect.getyPos() + rect.getHeight()) && (rect.getyPos() + rect.getHeight()) <= (this.yPos + this.width)){
				System.out.println("hit");
				return true;
			}
		}
		return false;
	}

	/**
	 * @param xPos the xPos to check
	 * @param yPos the yPos to check
	 * @return if the point is in the rect
	 */
	public boolean isInRect(double xPos, double yPos){
		if(xPos > this.getxPos() && xPos < (this.getxPos() + this.getWidth())){
			if(yPos > this.getyPos() && yPos < (this.getyPos() + this.getHeight())){
				return true;
			}
		}
		return false;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height){
		this.height = height;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width){
		this.width = width;
	}

	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(double xPos){
		this.xPos = xPos;
	}

	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(double yPos){
		this.yPos = yPos;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("xPos=");
		builder.append(this.getxPos());
		builder.append(", yPos=");
		builder.append(this.getyPos());
		builder.append(", height=");
		builder.append(this.getHeight());
		builder.append(", width=");
		builder.append(this.getWidth());
		return builder.toString();
	}

	public boolean willColide(){
		return false;
	}

}
