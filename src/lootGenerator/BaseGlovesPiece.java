package lootGenerator;

public class BaseGlovesPiece extends BaseGearPiece {
	static int glovesPieceInstances = 0;
	
	public BaseGlovesPiece() {
		GearPieceEnum = GearPieceEnums.GLOVES;
		glovesPieceInstances++;
	}
	
	public static void getGearInstances() {
		System.out.println("There are " + glovesPieceInstances + " pairs of gloves out in the world.");
		System.out.println("All gloves account for " + ( ((float) glovesPieceInstances/numberOfGearInstances) * 100) + "% of gear in the world.");
	}
}
