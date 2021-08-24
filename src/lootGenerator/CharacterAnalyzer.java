package lootGenerator;

public class CharacterAnalyzer {

	private RevisedPlayerCharacter revisedPlayerCharacterToAnalyze = null;
	
	public CharacterAnalyzer(RevisedPlayerCharacter inputPlayerCharacter ) {
		revisedPlayerCharacterToAnalyze = inputPlayerCharacter;
	}
	
	public void greatestStat() {
		
		System.out.println();
		if (revisedPlayerCharacterToAnalyze.getHealth() > revisedPlayerCharacterToAnalyze.getWeapons()) {
			if (revisedPlayerCharacterToAnalyze.getHealth() > revisedPlayerCharacterToAnalyze.getTechnology()) {
				System.out.println("Health reigns supreme, with " + revisedPlayerCharacterToAnalyze.getHealth() + " points to ensure your continued survival.");
			} else {
				System.out.println("Technology reigns supreme, with " + revisedPlayerCharacterToAnalyze.getTechnology() + " points to command over your electronics.");
			}
		} else {
			if (revisedPlayerCharacterToAnalyze.getWeapons() > revisedPlayerCharacterToAnalyze.getTechnology()) {
				System.out.println("Weapons Skill reigns supreme, with " + revisedPlayerCharacterToAnalyze.getWeapons() + " points to devastate the battlefield with.");
			} else {
				System.out.println("Technology reigns supreme, with " + revisedPlayerCharacterToAnalyze.getTechnology() + " points to command over your electronics.");
			}
		}
	}
	
	public void smallestStat() {
		
		System.out.println();
		if (revisedPlayerCharacterToAnalyze.getHealth() > revisedPlayerCharacterToAnalyze.getWeapons()) {
			if (revisedPlayerCharacterToAnalyze.getTechnology() > revisedPlayerCharacterToAnalyze.getWeapons()) {
				System.out.println("Weapons Skill is your weakest stat, with " + revisedPlayerCharacterToAnalyze.getWeapons() + " points total. You may want to try equipping gear to bring it in line with Health and Technology.");
			} else if (revisedPlayerCharacterToAnalyze.getTechnology() == revisedPlayerCharacterToAnalyze.getWeapons()){
				System.out.println("Your technology and weapons skills are balanced nicely. Congratulations!\n");
			} else {
				System.out.println("Technology is your weakest stat, with " + revisedPlayerCharacterToAnalyze.getTechnology() + " points total. You may want to try equipping gear to bring it in line with Health and Weapons.");
			}
		} else {
			if (revisedPlayerCharacterToAnalyze.getTechnology() > revisedPlayerCharacterToAnalyze.getHealth()) {
				System.out.println("Health is your weakest stat, with " + revisedPlayerCharacterToAnalyze.getHealth() + " points total. You may want to try equipping gear to bring it in line with Weapons and Technology.");
			} else if (revisedPlayerCharacterToAnalyze.getTechnology() == revisedPlayerCharacterToAnalyze.getHealth()) {
				System.out.println("Your technology and health are balanced nicely. Congratulations!\n");
			} else {
				System.out.println("Technology is your weakest stat, with " + revisedPlayerCharacterToAnalyze.getTechnology() + " points total. You may want to try equipping gear to bring it in line with Weapons and Health.");
			}
		}
		
		System.out.println();
	}

	public void checkBuildComposition() {
		int healthAttributes = 0;
		int weaponsAttributes = 0;
		int technologyAttributes = 0;
		
		BaseGearPiece gearPieceInventory[] = new BaseGearPiece[6];
		
		gearPieceInventory = revisedPlayerCharacterToAnalyze.getEquippedGearPieces();
		
		for (int i = 0; i < gearPieceInventory.length; i++) {
			if (gearPieceInventory[i] == null) {
				
			} else {
		
				if (gearPieceInventory[i].getGearAttributeEnum() == CharacterAttributeEnums.HEALTH) {
					healthAttributes++;
				} else if (gearPieceInventory[i].getGearAttributeEnum() == CharacterAttributeEnums.WEAPONS) {
					weaponsAttributes++;
				} else {
					technologyAttributes++;
				}
			}
		}
		
		System.out.println("You're wearing " + healthAttributes + " pieces of HEALTH gear, " + weaponsAttributes + " pieces of WEAPONS gear, and " + technologyAttributes + " pieces of TECHNOLOGY gear.");
		
		if (healthAttributes == weaponsAttributes && healthAttributes == technologyAttributes) {
			System.out.println("Hey, your build is pretty well balanced! Nice job!");
			System.out.println("If you ever feel like you're not doing enough damage, try to swap a HEALTH gear piece or a TECHNOLOGY gear piece with a WEAPONS gear piece.");
			System.out.println("If you ever feel like you don't have enough survivability, try to swap a WEAPOSN gear piece or a TECHNOLOGY gear piece with a HEALTH gear piece.");
		}
		
		if (healthAttributes == 0) {
			System.out.println("You don't have any pieces of gear with a health value on. May we suggest wearing at least one with health on it?");
		}
		
		if (weaponsAttributes == 0) {
			System.out.println("You don't have any pieces of gear with a weapons skill value on. May we suggest wearing at least one with weapons skill on it?");
		}
		
		if (technologyAttributes == 0) {
			System.out.println("You don't have any pieces of gear with a technology proficiency value on. May we suggest wearing at least one with technology proficiency on it?");
		}
	}
	
	public int returnStatValue(CharacterAttributeEnums requestedAttributeEnum) {
		int attributeValue = 0;

		BaseGearPiece gearPieceInventory[] = new BaseGearPiece[6];

		gearPieceInventory = revisedPlayerCharacterToAnalyze.getEquippedGearPieces();	
	
		for (int i = 0; i < gearPieceInventory.length; i++) {
			if (gearPieceInventory[i].getGearAttributeEnum() == requestedAttributeEnum) {
				attributeValue += gearPieceInventory[i].getCharacterAttributeValue();
			}
		}

		System.out.println(attributeValue);
		return attributeValue;
	}
}
