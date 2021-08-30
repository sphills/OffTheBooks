package locationPredictor;

public class TestScenario {

	public static void main(String[] args) {
		Target testTarget = new Target(0.0f,100.0f);
		LocationPredictor testPredictor = new LocationPredictor();
		Projectile testProjectile = new Projectile(1000, 5000);
		Target2D testTarget2D = new Target2D(0, 0, -100, 100);
		
		Target3D testTarget3D = new Target3D(new double[]{0, 0, 0}, 100, 50, 250);
		Projectile3D testProjectile3D = new Projectile3D(new double[] {1000, 1000, 1000}, 2000);
		testProjectile3D.setDistanceToTarget(testTarget3D.getWorldLocation3D());
		
		System.out.println("Current location: " + testTarget3D.tellCurrentLocation());
		System.out.println(testPredictor.predictLocation(testTarget3D.getWorldLocation3D(), testTarget3D.getCurrentRightSpeed(), testTarget3D.getCurrentForwardSpeed(), testTarget3D.getCurrentUpSpeed(), testProjectile3D.timeToIntercept()));
		
	}
}
