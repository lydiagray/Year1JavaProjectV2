package TextAnalysis;

public class TextAnalysis {
	
	//Attributes
	public static String input;
	public static char[] inputAsArray;
	public static int numberOfSpaces;
	public static int charsIncludingSpaces;
	public static int charsExcludingSpaces;
	public static int numberOfWords;
	public static int[] characterFrequency;
	public static double[] relativeFrequency;
	public static final char[] characterArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '!', '?', ':', ';', '"','\'', '&', '(', ')', '-', '@', '\\', '/'};
	
	
	//Constructor
	public TextAnalysis(String userInput) {
		TextAnalysis.input = userInput.toUpperCase();
		TextAnalysis.inputAsArray = input.toCharArray();
		TextAnalysis.numberOfSpaces = numberOfSpaces(input);
		TextAnalysis.charsIncludingSpaces = inputAsArray.length;
		TextAnalysis.charsExcludingSpaces = charsIncludingSpaces - numberOfSpaces;
		TextAnalysis.numberOfWords = numberOfSpaces + 1;
		TextAnalysis.characterFrequency = characterFrequency(input, characterArray);
		TextAnalysis.relativeFrequency = relativeFrequency(characterFrequency, charsExcludingSpaces);
	}
	
	
	//Methods
	//Get methods
	public static String getInput() {return input;}
	public static int getNumberOfSpaces() {return numberOfSpaces;}
	public static int getCharsIncludingSpaces() {return charsIncludingSpaces;}
	public static int getCharsExcludingSpaces() {return charsExcludingSpaces;}
	public static int getNumberOfWords() {return numberOfWords;}
	public static int[] getCharacterFrequency() {return characterFrequency;}
	public static double[] getRelativeFrequency() {return relativeFrequency;}
	
	//Analysis methods
	
	public static int numberOfSpaces(String input) {
		int count = 0;
		for (char c : input.toCharArray()) {
			if (c == ' ') {
				count++;
			}
		}
		return count;
	}
	
	public static int countCharacters(String input, char character) {
		char[] charArray = input.toCharArray();
		int count = 0;
		
		for (int i = 0; i < charArray.length; i++) {
			if (character == charArray[i]) {
				count++;
			}
		}		
		return count;
	}
	
	public static int[] characterFrequency(String str, char[] characterArray) {
		int[] frequencyValues = new int[50];
	
		for (int i = 0; i < characterArray.length; i++) {
			frequencyValues[i] = countCharacters(str, characterArray[i]); 
		}		
		return frequencyValues;
	}
	
	public static double[] relativeFrequency(int[] characterFrequency, int length) {
		double[] relativeFrequency = new double[50];
		double[] characterFrequencyFloat = new double[50];
		for (int i = 0; i < characterFrequency.length; i++) {
			characterFrequencyFloat[i] = characterFrequency[i];
		}
		for (int i = 0; i < characterFrequency.length; i++) {
			relativeFrequency[i] = (characterFrequencyFloat[i] / length);
		}
		return relativeFrequency;
	}
	
	//Display methods
	public static void displayFrequencies(int[] characterFrequency, char[] characterArray) {
		System.out.format("+---------+---------+\r\n");
		System.out.format("|Character|Frequency|\r\n");
		System.out.format("+---------+---------+\r\n");
		for (int i = 0; i < characterFrequency.length; i++) {
			System.out.format("| %-7s | %-7d |\r\n", characterArray[i], characterFrequency[i]);
		}
		System.out.format("+---------+---------+\r\n");
	}
	
	public static void barChartFrequencies(int[] characterFrequency, char[] characterArray) {
		System.out.println(" Number of character occurances");
		System.out.println(" _______________________________________________________");
		for (int i = 0; i < characterFrequency.length; i++) {
			String bar = "";
			System.out.print(characterArray[i] + "|");
			for (int j = 1; j <= characterFrequency[i]; j++) {
				bar += "X";
			}
			System.out.println(bar);

		}


	}
	

}
