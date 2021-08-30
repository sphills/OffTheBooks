package locationPredictor;

public class Projectile3D {

	double[] worldLocation3D = {0, 0, 0};
	double distanceToTarget = 0.0;
	double constantSpeed = 0.0;
	
	public void setDistanceToTarget(double[] targetWorldLocation3D) {
		distanceToTarget = Math.sqrt(Math.pow((targetWorldLocation3D[0] - worldLocation3D[0]), 2) + Math.pow((targetWorldLocation3D[0] - worldLocation3D[0]), 2) + Math.pow((targetWorldLocation3D[0] - worldLocation3D[0]), 2));
		System.out.println("Distance to target: " + distanceToTarget + "m");
	}
	
	public float timeToIntercept() {
		return (float)(distanceToTarget/constantSpeed);
	}
	
	public Projectile3D(double[] startingWorldLocation3D, float projectileSpeed) {
		worldLocation3D = startingWorldLocation3D;
		constantSpeed = projectileSpeed;
	}
}
