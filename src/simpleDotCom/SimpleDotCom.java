package simpleDotCom;

public class SimpleDotCom {

	int[] locationCells;
	int numOfHits = 0;
	
	public void setLocationCells(int[] locations) {
		locationCells = locations;
	}
	
	public String checkYourself(String stringGuess) {
		int guess = Integer.parseInt(stringGuess);
		String result = "Miss";
		
		for (int cell : locationCells) {
			if (guess == cell) {
				result = "Hit";
				numOfHits++;
				break;
			}
		}
		
		if (numOfHits == locationCells.length) {
			result = "Kill";
		}
		
		System.out.println(result);
		return result;
	}
}
