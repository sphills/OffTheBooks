package displayLoot;

import java.util.ArrayList;

import lootGenerator.BaseGearPiece;
import lootGenerator.LootComposer;
import lootGenerator.RevisedPlayerCharacter;

public class DisplayInitializer {

	public static void main(String[] args) {
		LootComposer lootDistributor = new LootComposer();
		ArrayList<BaseGearPiece> testGearList = new ArrayList<BaseGearPiece>();
		RevisedPlayerCharacter testCharacter = new RevisedPlayerCharacter();
   	 
		for (int i = 0; i < 1000000; i++) {
			testGearList.add(lootDistributor.generateGearItem());
		}
		
		tabPane2 testTabPane = new tabPane2(testGearList, testCharacter);
		
	}
}
