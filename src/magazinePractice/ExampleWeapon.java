package magazinePractice;

public class ExampleWeapon {

	ExampleMagazine equippedMagazine;
	
	public void fireWeapon() {
		if (equippedMagazine != null) {
			while (equippedMagazine.hasAmmoLeft()) {
				System.out.println("BANG!");
			}
		} else {
			System.out.println("No magazine equipped.");
		}
		
		System.out.println("Click.");
		
	}
	
	public void loadWeapon(ExampleMagazine inputMagazine) {
		equippedMagazine = inputMagazine;
		System.out.println(equippedMagazine.toString() +" in.");
	}
	
	public void emptyWeapon() {
		equippedMagazine = null;
	}
	
	public void reloadWeapon(ExampleMagazine inputMagazine) {
		System.out.println("Reloading weapon...");
		System.out.println(equippedMagazine.toString() + " out.");
		emptyWeapon();
		loadWeapon(inputMagazine);
	}
}
