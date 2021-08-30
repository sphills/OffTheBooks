
package locationPredictor;

public class Target3D {

	private double[] worldLocation3D = {0, 0, 0};
	private float currentRightSpeed = 0.0f;
	private float currentForwardSpeed = 0.0f;
	private float currentUpSpeed = 0.0f;
	
	public double[] getWorldLocation3D() {
		return worldLocation3D;
	}
	public void setWorldLocation3D(double[] inputWorldLocation3D) {
		worldLocation3D = inputWorldLocation3D;
	}
	public float getCurrentUpSpeed() {
		return currentUpSpeed;
	}
	public void setCurrentUpSpeed(float inputUpSpeed) {
		currentUpSpeed = inputUpSpeed;
	}
	public String tellCurrentLocation() {
		return worldLocation3D[0] + " " + worldLocation3D[1] + " " + worldLocation3D[2];
	}
	public void setCurrentLocation(double inputX, double inputY) {
		worldLocation3D[0] = inputX;
		worldLocation3D[1] = inputY;
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
	
	public Target3D(double[] inputWorldLocation3D, float startingRightSpeed, float startingForwardSpeed, float startingUpSpeed) {
		worldLocation3D = inputWorldLocation3D;
		currentRightSpeed = startingRightSpeed;
		currentForwardSpeed = startingForwardSpeed;
		currentUpSpeed = startingUpSpeed;
	}
}
