package lootGenerator;

public class BaseMaskPiece extends BaseGearPiece {
	static int maskPieceInstances = 0;
	
	public BaseMaskPiece() {
		GearPieceEnum = GearPieceEnums.MASK;
		maskPieceInstances++;
	}
	
	public static void getGearInstances() {
		System.out.println("There are " + maskPieceInstances + " masks out in the world.");
		System.out.println("All masks account for " + ( ((float) maskPieceInstances/numberOfGearInstances) * 100) + "% of gear in the world.");
	}
}
