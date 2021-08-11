package lootGenerator;

import java.util.Random;

public class LootGenerator {

	public BaseGearPiece generateGearItem() {
		BaseGearPiece generatedGearItem = null;
		Random randomRoll = new Random();
		int randomSelection = randomRoll.nextInt(2);
		
		switch (randomSelection) {
			case 0:
				generatedGearItem = new BaseChestPiece();
				break;
			case 1:
				generatedGearItem = new BaseKneepadsPiece();
				break;
		}
		
		randomSelection = randomRoll.nextInt(7);
		
		switch (randomSelection) {
			case 0:
				generatedGearItem.setGearRarityEnum(RarityEnums.COMMON);
				break;
			case 1:
				generatedGearItem.setGearRarityEnum(RarityEnums.UNCOMMON);
				break;
			case 2:
				generatedGearItem.setGearRarityEnum(RarityEnums.RARE);
				break;
			case 3:
				generatedGearItem.setGearRarityEnum(RarityEnums.UNIQUE);
				break;
			case 4:
				generatedGearItem.setGearRarityEnum(RarityEnums.LEGENDARY);
				break;
			case 5:
				generatedGearItem.setGearRarityEnum(RarityEnums.EXOTIC);
				break;
			case 6:
				generatedGearItem.setGearRarityEnum(RarityEnums.GEAR_SET);
				break;
		}
		
		randomSelection = randomRoll.nextInt(3);
		
		switch (randomSelection) {
			case 0:
				generatedGearItem.setGearAttributeEnum(CharacterAttributeEnums.HEALTH);
				break;
			case 1:
				generatedGearItem.setGearAttributeEnum(CharacterAttributeEnums.WEAPONS);
				break;
			case 2:
				generatedGearItem.setGearAttributeEnum(CharacterAttributeEnums.TECHNOLOGY);
				break;
		}
		
		switch (generatedGearItem.getGearRarityEnum()) {
		case COMMON:
			randomSelection = (randomRoll.nextInt(100 - 1) + 1);
			break;
		case UNCOMMON:
			randomSelection = (randomRoll.nextInt(200 - 101) + 101);
			break;
		case RARE:
			randomSelection = (randomRoll.nextInt(300 - 201) + 201);
			break;
		case UNIQUE:
			randomSelection = (randomRoll.nextInt(400 - 301) + 301);
			break;
		case LEGENDARY:
			randomSelection = (randomRoll.nextInt(500 - 401) + 401);
			break;
		case EXOTIC:
			randomSelection = (randomRoll.nextInt(600 - 501) + 501);
			break;
		case GEAR_SET:
			randomSelection = (randomRoll.nextInt(600 - 501) + 501);
			break;
		default:
			randomSelection = (randomRoll.nextInt(100 - 1) + 1);
			break;
		}
		
		generatedGearItem.setCharacterAttributeValue(randomSelection);
		generatedGearItem.describeSelf();
		
		return generatedGearItem;
	}
}
