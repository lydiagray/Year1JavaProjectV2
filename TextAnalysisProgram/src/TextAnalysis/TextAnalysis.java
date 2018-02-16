package TextAnalysis;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class TextAnalysis {
	
	//Attributes
	public String input;
	public char[] inputAsArray;
	public String inputForDisplay;
	public int numberOfSpaces;
	public int charsIncludingSpaces;
	public int charsExcludingSpaces;
	public int numberOfWords;
	public int[] characterFrequency;
	public int highestCount;
	public int numberOfRecognisedCharacters;
	public int numberOfUnrecognisedCharacters;
	public String[] relativeFrequency;
	public static final char[] characterArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '!', '?', ':', ';', '"','\'', '&', '(', ')', '-', '@', '\\', '/'};
	
	
	//Constructor
	public TextAnalysis(String userInput) {
		this.input = userInput.toUpperCase();
		this.inputAsArray = input.toCharArray();
		this.inputForDisplay = inputForDisplay(inputAsArray);
		this.numberOfSpaces = numberOfSpaces(inputAsArray);
		this.charsIncludingSpaces = inputAsArray.length;
		this.charsExcludingSpaces = charsIncludingSpaces - numberOfSpaces;
		this.numberOfWords = numberOfSpaces + 1;
		this.characterFrequency = characterFrequency(inputAsArray, characterArray);
		this.highestCount = highestCount(characterFrequency);
		this.numberOfRecognisedCharacters = numberOfRecognisedCharacters(characterFrequency);
		this.numberOfUnrecognisedCharacters = numberOfUnrecognisedCharacters(numberOfRecognisedCharacters, charsExcludingSpaces);
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
	public int getNumberOfRecognisedCharacters() {return numberOfRecognisedCharacters;}
	public int getNumberOfUnrecognisedCharacters() {return numberOfUnrecognisedCharacters;}
	public String[] getRelativeFrequency() {return relativeFrequency;}
	
	//Analysis methods
	
	public int numberOfSpaces(char[] inputAsArray) {
		int count = 0;
		for (int i = 0; i < inputAsArray.length; i++) {
			if (inputAsArray[i] == ' ') {
				count++;
			}
		}
		return count;
	}
	
	public int countCharacters(char[] inputAsArray, char character) {
		int count = 0;		
		for (int i = 0; i < inputAsArray.length; i++) {
			if (character == inputAsArray[i]) {
				count++;
			}
		}		
		return count;
	}
	
	public int[] characterFrequency(char[] strArray, char[] characterArray) {
		int[] frequencyValues = new int[51];	
		for (int i = 0; i < characterArray.length; i++) {
			frequencyValues[i] = countCharacters(strArray, characterArray[i]); 
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
	
	public int numberOfRecognisedCharacters(int[] characterFrequency) {
		int count = 0;
		for (int i = 0; i < characterFrequency.length; i++) {
			count += characterFrequency[i];
		}
		return count;
	}
	
	public int numberOfUnrecognisedCharacters(int numberOfRecognisedCharacters, int charsExcludingSpaces) {
		int count = charsExcludingSpaces - numberOfRecognisedCharacters;
		return count;
	}
	
	public String[] relativeFrequency(int[] characterFrequency, int length) {
		double[] relativeFrequency = new double[51];
		double[] characterFrequencyDouble = new double[51];
		String[] formattedRelativeFrequency = new String[51];
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
	
	public String inputForDisplay(char[] inputAsArray) {
		String string = "";
		int count = 0;
		for (int i = 0; i < inputAsArray.length; i++) {
			string += inputAsArray[i];
			if (inputAsArray[i] == ' ') {
				count++;
			}
			if (inputAsArray[i] == ' ' && count%20 == 0) {
				string += "\n";
			}
		}
		return string;
	}
	
	public String toString() {
		return "\nThe text you are analysing is :\n\n" + inputForDisplay + "\n\nIt contains " 
				+ numberOfWords + " words and " + numberOfSpaces + " spaces.\nIncluding spaces it is " 
				+ charsIncludingSpaces + " characters long, and without spaces it is " + charsExcludingSpaces 
				+ " characters long.\n" + numberOfRecognisedCharacters + " characters were recognised and have been analysed, and " 
				+ numberOfUnrecognisedCharacters + " characters were unrecognised by the program.\n";
	}
	
	public void displayFrequencies(int[] characterFrequency, char[] characterArray, String[] relativeFrequency) {
		//Part 1
		
		System.out.print("+---------+");
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print("-----+");
			}
			else {
				System.out.print("-----+");
			}
		}
		System.out.println("");
		
		System.out.print("|Character|");
		for (int i = 0; i < 26; i++) {
			System.out.format("%-5s|", characterArray[i]);
		}
		System.out.println("");
		
		System.out.print("|         |");
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print("     |");
			}
			else {
				System.out.println("     |");
			}
		}
		System.out.println("");
		
		System.out.print("+---------+");
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print("-----+");
			}
			else {
				System.out.println("-----+");
			}
		}
		System.out.println("");
		
		System.out.print("|Character|");
		for (int i = 0; i < 26; i++) {
			System.out.format("%-5s|", characterFrequency[i]);
		}
		System.out.println("");
		
		System.out.print("|Frequency|");
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print("     |");
			}
			else {
				System.out.println("     |");
			}
		}
		System.out.println("");
		
		System.out.print("+---------+");
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print("-----+");
			}
			else {
				System.out.println("-----+");
			}
		}
		System.out.println("");
		
		System.out.print("|Relative |");
		for (int i = 0; i < 26; i++) {
			System.out.format("%-5s|", relativeFrequency[i]);
		}
		System.out.println("");
		
		System.out.print("|Frequency|");
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print("     |");
			}
			else {
				System.out.println("     |");
			}
		}
		System.out.println("");
		
		System.out.print("+---------+");
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print("-----+");
			}
			else {
				System.out.println("-----+");
			}
		}
		System.out.println("");
		
		//Part 2
		
		System.out.print("+---------+");
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print("-----+");
			}
			else {
				System.out.println("-----+");
			}
		}
		System.out.println("");
		
		System.out.print("|Character|");
		for (int i = 26; i < 51; i++) {
			System.out.format("%-5s|", characterArray[i]);
		}
		System.out.println("");
		
		System.out.print("|         |");
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print("     |");
			}
			else {
				System.out.println("     |");
			}
		}
		System.out.println("");
		
		System.out.print("+---------+");
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print("-----+");
			}
			else {
				System.out.println("-----+");
			}
		}
		System.out.println("");
		
		System.out.print("|Character|");
		for (int i = 26; i < 51; i++) {
			System.out.format("%-5s|", characterFrequency[i]);
		}
		System.out.println("");
		
		System.out.print("|Frequency|");
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print("     |");
			}
			else {
				System.out.println("     |");
			}
		}
		System.out.println("");
		
		System.out.print("+---------+");
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print("-----+");
			}
			else {
				System.out.println("-----+");
			}
		}
		System.out.println("");
		
		System.out.print("|Relative |");
		for (int i = 26; i < 51; i++) {
			System.out.format("%-5s|", relativeFrequency[i]);
		}
		System.out.println("");
		
		System.out.print("|Frequency|");
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print("     |");
			}
			else {
				System.out.println("     |");
			}
		}
		System.out.println("");
		
		System.out.print("+---------+");
		for (int i = 26; i < 51; i++) {
			if (i != 51) {
				System.out.print("-----+");
			}
			else {
				System.out.println("-----+");
			}
		}
		System.out.println("");
	}
	
	public void barChartFrequencies(int[] characterFrequency, char[] characterArray, int count) {
	
		System.out.println("\n Number of character occurances");

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
		System.out.println("\n");


	}
	

}
