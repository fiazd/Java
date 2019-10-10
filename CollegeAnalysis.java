/****************************************************************************
* Project 5 College Analysis
****************************************************************************
*This project takes and input file for school data and outputs facts about the data.
*_____________________________________________________
* Daanish Fiaz
* March 25th, 2019
* CMSC 255 Section 002
****************************************************************************/
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CollegeAnalysis {	
	public static void printHeading() {
		System.out.println("Daanish Fiaz");
		System.out.println("Project 5 College Analysis");
		System.out.println("This project takes an input file for school data and outputs facts about the data");
		System.out.println("March 25th, 2019");
		System.out.println("CMSC 255 Section 002");
		System.out.println("");
	}
	
	
	public static String findHighest(String [] school, Double [] category) {
		//This loop is working, returns danville for school with highest white percentage
		double highestave = -1.0;
		String highestschool = "";
		for(int i = 0; i < school.length; i++) {
			if(category[i] > highestave) {
				highestave = category[i];
				highestschool = school[i];
			}
		}
		return highestschool;
	}
	public static double findAverage(Double [] category) {
		//Stopped here, don't know if this is working
		double average = 0.0;
		double sum = 0;
		double totalelements = category.length;
		for(int j = 0; j < category.length; j++) {
			sum = sum + category[j];
			average = sum / totalelements;
		}
		return average;
	}
	public static void displayData(String text, String highest, double average, PrintWriter out) {
		//Strings
		highest.trim();
		out.printf("The institution with the highest " + text + "population is: " + highest.trim() + " and the average " + text + "population is: " + (String.format("%.2f", average)) + ".");
	}
		
		

	public static void parseData(File inputFile, File outputFile, int numLines) throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
			 
		//Construct the scanner and printwriter for reading and writing
		//File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter(outputFile);
		in.useDelimiter("\t");
		
		//initialize and assign variables
		String univName = "";
		int totalUndergrads = 0;
		double percentWhite = 0.0;
		double percentBlack = 0.0;
		double percentHispanic = 0.0;
		double percentAsian = 0.0;
		double percentAmericanIndianAlaska = 0.0;
		double percentPacific = 0.0;
		double percentTwoOrMore = 0.0;
		double percentAlien = 0.0;
		double percentUnidentified = 0.0;
		
		//initialize 11 different arrays
	    String [] univNameA = new String [numLines];
	    int [] totalUndergradsA = new int [numLines];
		Double [] percentWhiteA = new Double [numLines];
	    Double[] percentBlackA = new Double [numLines];
	    Double [] percentHispanicA = new Double [numLines];
	    Double[] percentAsianA = new Double [numLines];
	    Double [] percentAmericanIndianAlaskaA = new Double [numLines];
	    Double [] percentPacificA = new Double [numLines];
	    Double [] percentTwoOrMoreA = new Double [numLines];
	    Double [] percentAlienA = new Double [numLines];
	    Double [] percentUnidentifiedA = new Double[numLines];
	    
		
		//This skips the first line
		in.nextLine();
		while(in.hasNext())
		{
			for(int k = 0; k < numLines; k++) {
			//This is working for all of the variables.
			 univName = in.next();
			 	univNameA[k] = univName;
			 totalUndergrads = in.nextInt();
			 	totalUndergradsA[k] = totalUndergrads;
			 	
			 percentWhite = in.nextDouble();
			 	percentWhiteA[k] = percentWhite;
			 percentBlack = in.nextDouble();
			 	percentBlackA[k] = percentBlack;
			 percentHispanic  = in.nextDouble();
			 	percentHispanicA[k] = percentHispanic;
			 percentAsian = in.nextDouble();
			 	percentAsianA[k] = percentAsian;
			 percentAmericanIndianAlaska = in.nextDouble();
			 	percentAmericanIndianAlaskaA[k] = percentAmericanIndianAlaska;
			 percentPacific = in.nextDouble();
			 	percentPacificA[k] = percentPacific;
			 percentTwoOrMore = in.nextDouble();
			 	percentTwoOrMoreA[k] = percentTwoOrMore;
			 percentAlien = in.nextDouble();
			 	percentAlienA[k] = percentAlien;
			 percentUnidentified = in.nextDouble();
			 	percentUnidentifiedA[k] = percentUnidentified;
			}
			 
			 //numLines++;
		}
		
		
		int length = univNameA.length;
		
		//for(int a = 0; a < length; a++) {
			//System.out.println(percentUnidentifiedA[a]);
		//}
		//find highest is working with array, this is all correct
		String HighestWhite = findHighest(univNameA, percentWhiteA);
		String HighestBlack = findHighest(univNameA, percentBlackA);
		String HighestHispanic = findHighest(univNameA, percentHispanicA);
		String HighestAsian = findHighest(univNameA, percentAsianA);
		String HighestAmericanIndianAlaska = findHighest(univNameA, percentAmericanIndianAlaskaA);
		String HighestPacific = findHighest(univNameA, percentPacificA);
		String HighestTwoOrMore = findHighest(univNameA, percentTwoOrMoreA);
		String HighestAlien = findHighest(univNameA, percentAlienA);
		String HighestUnidentified = findHighest(univNameA, percentAlienA);
		
		//find average, this is working correctly
		double WhiteAverage = findAverage(percentWhiteA);
		double BlackAverage = findAverage(percentBlackA);
		double HispanicAverage = findAverage(percentHispanicA);
		double AsianAverage = findAverage(percentAsianA);
		double AmericanIndianAlaskaAverage = findAverage(percentAmericanIndianAlaskaA);
		double PacificAverage = findAverage(percentPacificA);
		double TwoOrMoreAverage = findAverage(percentTwoOrMoreA);
		double AlienAverage = findAverage(percentAlienA);
		double UnidentifiedAverage = findAverage(percentUnidentifiedA);
		
		//text
		String White = "White ";
		String Black = "Black/African American ";
		String Hispanic = "Hispanic ";
		String Asian = "Asian "; 
		String AmericanIndianAlaska = "American Indian or Native Alaskan ";
		String Pacific = "Pacific Islander or other Pacific Islander ";
		String TwoOrMore = "Two or more classification ";
		String Alien = "Alien ";
		String Unidentified = "Unidentified ";
		
		//displayData
		displayData(White, HighestWhite, WhiteAverage, out);
		out.println("");
		displayData(Black, HighestBlack, BlackAverage, out);
		out.println("");
		displayData(Hispanic, HighestHispanic, HispanicAverage, out);
		out.println("");
		displayData(Asian, HighestAsian, AsianAverage, out);
		out.println("");
		displayData(AmericanIndianAlaska, HighestAmericanIndianAlaska, AmericanIndianAlaskaAverage, out);
		out.println("");
		displayData(Pacific, HighestPacific, PacificAverage, out);
		out.println("");
		displayData(TwoOrMore, HighestTwoOrMore, TwoOrMoreAverage, out);
		out.println("");
		displayData(Alien, HighestAlien, AlienAverage, out);
		out.println("");
		displayData(Unidentified, HighestUnidentified, UnidentifiedAverage, out);
		
		
		//Keep these here and do not move them.
		in.close();
		out.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		System.out.print("Input file: ");
		String inputFileName = console.next();
		System.out.print("Output file: ");
		String outputFileName = console.next();
			 
		//Construct the scanner and printwriter for reading and writing
		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		File outputFile = new File(outputFileName);
		PrintWriter out = new PrintWriter(outputFileName);
		
		in.useDelimiter("\t");
		int numLines = 151;
		
		printHeading();
		parseData(inputFile, outputFile, numLines);
		

	}

}
