package writeToFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyJokeFileWriter {

	public static void main(String[] args) {
		writeToFile(createFile());
	}
	
	public static File createFile() {
		try {
			File myFile = new File("CS111_EvenOdd.txt");
			
			if (myFile.createNewFile()) {
				System.out.println("File created: " + myFile.getName());
			} else {
				System.out.println("File already exists at the following location: " + myFile.getAbsolutePath());
			}
			
			return myFile;
		} catch (IOException exception) {
			System.out.println("So sorry, an error occurred:");
			exception.printStackTrace();
			return null;
		}		
	}
	
	public static void writeToFile(File inputFile) {
		try {
			FileWriter myFileWriter = new FileWriter("CS111_EvenOdd.txt");
			
			myFileWriter.write("//This function checks from 1 - 1M if the input integer is even\npublic boolean isEven(int inputInt) {\n	if (inputInt == 1) {\n		return false;\n	}");
			
			for (int i = 0; i < 1000000; i++) {
				String outputLine;
				
				if (i % 2 == 0) {
					outputLine = ") {\n		return false;\n	}";
				} else {
					outputLine = ") {\n		return true;\n	}";
				}
				myFileWriter.write(" else if (inputInt == " + (i + 1) + outputLine);
			}
			
			myFileWriter.write("\n}");
			myFileWriter.close();
			
			System.out.println("Successfully wrote to file");
		} catch (IOException exception) {
			System.out.println("The following error occurred: ");
			exception.printStackTrace();
		}
	}
}
