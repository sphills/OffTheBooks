package locationPredictor;

public class Target {

	float currentLocation = 0.0f;
	float currentSpeed = 0.0f;
	
	public float getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(float currentLocation) {
		this.currentLocation = currentLocation;
	}
	public float getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(float currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
	public Target(float startingLocation, float startingSpeed) {
		currentLocation = startingLocation;
		currentSpeed = startingSpeed;
	}
}
