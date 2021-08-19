package writeToFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {

	public static void main(String[] args) {
		writeToFile(createFile());
	}
	
	public static File createFile() {
		try {
			File myFile = new File("testFile03.txt");
			
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
			FileWriter myFileWriter = new FileWriter("testFile03.txt");
			
			for (int i = 0; i < 1000000; i++) {
				myFileWriter.write((i + 1) + ") Files in Java might be tricky, but they're fun!\n");
			}
			myFileWriter.close();
			System.out.println("Successfully wrote to file");
		} catch (IOException exception) {
			System.out.println("The following error occurred: ");
			exception.printStackTrace();
		}
	}
}
