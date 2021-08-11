package lootGenerator;

public class BaseChestPiece extends BaseGearPiece {
	static int chestPieceInstances = 0;
	
	public BaseChestPiece() {
		chestPieceInstances++;
	}
	
	public static void getGearInstances() {
		System.out.println("There are " + chestPieceInstances + " chest pieces out in the world.");
		System.out.println("All chest pieces account for " + ( ((float) chestPieceInstances/numberOfGearInstances) * 100) + "% of gear in the world.");
	}
}
