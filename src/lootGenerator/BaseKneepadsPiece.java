package lootGenerator;

public class BaseKneepadsPiece extends BaseGearPiece {
	static int kneepadsPieceInstances = 0;
	
	public BaseKneepadsPiece() {
		GearPieceEnum = GearPieceEnums.KNEEPADS;
		kneepadsPieceInstances++;
	}
	
	public static void getGearInstances() {
		System.out.println("There are " + kneepadsPieceInstances + " sets of kneepads out in the world.");
		System.out.println("All kneepads account for " + ( ((float) kneepadsPieceInstances/numberOfGearInstances) * 100) + "% of gear in the world.");
	}
}
