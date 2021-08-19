package simpleDotCom;

import java.util.Random;

public class SimpleDotComGame {

	public static void main(String[] args) {
		int numOfGuesses = 0;
		GameHelper gameHelper = new GameHelper();
		
		SimpleDotCom newGame = new SimpleDotCom();
		
		Random randomNumber = new Random();
		int startOffset = randomNumber.nextInt(8);
		int[] locations = {startOffset, startOffset + 1, startOffset + 2};
		newGame.setLocationCells(locations);
		
		boolean gameIsRunning = true;
		
		while (gameIsRunning) {
			String userGuess = gameHelper.getUserInput("Enter a number");
			String result = newGame.checkYourself(userGuess);
			numOfGuesses++;
			if (result.toLowerCase().equals("kill")) {
				gameIsRunning = false;
				System.out.println("You took " + numOfGuesses + " guesses to win.");
			}
		}
	}
}
