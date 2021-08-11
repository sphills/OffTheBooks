package lootGenerator;

public class BaseGearPiece {
	int CharacterAttributeValue = 0;
	RarityEnums GearRarityEnum = RarityEnums.COMMON;
	CharacterAttributeEnums GearAttributeEnum = CharacterAttributeEnums.HEALTH;
	GearPieceEnums GearPieceEnum = GearPieceEnums.CHEST;
	static int numberOfGearInstances = 0;
	
	public GearPieceEnums getGearPieceEnum() {
		return GearPieceEnum;
	}

	public void setGearPieceEnum(GearPieceEnums gearPieceEnum) {
		GearPieceEnum = gearPieceEnum;
	}

	public int getCharacterAttributeValue() {
		return CharacterAttributeValue;
	}
	
	public void setCharacterAttributeValue(int characterAttributeValue) {
		CharacterAttributeValue = characterAttributeValue;
	}
	
	public RarityEnums getGearRarityEnum() {
		return GearRarityEnum;
	}
	
	public void setGearRarityEnum(RarityEnums gearRarityEnum) {
		GearRarityEnum = gearRarityEnum;
	}
	
	public CharacterAttributeEnums getGearAttributeEnum() {
		return GearAttributeEnum;
	}
	
	public void setGearAttributeEnum(CharacterAttributeEnums gearAttributeEnum) {
		GearAttributeEnum = gearAttributeEnum;
	}
	
	public static void getGearInstances() {}
	
	public void describeSelf() {
		System.out.println("This item is a " + GearRarityEnum + this.getClass() + " with a " + CharacterAttributeValue + " point bonus to " + GearAttributeEnum + ".");
	}
	
	public BaseGearPiece() {
		numberOfGearInstances++;
	}
}
