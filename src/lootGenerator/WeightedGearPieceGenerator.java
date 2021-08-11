package lootGenerator;

import java.util.ArrayList;
import java.util.Random;

public class WeightedGearPieceGenerator implements GearPieceGeneration {

	private ArrayList<GearPieceEnums> gearPieces = null;
	
	public BaseGearPiece generateGearPiece() {
		BaseGearPiece generatedGearPiece = null;
		Random randomRoll = new Random();
		int randomSelection = randomRoll.nextInt(gearPieces.size());
		
		switch (gearPieces.get(randomSelection)) {
		case MASK:
			generatedGearPiece = new BaseMaskPiece();
			break;
		case CHEST:
			generatedGearPiece = new BaseChestPiece();
			break;
		case BACKPACK:
			generatedGearPiece = new BaseBackpackPiece();
			break;
		case GLOVES:
			generatedGearPiece = new BaseGlovesPiece();
			break;
		case HOLSTER:
			generatedGearPiece = new BaseHolsterPiece();
			break;
		case KNEEPADS:
			generatedGearPiece = new BaseKneepadsPiece();
			break;
		}
		
		return generatedGearPiece;
	}
	
	public WeightedGearPieceGenerator() {
		gearPieces = new ArrayList<GearPieceEnums>();
		int weights = 0;
		
		for (weights = 0; weights < 75; weights++) {
			gearPieces.add(GearPieceEnums.CHEST);
		}
		
		for (weights = 75; weights < 80; weights++) {
			gearPieces.add(GearPieceEnums.BACKPACK);
		}
		
		for (weights = 80; weights < 85; weights++) {
			gearPieces.add(GearPieceEnums.MASK);
		}
		
		for (weights = 85; weights < 90; weights++) {
			gearPieces.add(GearPieceEnums.GLOVES);
		}
		
		for (weights = 90; weights < 95; weights++) {
			gearPieces.add(GearPieceEnums.HOLSTER);
		}
		
		for (weights = 95; weights < 100; weights++) {
			gearPieces.add(GearPieceEnums.KNEEPADS);
		}
	}
	
	public WeightedGearPieceGenerator(int inputWeight) {
		gearPieces = new ArrayList<GearPieceEnums>();
		int weights = 0;
		int maxWeight = inputWeight;
		
		int remainder = (int)((100 - inputWeight)/5);
		
		for (weights = 0; weights < maxWeight; weights++) {
			gearPieces.add(GearPieceEnums.CHEST);
		}
		
		for (weights = maxWeight; weights < (maxWeight + remainder); weights++) {
			gearPieces.add(GearPieceEnums.BACKPACK);
		}
		
		for (weights = (maxWeight + remainder); weights < (maxWeight + (remainder * 2)); weights++) {
			gearPieces.add(GearPieceEnums.MASK);
		}
		
		for (weights = (maxWeight + (remainder * 2)); weights < (maxWeight + (remainder * 3)); weights++) {
			gearPieces.add(GearPieceEnums.GLOVES);
		}
		
		for (weights = (maxWeight + (remainder * 3)); weights < (maxWeight + (remainder * 4)); weights++) {
			gearPieces.add(GearPieceEnums.HOLSTER);
		}
		
		for (weights = (maxWeight + (remainder * 4)); weights < (maxWeight + (remainder * 5)); weights++) {
			gearPieces.add(GearPieceEnums.KNEEPADS);
		}
	}
}
