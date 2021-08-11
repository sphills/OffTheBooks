package lootGenerator;

import java.util.Random;

public class EarlygameRarityGenerator implements RarityGeneration {
	
	public RarityEnums generateRarity() {
		RarityEnums selectedEnum = null;
		Random randomRoll = new Random();
		int randomSelection = randomRoll.nextInt(7);
		
		switch (randomSelection) {
			case 0: case 1: case 2: case 3:
				selectedEnum = RarityEnums.COMMON;
				break;
			case 4: case 5:
				selectedEnum = RarityEnums.UNCOMMON;
				break;	
			case 6:
				selectedEnum = RarityEnums.RARE;
				break;
			
		}
		
		return selectedEnum;
	}
}
