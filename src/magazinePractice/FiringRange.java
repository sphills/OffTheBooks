package magazinePractice;

public class FiringRange {

	public static void main(String[] args) {
		ExampleWeapon testWeapon = new ExampleWeapon();
		ExampleMagazine testMagazine01 = new ExampleMagazine("TestMagazine01");
		ExampleMagazine testMagazine02 = new ExampleMagazine("TestMagazine02");
		
		testWeapon.fireWeapon();
		testWeapon.loadWeapon(testMagazine01);
		testWeapon.fireWeapon();
		testWeapon.reloadWeapon(testMagazine02);
		testWeapon.fireWeapon();
		testWeapon.reloadWeapon(testMagazine01);
		testWeapon.fireWeapon();
		testWeapon.fireWeapon();
		testWeapon.fireWeapon();
		testMagazine01.insertRounds(28);
		testMagazine01.insertRounds(30);
	}
}
