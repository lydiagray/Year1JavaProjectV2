package TextAnalysis;

public class TextAnalysis {
	
	//Attributes
	private String input;
	private int charsIncludingSpaces;
	private int charsExcludingSpaces;
	private int numberOfWords;
	private int[] characterFrequency;
	private int[] relativeFrequency;
	public static final char[] characterArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '!', '?', ':', ';', '"','\'', '&', '(', ')', '-', '@', '\\', '/'};
	
	
	//Constructor
	public TextAnalysis(String input) {
		this.input = input.toUpperCase();
		this.charsIncludingSpaces = method();
		this.charsExcludingSpaces = method();
		this.numberOfWords = method();
		this.characterFrequency = characterFrequency(input, characterArray);
		this.relativeFrequency = relativeFrequency(characterFrequency, charsExcludingSpaces);
	}
	
	
	//Methods
	//Get methods
	public String getInput() {return input;}
	public int getCharsIncludingSpaces() {return charsIncludingSpaces;}
	public int getCharsExcludingSpaces() {return charsExcludingSpaces;}
	public int getNumberOfWords() {return numberOfWords;}
	public int[] getCharacterFrequency() {return characterFrequency;}
	public int[] getRelativeFrequency() {return relativeFrequency;}
	
	//Analysis methods
	
	
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
