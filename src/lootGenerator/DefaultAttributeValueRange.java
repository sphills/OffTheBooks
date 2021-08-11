package lootGenerator;

import java.util.Random;

public class DefaultAttributeValueRange implements AttributeValueRange {

	public int assignAttributeValue(BaseGearPiece inputGearPiece) {
		Random randomRoll = new Random();
		int randomSelection = randomRoll.nextInt();
		
		switch (inputGearPiece.getGearRarityEnum()) {
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
		case LEGENDARY: case EXOTIC: case GEAR_SET:
			randomSelection = (randomRoll.nextInt(500 - 401) + 401);
			break;
		default:
			randomSelection = (randomRoll.nextInt(100 - 1) + 1);
			break;
		}
		
		return randomSelection;
	}
}