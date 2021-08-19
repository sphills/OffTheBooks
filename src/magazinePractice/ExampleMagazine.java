package magazinePractice;

public class ExampleMagazine {

	int currentAmmoCapacity = 30;
	int maximumAmmoCapacity = 30;
	String magazineName;
	
	public boolean hasAmmoLeft() {
		if (currentAmmoCapacity > 0) {
			currentAmmoCapacity -= 1;
			return true;
		} else {
			return false;
		}
	}
	
	public void insertRound() {
		if (currentAmmoCapacity < maximumAmmoCapacity) {
			currentAmmoCapacity++;
		}
	}
	
	public void insertRounds(int amountToAdd) {
		if (currentAmmoCapacity + amountToAdd > maximumAmmoCapacity) {
			System.out.println((amountToAdd - currentAmmoCapacity) + " of " + amountToAdd + " rounds inserted into magazine.");
			System.out.println("Magazine is now full (maximum capacity is 30 rounds).");
			currentAmmoCapacity = maximumAmmoCapacity;
		} else {
			System.out.println("Adding " + amountToAdd + " new rounds...");
			currentAmmoCapacity += amountToAdd;
			System.out.println("Magazine now has " + currentAmmoCapacity + " rounds in it.");
		}
	}
	
	public String toString() {
		return magazineName;
	}
	
	public ExampleMagazine(String inputMagazineName) {
		magazineName = inputMagazineName;
	}
}
