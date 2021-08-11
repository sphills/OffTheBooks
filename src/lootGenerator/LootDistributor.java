package lootGenerator;

public class LootDistributor {
	
	public static void main(String[] args) {
		RevisedPlayerCharacter testCharacter = new RevisedPlayerCharacter();
		LootComposer lootComposer = new LootComposer();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 1000; k++){
					testCharacter.equipGearItem(lootComposer.generateGearItem());
				}
			}
			
			testCharacter.tellStats();
			System.out.println();
			getAllGearInstances();
		}
	}
	
	public static void getAllGearInstances() {
		BaseMaskPiece.getGearInstances();
		BaseChestPiece.getGearInstances();
		BaseBackpackPiece.getGearInstances();
		BaseGlovesPiece.getGearInstances();
		BaseHolsterPiece.getGearInstances();
		BaseKneepadsPiece.getGearInstances();
	}
}
