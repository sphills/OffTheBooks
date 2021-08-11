package lootGenerator;

public class InitialPlayerCharacter {
	int Health = 0;
	int Weapons = 0;
	int Technology = 0;
	BaseGearPiece equippedMaskPiece = null;
	BaseGearPiece equippedChestPiece = null;
	BaseGearPiece equippedBackpackPiece = null;
	BaseGearPiece equippedGlovesPiece = null;
	BaseGearPiece equippedHolsterPiece = null;
	BaseGearPiece equippedKneepadPiece = null;
	
	public void equipGearItem(BaseGearPiece equippingGearItem) {
		
		switch (equippingGearItem.getGearPieceEnum()) {
			case MASK:
				unequipGearItem(equippedMaskPiece);
				equippedMaskPiece = equippingGearItem;
				break;
			case CHEST:
				unequipGearItem(equippedChestPiece);
				equippedChestPiece = equippingGearItem;
				break;
			case BACKPACK:
				unequipGearItem(equippedBackpackPiece);
				equippedBackpackPiece = equippingGearItem;
				break;
			case GLOVES:
				unequipGearItem(equippedGlovesPiece);
				equippedGlovesPiece = equippingGearItem;
				break;
			case HOLSTER:
				unequipGearItem(equippedHolsterPiece);
				equippedHolsterPiece = equippingGearItem;
				break;
			case KNEEPADS:
				unequipGearItem(equippedKneepadPiece);
				equippedKneepadPiece = equippingGearItem;
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
		equippedMaskPiece.describeSelf();
		equippedChestPiece.describeSelf();
		equippedBackpackPiece.describeSelf();
		equippedGlovesPiece.describeSelf();
		equippedHolsterPiece.describeSelf();
		equippedKneepadPiece.describeSelf();
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
		return equippedMaskPiece;
	}

	public BaseGearPiece getEquippedChestPiece() {
		return equippedChestPiece;
	}

	public BaseGearPiece getEquippedBackpackPiece() {
		return equippedBackpackPiece;
	}

	public BaseGearPiece getEquippedGlovesPiece() {
		return equippedGlovesPiece;
	}

	public BaseGearPiece getEquippedHolsterPiece() {
		return equippedHolsterPiece;
	}

	public BaseGearPiece getEquippedKneepadPiece() {
		return equippedKneepadPiece;
	}
}
