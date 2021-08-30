
package locationPredictor;

import java.awt.Point;

public class Target2D {

	private Point testPoint;
	private float currentForwardSpeed = 0.0f;
	private float currentRightSpeed = 0.0f;
	
	public double[] getCurrentLocation() {
		return new double[] {testPoint.getX(), testPoint.getY()};
	}
	public String tellCurrentLocation() {
		return testPoint.getX() + " " + testPoint.getY();
	}
	public void setCurrentLocation(double inputX, double inputY) {
		testPoint.setLocation(inputX, inputY);
	}
	public float getCurrentRightSpeed() {
		return currentRightSpeed;
	}
	public void setCurrentRightSpeed(float currentSpeed) {
		this.currentRightSpeed = currentSpeed;
	}
	public float getCurrentForwardSpeed() {
		return currentForwardSpeed;
	}
	public void setCurrentForwardSpeed(float currentSpeed) {
		this.currentForwardSpeed = currentSpeed;
	}
	
	public Target2D(int startingX, int startingY, float startingRightSpeed, float startingForwardSpeed) {
		testPoint = new Point(startingX, startingY);
		currentRightSpeed = startingRightSpeed;
		currentForwardSpeed = startingForwardSpeed;
	}
}
