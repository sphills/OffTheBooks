package lootGenerator;

import java.util.Random;
import java.util.ArrayList;

/* This class implements the GearPieceGeneration interface and allows for the drop rate of one type of gear piece to be 
 *  specified, with the intention of the majority of the generated GearPieces to be the targeted GearPiece,
 *  while the other (5 by default) GearPieces to share the rest of the chance, out of 10,000.
 */
public class TargetedGearPieceGenerator implements GearPieceGeneration {
	int targetedGearIndex;
	ArrayList<Integer> possiblePiecesArray = new ArrayList<Integer>();
	
	/* This function comes from the GearPieceGeneration interface and utilizes other methods within this TargetedGearPieceGenerator
	 * to choose which kind of BaseGearPiece or its children to return
	 */
	public BaseGearPiece generateGearPiece() {
		BaseGearPiece generatedGearPiece = null;
		Random randomRoll = new Random();
		int randomSelection = randomRoll.nextInt(10000);
		
		//9,000 times out of 10,000 (0 - 8999 inclusive), the generated gear piece should be the targetedGearIndex
		if (randomSelection <= 8999) {
			generatedGearPiece = proxyGearPieceGenerator(targetedGearIndex);
			
		//The other 1000 times, the generated gear piece should be one of the indices from the possiblePiecesArray
		} else if (randomSelection > 8999 && randomSelection <= 9999) {
			generatedGearPiece = proxyGearPieceGenerator(possiblePiecesArray.get(randomRoll.nextInt(possiblePiecesArray.size())));
		}
		
		return generatedGearPiece;
	}
	
	/*
	 * 
	 */
	BaseGearPiece proxyGearPieceGenerator(int inputPieceType) {
		BaseGearPiece proxyGearPiece = null;
		
		switch (inputPieceType) {
		case 0:
			proxyGearPiece = new BaseChestPiece();
			break;
		case 1:
			proxyGearPiece = new BaseMaskPiece();
			break;
		case 2:
			proxyGearPiece = new BaseBackpackPiece();
			break;
		case 3:
			proxyGearPiece = new BaseGlovesPiece();
			break;
		case 4:
			proxyGearPiece = new BaseHolsterPiece();
			break;
		case 5:
			proxyGearPiece = new BaseKneepadsPiece();
			break;
		}
		
		return proxyGearPiece;
	}

	public TargetedGearPieceGenerator() {
		Random randomRoll = new Random();
		targetedGearIndex = randomRoll.nextInt(6);
		
		for (int index = 0; index < 6; index++) {
			possiblePiecesArray.add(index);
		}
		
		possiblePiecesArray.remove(targetedGearIndex);
	}
	
	public TargetedGearPieceGenerator(int inputTargetedGearIndex) {
		if (inputTargetedGearIndex < 0) {
			System.out.println("The input integer was a disallowed number less than 0, so it has been corrected to 0.");
			targetedGearIndex = 0;
		} else if (inputTargetedGearIndex > 5) {
			System.out.println("The input integer was a disallowed number greater than 5, so it has been corrected to 5.");
			targetedGearIndex = 5;
		} else {
			targetedGearIndex = inputTargetedGearIndex;
		}
		
		for (int index = 0; index < 6; index++) {
			possiblePiecesArray.add(index);
		}
		
		possiblePiecesArray.remove(targetedGearIndex);
	}
}