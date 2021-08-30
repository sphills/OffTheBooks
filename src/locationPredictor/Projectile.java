package locationPredictor;

public class Projectile {

	float distanceToTarget = 0.0f;
	float constantSpeed = 0.0f;
	
	public void setDistanceToTarget(double inputDistance) {
		distanceToTarget = (float)inputDistance;
	}
	
	public float timeToIntercept() {
		return (distanceToTarget/constantSpeed);
	}
	
	public Projectile(float inputDistanceToTarget, float projectileSpeed) {
		distanceToTarget = inputDistanceToTarget;
		constantSpeed = projectileSpeed;
	}
}
