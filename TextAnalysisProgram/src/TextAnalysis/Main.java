package TextAnalysis;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		int programMode = 0, inputType = 0, demo = 0;
		String input = "";
		

		System.out.println("Welcome to the LG Text Analysis Program\r\n\r\nPlease select the mode you would like to use?");
		System.out.println("1: Full mode\r\n2: Demo mode\r\n0: Exit the program");
			
		do {
			Scanner sc = new Scanner(System.in);
			programMode = sc.nextInt();
			if (programMode == 1) {
				do {
				System.out.println("How would you like to enter your text?\n1: Keyboard\n2: Import a .txt file\n0: Return to the main menu");
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
							System.out.println("Something went wrong, please try again");
						}
					}
				
					else if (inputType > 2) {
						System.out.println("You must enter 1, 2 or 0 only");
					}
				
				} while (inputType > 2);
		    	TextAnalysis textAnalysis = new TextAnalysis(input);
		    	HelperMethods.displayInterface(textAnalysis);
//		    	int display = 1;
//		    	do {
//			    	System.out.println("What analysis would you like to see?\n\n1: Show all analysis\n2: Show basic analysis\n3: Show character frequency table\n4: Show character frequency bar chart\n0: Return to the main menu\n");
//			    	display = sc.nextInt();
//			    	if (display == 1) {
//			    		HelperMethods.fullAnalysisDisplay(textAnalysis);
//			    	}
//			    	else if (display == 2) {
//			    		System.out.println(textAnalysis.toString());
//			    	}
//			    	else if (display == 3) {
//			    		textAnalysis.displayFrequencies(textAnalysis.getCharacterFrequency(), TextAnalysis.characterArray, textAnalysis.getRelativeFrequency());
//			    	}
//			    	else if (display == 4) {
//			    		textAnalysis.barChartFrequencies(textAnalysis.characterFrequency, TextAnalysis.characterArray, textAnalysis.getHighestCount());
//			    	}
//			    	else if (display > 4) {
//			    		System.out.println("You must enter 1, 2, 3, 4 or 0 only");
//			    	}
//		    	} while (display != 0);
		    		
			}
			else if (programMode == 2) {
				do {
					System.out.println("Would you like to see a demo of:\n1: A short piece of text\n2: A long piece of text\n0: Return to the main menu");
					demo = sc.nextInt();
					System.out.println("Demo mode");
					if (demo == 1) {
				    	TextAnalysis textAnalysis = new TextAnalysis(UnitTests.shortString);
						HelperMethods.displayInterface(textAnalysis);
					}
					else if (demo == 2) {
				    	TextAnalysis textAnalysis = new TextAnalysis(UnitTests.longString);
				    	HelperMethods.displayInterface(textAnalysis);
					}
					else {
						System.out.println("You must select 1, 2 or 0");
					}
				} while (demo != 1 && demo != 2);
			}
			else if (programMode == 0) {
				System.out.println("Thank you for using the LG Text Analysis Program\r\nGoodbye");
				System.exit(0);
			}
			else {
				System.out.println("You must select 1, 2 or 0");
			}
			
			System.out.println("\r\n\r\nPlease select the mode you would like to use?");
			System.out.println("1: Full mode\r\n2: Demo mode\r\n0: Exit the program");
		} while (programMode != 0);
		
	}

}
