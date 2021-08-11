package lootGenerator;

public class BaseHolsterPiece extends BaseGearPiece {
	static int holsterPieceInstances = 0;
	
	public BaseHolsterPiece() {
		GearPieceEnum = GearPieceEnums.HOLSTER;
		holsterPieceInstances++;
	}
	
	public static void getGearInstances() {
		System.out.println("There are " + holsterPieceInstances + " holsters out in the world.");
		System.out.println("All holsters account for " + ( ((float) holsterPieceInstances/numberOfGearInstances) * 100) + "% of gear in the world.");
	}
}
