package lootGenerator;

import java.util.Random;

public class LootComposer {
	RarityGeneration lootRarityGenerator = null;
	GearPieceGeneration gearPieceGenerator = null;
	AttributeValueRange attributeRangeGenerator = null;
	
	public BaseGearPiece generateGearItem() {
		BaseGearPiece generatedGearItem = null;
		Random randomRoll = new Random();
		int randomSelection = randomRoll.nextInt(3);
		
		generatedGearItem = gearPieceGenerator.generateGearPiece();
		
		generatedGearItem.setGearRarityEnum(lootRarityGenerator.generateRarity());
		
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
		
		generatedGearItem.setCharacterAttributeValue(attributeRangeGenerator.assignAttributeValue(generatedGearItem));
		
		//generatedGearItem.describeSelf();
		
		return generatedGearItem;
	}

	public RarityGeneration getLootRarityGenerator() {
		return lootRarityGenerator;
	}

	public void setLootRarityGenerator(RarityGeneration lootRarityGenerator) {
		this.lootRarityGenerator = lootRarityGenerator;
	}

	public GearPieceGeneration getGearPieceGenerator() {
		return gearPieceGenerator;
	}

	public void setGearPieceGenerator(GearPieceGeneration gearPieceGenerator) {
		this.gearPieceGenerator = gearPieceGenerator;
	}

	public AttributeValueRange getAttributeRangeGenerator() {
		return attributeRangeGenerator;
	}

	public void setAttributeRangeGenerator(AttributeValueRange attributeRangeGenerator) {
		this.attributeRangeGenerator = attributeRangeGenerator;
	}

	public LootComposer() {
		lootRarityGenerator = new EarlygameRarityGenerator();
		gearPieceGenerator = new EqualGearPieceGenerator();
		attributeRangeGenerator = new DefaultAttributeValueRange();
	}
	
	public LootComposer(RarityGeneration inputRarityGenerator) {
		lootRarityGenerator = inputRarityGenerator;
		gearPieceGenerator = new EqualGearPieceGenerator();
		attributeRangeGenerator = new DefaultAttributeValueRange();
	}
}
