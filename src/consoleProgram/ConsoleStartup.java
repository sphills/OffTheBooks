package consoleProgram;

import java.util.Scanner;

public class ConsoleStartup {

	static Scanner userInputScanner;
	
	public static void main(String[] args) {
		userInputScanner = new Scanner(System.in);
		
		BaseMenu currentMenu = new MainMenu();
		
		System.out.println("Hello. Would you like to play a game?");
		promptGameStart(currentMenu);
	}
	
	private static void promptGameStart(BaseMenu inputMainMenu) {
		System.out.println("(Y)es");
		System.out.println("(N)o");
		
		if ((userInputScanner.nextLine().toLowerCase().startsWith("y"))) {
			inputMainMenu.drawMenu();
		};
	}
}
