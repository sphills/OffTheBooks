package lootGenerator;

import java.util.Random;

public class EqualGearPieceGenerator implements GearPieceGeneration {

	public BaseGearPiece generateGearPiece() {
		BaseGearPiece generatedGearPiece = null;
		Random randomRoll = new Random();
		int randomSelection = randomRoll.nextInt(6);
		
		switch (randomSelection) {
		case 0:
			generatedGearPiece = new BaseChestPiece();
			break;
		case 1:
			generatedGearPiece = new BaseMaskPiece();
			break;
		case 2:
			generatedGearPiece = new BaseBackpackPiece();
			break;
		case 3:
			generatedGearPiece = new BaseGlovesPiece();
			break;
		case 4:
			generatedGearPiece = new BaseHolsterPiece();
			break;
		case 5:
			generatedGearPiece = new BaseKneepadsPiece();
			break;
		}
		
		return generatedGearPiece;
	}
}
