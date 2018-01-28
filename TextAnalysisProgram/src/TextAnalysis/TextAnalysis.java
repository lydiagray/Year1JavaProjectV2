package TextAnalysis;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class TextAnalysis {
	
	//Attributes
	public String input;
	public char[] inputAsArray;
	public int numberOfSpaces;
	public int charsIncludingSpaces;
	public int charsExcludingSpaces;
	public int numberOfWords;
	public int[] characterFrequency;
	public int highestCount;
	public String[] relativeFrequency;
	public static final char[] characterArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '!', '?', ':', ';', '"','\'', '&', '(', ')', '-', '@', '\\', '/'};
	
	
	//Constructor
	public TextAnalysis(String userInput) {
		this.input = userInput.toUpperCase();
		this.inputAsArray = input.toCharArray();
		this.numberOfSpaces = numberOfSpaces(input);
		this.charsIncludingSpaces = inputAsArray.length;
		this.charsExcludingSpaces = charsIncludingSpaces - numberOfSpaces;
		this.numberOfWords = numberOfSpaces + 1;
		this.characterFrequency = characterFrequency(input, characterArray);
		this.highestCount = highestCount(characterFrequency);
		this.relativeFrequency = relativeFrequency(characterFrequency, charsExcludingSpaces);
	}
	
	
	//Methods
	//Get methods
	public String getInput() {return input;}
	public int getNumberOfSpaces() {return numberOfSpaces;}
	public int getCharsIncludingSpaces() {return charsIncludingSpaces;}
	public int getCharsExcludingSpaces() {return charsExcludingSpaces;}
	public int getNumberOfWords() {return numberOfWords;}
	public int[] getCharacterFrequency() {return characterFrequency;}
	public int getHighestCount() {return highestCount;}
	public String[] getRelativeFrequency() {return relativeFrequency;}
	
	//Analysis methods
	
	public int numberOfSpaces(String input) {
		int count = 0;
		for (char c : input.toCharArray()) {
			if (c == ' ') {
				count++;
			}
		}
		return count;
	}
	
	public int countCharacters(String input, char character) {
		char[] charArray = input.toCharArray();
		int count = 0;
		
		for (int i = 0; i < charArray.length; i++) {
			if (character == charArray[i]) {
				count++;
			}
		}		
		return count;
	}
	
	public int[] characterFrequency(String str, char[] characterArray) {
		int[] frequencyValues = new int[50];
	
		for (int i = 0; i < characterArray.length; i++) {
			frequencyValues[i] = countCharacters(str, characterArray[i]); 
		}		
		return frequencyValues;
	}
	
	public int highestCount(int[] characterFrequency) {
		int count = 0;
		for (int i = 0; i < characterFrequency.length; i++) {
			if (characterFrequency[i] > count) {
				count = characterFrequency[i];
			}
		}
		return count;
	}
	
	public String[] relativeFrequency(int[] characterFrequency, int length) {
		double[] relativeFrequency = new double[50];
		double[] characterFrequencyDouble = new double[50];
		String[] formattedRelativeFrequency = new String[50];
		for (int i = 0; i < characterFrequency.length; i++) {
			characterFrequencyDouble[i] = characterFrequency[i];
		}
		for (int i = 0; i < characterFrequency.length; i++) {
			relativeFrequency[i] = (characterFrequencyDouble[i] / length);
		}
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		for (int i = 0; i < relativeFrequency.length; i++) {
		    formattedRelativeFrequency[i] = df.format(relativeFrequency[i]);
		}
		
		return formattedRelativeFrequency;
	}
	
	//Display methods
	
	public String toString() {
		return "The text you are analysing is :" + input + "\nIt contains " + numberOfWords + " words and " + numberOfSpaces + " spaces.\nIncluding spaces it is " + charsIncludingSpaces + " characters long, and without spaces it is " + charsExcludingSpaces + " characters long.";
	}
	public void displayFrequencies(int[] characterFrequency, char[] characterArray, String[] relativeFrequency) {
		System.out.format("+---------+---------+---------+\r\n");
		System.out.format("|Character|Character|Relative |\r\n");
		System.out.format("|         |Frequency|Frequency|\r\n");
		System.out.format("+---------+---------+---------+\r\n");
		for (int i = 0; i < characterFrequency.length; i++) {
			System.out.format("| %-7s | %-7s | %-7s |\r\n", characterArray[i], characterFrequency[i], relativeFrequency[i]);
		}
		System.out.format("+---------+---------+---------+\r\n");
	}
	
	public void barChartFrequencies(int[] characterFrequency, char[] characterArray, int count) {
	
		System.out.println(" Number of character occurances");

		for (int i = count; i > 0; i--) {
			if (i < 10) {
				System.out.print(i + "  |");
			}
			else if (i > 9 && i < 100) {
				System.out.print(i + " |");
			}
			else {
				System.out.print(i + "|");
			}
			for (int j = 0; j < characterFrequency.length; j++) {
				if (characterFrequency[j] != 0 && characterFrequency[j] >= i) {
					System.out.print("X ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println("");
		}
		System.out.println("========================================================================================================");
		System.out.print("   |");
		for (int i = 0; i < characterArray.length; i++) {
			System.out.print(characterArray[i] + " ");
		}
		System.out.println("");


	}
	

}
