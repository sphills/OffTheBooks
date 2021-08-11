package lootGenerator;

// This interface establishes a very basic generateGearPiece() method for use by various GearPieceGenerators
public interface GearPieceGeneration {

	// This function returns a BaseGearPiece or one of its children that's been created by a GearPieceGenerator
	public BaseGearPiece generateGearPiece();
}
