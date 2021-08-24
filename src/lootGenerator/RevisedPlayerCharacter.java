package lootGenerator;

public class RevisedPlayerCharacter {
	int Health = 0;
	int Weapons = 0;
	int Technology = 0;
	private BaseGearPiece equippedGearPieces[] = new BaseGearPiece[6];
	CharacterAnalyzer characterAnalyzer = new CharacterAnalyzer(this);
	
	public void equipGearItem(BaseGearPiece equippingGearItem) {
		
		switch (equippingGearItem.getGearPieceEnum()) {
			case MASK:
				unequipGearItem(equippedGearPieces[0]);
				equippedGearPieces[0] = equippingGearItem;
				break;
			case CHEST:
				unequipGearItem(equippedGearPieces[1]);
				equippedGearPieces[1] = equippingGearItem;
				break;
			case BACKPACK:
				unequipGearItem(equippedGearPieces[2]);
				equippedGearPieces[2] = equippingGearItem;
				break;
			case GLOVES:
				unequipGearItem(equippedGearPieces[3]);
				equippedGearPieces[3] = equippingGearItem;
				break;
			case HOLSTER:
				unequipGearItem(equippedGearPieces[4]);
				equippedGearPieces[4] = equippingGearItem;
				break;
			case KNEEPADS:
				unequipGearItem(equippedGearPieces[5]);
				equippedGearPieces[5] = equippingGearItem;
				break;
		}
				
		switch (equippingGearItem.getGearAttributeEnum()) {
			case HEALTH:
				Health += equippingGearItem.getCharacterAttributeValue();
				break;
			case WEAPONS:
				Weapons += equippingGearItem.getCharacterAttributeValue();
				break;
			case TECHNOLOGY:
				Technology += equippingGearItem.getCharacterAttributeValue();
				break;
		}
	}
	
	private void unequipGearItem(BaseGearPiece unequippingGearItem) {
		
		if (unequippingGearItem == null) {
			
		} else {
			
			switch (unequippingGearItem.getGearAttributeEnum()) {
				case HEALTH:
					Health -= unequippingGearItem.getCharacterAttributeValue();
					break;
				case WEAPONS:
					Weapons -= unequippingGearItem.getCharacterAttributeValue();
					break;
				case TECHNOLOGY:
					Technology -= unequippingGearItem.getCharacterAttributeValue();
					break;
			}
		}
	}
	
	public void tellStats() {
		System.out.println("\nThe player has " + Health + " points for health, " + Weapons + " points for weapons, and " + Technology + " points for technology.");

		for (int i = 0; i < equippedGearPieces.length; i++) {
			if (equippedGearPieces[i] == null) {
				System.out.println("This gear slot is empty");
			} else {
				equippedGearPieces[i].describeSelf();
			}
		}
		
		characterAnalyzer.greatestStat();
		characterAnalyzer.smallestStat();
		characterAnalyzer.checkBuildComposition();
		
	}
	
	public BaseGearPiece[] getEquippedGearPieces() {
		return equippedGearPieces;
	}

	public int getHealth() {
		return Health;
	}

	public int getWeapons() {
		return Weapons;
	}

	public int getTechnology() {
		return Technology;
	}
	
	public BaseGearPiece getEquippedMaskPiece() {
		return equippedGearPieces[0];
	}

	public void equippedMaskToString() {
		System.out.println(equippedGearPieces[0].getCharacterAttributeValue() + " " + equippedGearPieces[0].getGearAttributeEnum().toString() + " " + equippedGearPieces[0].getGearPieceEnum().toString() + isCurrentlyEquipped());
	}
	
	public BaseGearPiece getEquippedChestPiece() {
		return equippedGearPieces[1];
	}

	public void equippedChestToString() {
		System.out.println(equippedGearPieces[1].getCharacterAttributeValue() + " " + equippedGearPieces[1].getGearAttributeEnum().toString() + " " + equippedGearPieces[1].getGearPieceEnum().toString() + isCurrentlyEquipped());
	}
	
	public BaseGearPiece getEquippedBackpackPiece() {
		return equippedGearPieces[2];
	}

	public BaseGearPiece getEquippedGlovesPiece() {
		return equippedGearPieces[3];
	}

	public BaseGearPiece getEquippedHolsterPiece() {
		return equippedGearPieces[4];
	}

	public BaseGearPiece getEquippedKneepadPiece() {
		return equippedGearPieces[5];
	}
	
	public String isCurrentlyEquipped() {
		return " is currently equipped.";
	}
	
	public CharacterAnalyzer getAnalyzer() {
		return characterAnalyzer;
	}
}
