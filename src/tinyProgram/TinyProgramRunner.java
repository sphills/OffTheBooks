package tinyProgram;

public class TinyProgramRunner {

	public static void main(String[] args) {
		TinyProgramReader testReader = new TinyProgramReader();
	
		System.out.println("Hello! What's your name?");
		
		while (!testReader.userWantsToExit()) {
			testReader.parseUserInput();
		}
	}
}
