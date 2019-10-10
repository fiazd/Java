package application;

import java.util.Scanner;
import java.util.Arrays;


public class finalprojectm3 {
   public static String vowelCountMethod(String inputLine) {
	   	inputLine.toLowerCase(); 
	   	int numLetters = inputLine.length();
		int numVowels = 0;
		String finalstring;
		//Initial loop to count up the number of vowels
		for ( int i=0; i<numLetters; i++){
		   if (inputLine.charAt(i) == 'a' ||inputLine.charAt(i) == 'e' || inputLine.charAt(i) == 'i' || inputLine.charAt(i) == 'o' || inputLine.charAt(i) == 'u'){
			   numVowels++;
		   }
		   else{
			   numVowels = numVowels;
		   }
		   
	   }
		
		finalstring = "";
		//Regex expression to match a-z in the alphabet
		//a through z, spaces are fine + sign is for the entire sentence not just one character
		boolean alphabet = inputLine.matches("[a-z ]+");
		
		//To check if it is part of the alphabet, will set numVowels to -1 so other statements don't hit
		if(alphabet == false) {
			finalstring = "Input has an invalid character. Please rerun.";
			numVowels = -1;
		}
		//if there is a vowel, print out the number of them
		if(numVowels >= 1) {
			finalstring = ("The number of vowels that you inputted is: " + numVowels);
		}
		
		//If there are no vowels.
		if(numVowels == 0) {
			finalstring = ("Input does not have any vowels. Please rerun.");
		}
	
	return finalstring;
   }
}