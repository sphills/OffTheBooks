package lootGenerator;

public class BaseBackpackPiece extends BaseGearPiece {
	static int backpackPieceInstances = 0;
	
	public BaseBackpackPiece() {
		GearPieceEnum = GearPieceEnums.BACKPACK;
		backpackPieceInstances++;
	}
	
	public static void getGearInstances() {
		System.out.println("There are " + backpackPieceInstances + " backpacks out in the world.");
		System.out.println("All backpacks account for " + ( ((float) backpackPieceInstances/numberOfGearInstances) * 100) + "% of gear in the world.");
	}
}
