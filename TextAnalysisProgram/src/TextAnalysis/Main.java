package TextAnalysis;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		int programMode = 0, inputType = 0;
		String input = "";
		

		System.out.println("Welcome to the LG Text Analysis Program\r\n\r\nPlease select the mode you would like to use?");
		System.out.println("1: Full mode\r\n2: Demo mode\r\nTo exit the program enter 0");
			
		do {
			Scanner sc = new Scanner(System.in);
			programMode = sc.nextInt();
			if (programMode == 1) {
				do {
				System.out.println("How would you like to enter your text?\n1: Keyboard\n2: Import a .txt file\nTo return to the main menu press 0");
				Scanner scan = new Scanner(System.in);
				inputType = scan.nextInt();
					if (inputType == 1) {
						System.out.println("Please enter the text you would like to analyse:");
						Scanner textScanner = new Scanner(System.in);
						input = textScanner.nextLine();
					}
					else if(inputType == 2) {
						System.out.println("Please enter the full location of the .txt file including the path e.g. C\\code\\text.txt:");
						Scanner locationScanner = new Scanner(System.in);
						String location = locationScanner.nextLine();
						try {
							input = HelperMethods.convertTextFile(location);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
						else if (inputType > 2) {
							System.out.println("You must enter 1, 2 or 0 only");
					}
				
				} while (inputType > 2);
				TextAnalysis textAnalysis = new TextAnalysis(input);
				System.out.println(textAnalysis.toString());
				textAnalysis.displayFrequencies(textAnalysis.getCharacterFrequency(), TextAnalysis.characterArray, textAnalysis.getRelativeFrequency());
				textAnalysis.barChartFrequencies(textAnalysis.getCharacterFrequency(), TextAnalysis.characterArray, textAnalysis.getHighestCount());
			}
			else if (programMode == 2) {
				TextAnalysis demo = new TextAnalysis(UnitTests.longString);
				System.out.println("Demo mode");
				System.out.println(demo.toString());
				demo.displayFrequencies(demo.getCharacterFrequency(), TextAnalysis.characterArray, demo.getRelativeFrequency());
				demo.barChartFrequencies(demo.characterFrequency, TextAnalysis.characterArray, demo.getHighestCount());
			}
			else if (programMode == 0) {
				System.out.println("Thank you for using the LG Text Analysis Program\r\nGoodbye");
				System.exit(0);
			}
			else {
				System.out.println("You must select 1, 2 or 0");
			}
			
			System.out.println("\r\n\r\nPlease select the mode you would like to use?");
			System.out.println("1: Full mode\r\n2: Demo mode\r\nTo exit the program enter 0");
		} while (programMode != 0);
		
	}

}
