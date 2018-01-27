package TextAnalysis;
import java.io.FileInputStream;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int programMode;
		int inputType;
		
		do {
			System.out.println("Welcome to the LG Text Analysis Program\r\n\r\nPlease select the mode you would like to use?");
			System.out.println("1: Full mode\r\n2: Demo mode\r\nTo exit the program enter 0");
		
			programMode = sc.nextInt();
		
			if (programMode == 1) {
				do {
				System.out.println("How would you like to enter your text?\n1: Keyboard\n2: Import a .txt file\nTo return to the main menu press 0");
				inputType = sc.nextInt();
	
					if (inputType == 1) {
						System.out.println("Please enter the text you would like to analyse:");
						String keyboardInput = sc.next();
						TextAnalysis textAnalysis = new TextAnalysis(keyboardInput);
						System.out.println("Full mode");
						System.out.println(textAnalysis.toString());
						TextAnalysis.displayFrequencies(TextAnalysis.getCharacterFrequency(), TextAnalysis.characterArray);
						TextAnalysis.barChartFrequencies(TextAnalysis.getCharacterFrequency(), TextAnalysis.characterArray);
					}
					else if(inputType == 2) {
						System.out.println("Please enter the full location of the .txt file including the path e.g. C/code/text.txt:");
						String location = sc.nextLine();
						String textFromFile = "";
						Scanner scanner = new Scanner (new FileInputStream(location));
						while (scanner.hasNextLine()) {
							textFromFile += scanner.nextLine();
						}
						TextAnalysis textAnalysis = new TextAnalysis(textFromFile);
						System.out.println("Full mode");
						System.out.println(textAnalysis.toString());
						TextAnalysis.displayFrequencies(TextAnalysis.getCharacterFrequency(), TextAnalysis.characterArray);
						TextAnalysis.barChartFrequencies(TextAnalysis.getCharacterFrequency(), TextAnalysis.characterArray);
					}
				
						else if (inputType > 2) {
							System.out.println("You must enter 1, 2 or 0 only");
					}
				
				} while (inputType > 2);
			}
			else if (programMode == 2) {
				TextAnalysis textAnalysis = new TextAnalysis(UnitTests.longString);
				System.out.println("Demo mode");
				System.out.println(textAnalysis.toString());
				TextAnalysis.displayFrequencies(TextAnalysis.getCharacterFrequency(), TextAnalysis.characterArray);
				TextAnalysis.barChartFrequencies(TextAnalysis.characterFrequency, TextAnalysis.characterArray);
	//			TextAnalysis.displayFrequencies(TextAnalysis.characterFrequency(UnitTests.shortString, TextAnalysis.characterArray), TextAnalysis.characterArray);
	//			TextAnalysis.barChartFrequencies(TextAnalysis.characterFrequency(UnitTests.shortString, TextAnalysis.characterArray), TextAnalysis.characterArray);	
	//			int[] characterFrequency = TextAnalysis.characterFrequency(UnitTests.shortString, TextAnalysis.characterArray);
	//			
	//			double[] array = TextAnalysis.relativeFrequency(characterFrequency, 49 );
	//			for (int i = 0; i < array.length; i++) {
	//				System.out.print(characterFrequency[i]);
	//				System.out.println("                " + array[i]);
	//				System.out.println(UnitTests.longString.length());
	//			}
			}
			else if (programMode == 0) {
				System.out.println("Thank you for using the LG Text Analysis Program\r\nGoodbye");
				System.exit(0);
			}
			else {
				System.out.println("You must select 1, 2 or 0");
			}		
		} while (programMode != 0);

	}

}
