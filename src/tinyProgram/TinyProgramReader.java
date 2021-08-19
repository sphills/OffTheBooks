package tinyProgram;

import java.util.Scanner;

public class TinyProgramReader {

	Scanner tinyProgramScanner;
	boolean isUserFinished = false;
	TinyProgramNarrator tinyProgramNarrator;
	int respondInteger = 0;
	
	public TinyProgramReader() {
		tinyProgramScanner = new Scanner(System.in);
		tinyProgramNarrator = new TinyProgramNarrator(this);
	}
	
	public void parseUserInput() {
		String userInput = tinyProgramScanner.nextLine();
		
		checkForExit(userInput);
		
		if (tinyProgramNarrator.isUserNameSet()) {
			tinyProgramNarrator.respondToInput(respondInteger);
			respondInteger++;
			System.out.println(respondInteger);
		} else {
			tinyProgramNarrator.setUserName(userInput);
		}
	}
	
	public void checkForExit(String userResponse) {
		String editedInput = userResponse.toLowerCase();
		
		if (editedInput == "no" || editedInput == "exit") {
			isUserFinished = true;
			tinyProgramNarrator.sayGoodBye();
			System.exit(0);
		}
	}
	
	public boolean userWantsToExit() {
		return isUserFinished;
	}
}
