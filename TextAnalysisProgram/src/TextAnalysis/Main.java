package TextAnalysis;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int programMode;	
		
		do {
		System.out.println("Welcome to the LG Text Analysis Program\r\n\r\nPlease select the mode you would like to use?");
		System.out.println("1: Full mode\r\n2: Demo mode\r\nTo exit the program enter 0");
		programMode = sc.nextInt();
		
		if (programMode == 1) {
			System.out.println("This feature has not been released yet\r\nPlease try again later\r\n");
		}
		else if (programMode == 2) { 
			System.out.println("Demo display of frequencies for the following text:" + UnitTests.longString);	
//			TextAnalysis.displayFrequencies(TextAnalysis.characterFrequency(UnitTests.longString, TextAnalysis.characterArray), TextAnalysis.characterArray);
//			TextAnalysis.barChartFrequencies(TextAnalysis.characterFrequency(UnitTests.longString, TextAnalysis.characterArray), TextAnalysis.characterArray);
			TextAnalysis.displayFrequencies(TextAnalysis.characterFrequency(UnitTests.shortString, TextAnalysis.characterArray), TextAnalysis.characterArray);
			TextAnalysis.barChartFrequencies(TextAnalysis.characterFrequency(UnitTests.shortString, TextAnalysis.characterArray), TextAnalysis.characterArray);		
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
