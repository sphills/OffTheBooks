package tinyProgram;

public class TinyProgramNarrator {

	private String userName = null;
	String query = "";
	String response = "";
	private TinyProgramReader programReader;
	
	public void respondToInput(int inputSwitch) {
		
		switch (inputSwitch) {
		case 0:
			response = "Hello " + userName + ", my name is Le Chiffre. Would you like to hear a story?";
			break;
		case 1:
			response = "There was once a person named " + userName + ". They were an asshole.";
			break;
		case 2:
			response = "This response is uncoded.";
			break;
		case 3:
			response = "This response is uncoded."; 
			break;
		case 4:
			response = "This response is uncoded."; 
			break;
		default:
			response = "Sorry, I didn't quite catch  that.";	
		}
		
		System.out.println(response);
	}
	
	public void setUserName(String inputUserName) {
		userName = inputUserName;
		respondToInput(0);
	}
	
	public void queryUser() {
		System.out.println(query);
		
	}
	
	public void sayGoodBye() {
		System.out.println("Ah, I see. Have a good day!");
	}
	
	public TinyProgramNarrator(TinyProgramReader inputReader) {
		programReader = inputReader;
	}
	
	public boolean isUserNameSet() {
		if (userName != null) {
			return true;
		} else {
			return false;
		}
	}
}
