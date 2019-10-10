package cmsc256;  // do not remove or comment out this statement

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.io.*;

/**
 *  CMSC 256 Fall 2019
 *  Project 1
 *  Fiaz, Daanish
 *  The purpose of this program is to find the tallest height, lowest weight row, and 
 *  average height of the range given and return all of those.
 */

// place any import statements here
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
       	//REVIEW EVERYTHING AND CLEAN UP CODE
    	
    	//Create a project1 object
    	//We have inputed the file and then we read the file
    	Project1 projectObj = new Project1();
    	
    	
    	String nameofFile = projectObj.checkArgs(args);
    	File datafile = null;
    	
    	//Try catch for getFile
    	try {
			datafile = projectObj.getFile(nameofFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	//We take this fileName and then pull a string array out of it.
    	int numRecords = 500;
    	int lBounds = 20;
    	int uBounds = 30;
    	
    	
    	//Try catch for read file
    	String [][] data = null;
		try {
			data = projectObj.readFile(datafile, numRecords);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//Now we have this array data that contains all the info we need
    	
    	// Display appropriately labeled information for the following:
        // What is tallest height? Tallest height is 199
		int tallestHeight = projectObj.findTallest(data);
		
        // Which row has the lowest weight?
		//90 is the lowest weight
		String [] lowestWeight = projectObj.findLightestRecord(data);
		
        // Calculate average height of 20-30 year age range in the data.
		//Average height for people between 20 and 30 is 169.30
		double averageHeight = projectObj.findAvgHeightByAgeRange(data, lBounds, uBounds);
		
		//Display everything
		System.out.println("The tallest height is " + tallestHeight);
		System.out.println("The row with the lowest weight is " + "[" + lowestWeight[0] + 
				", " + lowestWeight[1] + ", " + lowestWeight[2] + "]");
		
		DecimalFormat F = new DecimalFormat("#.#");
		
		System.out.println("Average height for ages " + lBounds + "-" + uBounds +
				" is " + F.format(averageHeight));
		
    }

    /**
     *   Gets the file name from command line argument;
     *   If parameter is empty, call promptForFileName() method
     * @param argv  String array from command line argument
     * @return      the name of the data file
     */
    public String checkArgs(String[] argv) {
		//initialize filename and create new object to use when argv doesnt work
    	String fileName = null;
		Project1 projectObj = new Project1();
		
    	if(0 < argv.length) {
    		//Retrieves filename from command line
    		fileName = argv[0];
    	}
    	else {
    		//Prompts in console
    		fileName = projectObj.promptForFileName();
    	}
    	return fileName;
    }

    /**
     * Prompt user to enter a file name
     * @return user entered file name
     */
    public String promptForFileName() {
    	String fileName = null;
    	Scanner in = new Scanner(System.in);
    	System.out.print("Input file name: ");
    	
    	fileName = in.next();
    	
    	return fileName;
    }

    /**
     * Retrieve file with the given file name.
     * Prompts user if file cannot be opened or does not exist.
     * @param fileName  The name of the data file
     * @return          File object
     * @throws java.io.FileNotFoundException
     */
    public File getFile(String fileName) throws FileNotFoundException {
    	File finalFile = null;
    	finalFile = new File(fileName);
    	return finalFile;
    }

    /**
     * Reads the comma delimited file to extract the number data elements
     * provided in the second argument.
     * @param file          The File object
     * @param numRecords    The number of values to read from the input file
     * @return              2D array of data from the File
     * @throws IOException if any lines are missing data
     */
    public String[][] readFile(File file, int numRecords) throws IOException {
    	//Create Scanner, 2d array, skip first line, declare int variable and set to 0
    	Scanner in = new Scanner(file);
    	String [][] data = new String[numRecords][3];
    	in.nextLine();
    	int currentRow = 0;
    	
    	//While there are lines to read and current row < numrecords
    	while(in.hasNextLine() && currentRow < numRecords) {
    		//Read the next line and store in string variable
    		String line = in.nextLine();
    		//new scanner to go over the line
    		Scanner in2 = new Scanner(line);
    		in2.useDelimiter(",");
    		//Create a loop that will iterate 3 times
    		for(int i = 0; i < 3; i++) {
    			//If in2 has another item, store it in data
    			if(in2.hasNext()) {
    				data[currentRow][i] = in2.next();
    			}
    			
    			else {throw new IOException("IOException: Corrupt Data");}
    		}
    		currentRow++;
    	}
    	
    	
    	//Test Print
    	for(int j = 0; j < data.length; j++) {
    		for(int k = 0; k < 3; k++) {
    			//System.out.print(data[j][k] + " ");
    		}
    		//System.out.println();
    	}

    	
    	return data;
    }
    

    /**
     * Determines the tallest height in the data set
     * Height is the second field in each row
     * @param db        2D array of data containing [age] [height] [weight]
     * @return          Maximum height value
     */
    public int findTallest(String[][] db) {
    	int tallestHeight = 0;
    	//We need to convert everything in the passed in array to an integer array
    	// need to initiate a new array for age to the length of db
    	int [] heightArray = new int[db.length];
    	
    	String nullString = null;
    	for(int j = 0; j < db.length; j++) {
    		if(db[j][1] == null || db[j][1].equals("")) {
    			//Make it a low number because we are looking for the tallest
    			db[j][1] = "0";
    			heightArray[j] = 0;
    		}
    		else {
    			heightArray[j] = Integer.parseInt(db[j][1]);
    		}
    		
    	}
    	    	
    	//loop over the string [numRecords][3]
    	for(int i = 0; i < heightArray.length; i ++) {
    		if(heightArray[i] > tallestHeight) {
    			tallestHeight = heightArray[i];
    		}
    	}
    	//tested tallest height, it is correct.    	
    	return tallestHeight;
    }

    /**
     * Returns the values in the record that have the lowest weight
     * @param db        2D array of data containing [age] [height] [weight]
     * @return          Smallest weight value
     */
    public String[] findLightestRecord(String[][] db) {
    	//Find all three data points for the row with the lowest weight.
    	//we have to find the lowestweight, and then record that index.
    	//put that in a string array and then return it.
    	String [] lowestWeightArray = new String[3];
    	
    	int recordIndex = 0;
    	int lightestWeight = 99999;
    	
    	int [] weightArray = new int[db.length];
    	for(int j = 0;j < db.length; j++) {
 
    		if(db[j][2] == null) {
    			//If it's equal to null, make it a large number and skip it essentially
    			db[j][2] = "99999";
    			weightArray[j] = Integer.parseInt(db[j][2]);
    		}
    		else {
    			weightArray[j] = Integer.parseInt(db[j][2]);
    		}
    		
    	}
    	
    	for(int i = 0; i < weightArray.length; i++) {
    		if(weightArray[i] < lightestWeight) {
    			lightestWeight = weightArray[i];
    			recordIndex = i;
    		}
    	}
    	//Works Correctly, just tested.
    	//Now we are going to pull all those values utilizing that index we recorded.
    	String age = (db[recordIndex][0]);
    	String height = (db[recordIndex][1]);
    	String weight = (db[recordIndex][2]);
    	//
    	lowestWeightArray[0] = age;
    	lowestWeightArray[1] = height;
    	lowestWeightArray[2] = weight;
    	
    	//Tested this out, it is working and returning the full string array
    	return lowestWeightArray;
    }

    /**
     * Calculates the average height for all records with the given age range.
     * @param db            2D array of data containing [age] [height] [weight]
     * @param lowerBound    youngest age to include in the average
     * @param upperBound    oldest age to include in the average
     * @return              The average height for the given range or 0 if no
     *                      records match the filter criteria
     */
    public double findAvgHeightByAgeRange(String[][] db, int lowerBound, int upperBound) {
    	double aveHeight = 0.0;
    	
    	int [] ageArray = new int[db.length];
    	int [] heightArray = new int[db.length];
    	
    	for(int j = 0;j < db.length; j++) {
    		//Age
    		try{if(db[j][0].equals("") || db[j][0] == null) {
    			db[j][0] = "0";
    			ageArray[j] = 0;
    		}
    		else {
    			ageArray[j] = Integer.parseInt(db[j][0]);
    		}
    		}catch(NullPointerException e) {}
    		
    		
    		//Height
    		if(db[j][1].equals("")) {
    			heightArray[j] = 0;
    		}
    		else {
    			heightArray[j] = Integer.parseInt(db[j][1]);
    		}
    	}
    	
    	int [] heightArrayFinal = new int[db.length];

    	
    	//Find all people between 20 and 30
    	//if said person is between 20 and 30, add their height to heightArrayFinal
    	int count = 0;
    	for(int i = 0; i < db.length; i++) {
    		 if(ageArray[i] <= upperBound && ageArray[i] >= lowerBound){
    			 //count the number of people between this range and then
    			 heightArrayFinal[i] = heightArray[i];
    			 count++;
    			 //Use another loop to create the final arrays
    		 }
    	}
    	//Sum and length initialization and declaration
    	double sum = 0;
    	double length = heightArrayFinal.length;
    	
    	//Find the average of that height(utilize for loop)
    	for(int n = 0; n < heightArrayFinal.length; n++) {
    		sum += heightArrayFinal[n];
    	}
    	aveHeight = sum / count; 	
    	 	  		
    	return aveHeight;
    }
}
