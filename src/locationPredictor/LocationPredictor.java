package locationPredictor;

public class LocationPredictor {

	public float predictLocation(float inputLocation, float inputSpeed) {
		float timeInterval = 1.0f;
		return (inputLocation + (inputSpeed*timeInterval));
	}
	
	public float predictLocation(float inputLocation, float inputSpeed, float inputTimeInterval) {
		return (inputLocation + (inputSpeed*inputTimeInterval));
	}

	public float predictLocation(float inputLocation, float inputRightSpeed, float inputForwardSpeed, float inputTimeInterval) {
		return (inputLocation + (inputRightSpeed*inputTimeInterval));
	}
	
	public String predictLocation(double[] inputLocation, float inputRightSpeed, float inputForwardSpeed, float inputTimeInterval) {
		double[] locationReference = inputLocation;
		return ((locationReference[0] + inputRightSpeed) * inputTimeInterval) + " " + ((locationReference[1] + inputForwardSpeed) * inputTimeInterval);
	}
	
	public String predictLocation(double[] inputLocation, float inputRightSpeed, float inputForwardSpeed, float inputUpSpeed, float inputTimeInterval) {
		System.out.println("Calculating hit location given target's current movement vector...");
		double[] referenceLocation = calculateHitLocation(inputLocation, inputRightSpeed, inputForwardSpeed, inputUpSpeed, inputTimeInterval);
		
		return "Calculated hit location at " + referenceLocation[0] + ", " + referenceLocation[1] + ", " + referenceLocation[2] + ".";
	}
	
	private double[] calculateHitLocation(double[] inputLocation, float inputRightSpeed, float inputForwardSpeed, float inputUpSpeed, float inputTimeInterval) {
		double[] locationReference = inputLocation;
		float referenceSpeed = 0.0f;
		
		for (int i = 0; i < locationReference.length; i++) {
			switch (i) {
			case 0:
				referenceSpeed = inputRightSpeed;
				break;
			case 1:
				referenceSpeed = inputForwardSpeed;
				break;
			case 2:
				referenceSpeed = inputUpSpeed;
				break;
			}
			
			locationReference[i] = ((locationReference[i] + referenceSpeed) * inputTimeInterval);
		}
		
		return locationReference;
	}
}
