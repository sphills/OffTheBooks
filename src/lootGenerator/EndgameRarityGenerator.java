package lootGenerator;

import java.util.Random;

public class EndgameRarityGenerator implements RarityGeneration {
	
	public RarityEnums generateRarity() {
		RarityEnums selectedEnum = null;
		Random randomRoll = new Random();
		int randomSelection = randomRoll.nextInt(7);
		
		switch (randomSelection) {
			case 0: case 1: case 2: case 3:
				selectedEnum = RarityEnums.LEGENDARY;
				break;
			case 4: case 5:
				selectedEnum = RarityEnums.GEAR_SET;
				break;	
			case 6:
				selectedEnum = RarityEnums.EXOTIC;
				break;
			
		}
		
		return selectedEnum;
	}
}
