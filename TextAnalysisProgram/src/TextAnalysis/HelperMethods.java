package TextAnalysis;

import java.io.FileInputStream;
import java.util.Scanner;

public class HelperMethods {
	
	public static String convertTextFile(String location) throws Exception {
		String textFromFile = "";
		Scanner scanner = new Scanner (new FileInputStream(location));
		while (scanner.hasNextLine()) {
			textFromFile += scanner.nextLine();
		}
		return textFromFile;
	}

}
