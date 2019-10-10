/****************************************************************************
* Project 6 Weekly Payroll
****************************************************************************
*This project takes in a file with hours that an employee has worked in a week 
*and outputs several things included amount that employee got paid for that week.
*_____________________________________________________
* Daanish Fiaz
* April 4th, 2019
* CMSC 255 Section 002
****************************************************************************/
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class WeeklyPayroll {
	public static void printHeading() {
		System.out.println("Daanish Fiaz");
		System.out.println("Project 6 Weekly Payroll");
		System.out.println("This project tells how much an employee got paid for a week based upon an input file that contains their hours worked.");
		System.out.println("April 4th, 2019");
		System.out.println("CMSC 255 Section 002");
	}
	public static void displayData(String[] employee, double[] grossPay, int[] dayTally, PrintWriter out) {
		int lengthrow = 7;
		int lengthcol = employee.length;
		String [] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" , "Saturday", "Sunday"};
		
		for(int m = 0; m < lengthcol; m++) {
			//Adjust print statement to line up and have two zeros after decimal
			out.println (employee[m] + "    \t" + String.format("%.2f",grossPay[m]));
		}
		out.println("");
		for(int n = 0; n < lengthrow; n++) {
			out.println(weekdays[n] + "     \t"+ dayTally[n]);
		}
	}
	
	public static int[] calcDayTally(int [][] hoursWorked) {
		int rows = hoursWorked.length;
		
		//initialize array with 7 element spaces
		int[] dayTally = new int [7];
		int total = 0;
		//The x and y need to be flipped so that we go down instead of over.
		for(int x = 0; x < 7; x++) {
			//temp value to hold the total, then once we put it in the array, reset for each day of the week.
			total = 0;
			for(int y = 0; y < rows; y++) {
				total += hoursWorked[y][x];
				dayTally[x] = total;
			}
			//Total is working correctly, now we have to store it in an array.
			//System.out.println(total);
		}
		//This is working correctly, now to return the array.
		//System.out.print(Arrays.toString(dayTally));
		
		return dayTally;
	}
	
	
	public static double [] calcGrossPay(int [][] hoursWorked) {
		double hourlyWage = 9.50;
		int rows = hoursWorked.length;
		double [] grossPay = new double [rows];
		int hoursEmployeePerWeek = 0;
		//System.out.println(Arrays.deepToString(hoursWorked));
		
		for(int a = 0; a < rows; a++) {
			//This will reset it for each row
			hoursEmployeePerWeek = 0;
			for(int b = 0; b < 7; b ++) {
				//Store that value for each employee here
				grossPay[a] += hoursWorked[a][b];
			}
		}
		for(int z = 0; z < rows; z++) {
			grossPay[z] *= 9.50;
		}
		//this is working, yippee array checked, sums are correct.
		return grossPay;
	}
	
	public static void parseData(File input, File output, int numRows) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		 
		//Construct the scanner and printwriter for reading and writing
		Scanner in = new Scanner(input);
		PrintWriter out = new PrintWriter(output);
		
		
		//Initialize everything
		String [] nameA = new String [numRows];
		double [] grossPay = new double [numRows];
		int [] dayTally = new int [numRows];
		String fullname, firstname, lastname;
		int mon, tues, wed, thurs, fri, sat, sun;
		int [][] hoursWorked = new int [numRows][7];
		
		//While loop to get everything.
		while(in.hasNext()) {
			for(int i = 0; i < numRows; i++) {
				firstname = in.next();
					
				lastname = in.next();
				//Making the name array, this is working to put all of the names in an array.
				nameA[i] = firstname + " " + lastname;
				//Make 2D array with amount of hours worked.
				try{for(int j = 0; j < 7; j++) {
					hoursWorked[i][j] = in.nextInt();
				}}catch(NoSuchElementException e) {}
				
			}
		}
		//Pass everything below to displayData
		
		//Now we call gross pay to find pay
		grossPay = calcGrossPay(hoursWorked);
		dayTally = calcDayTally(hoursWorked);
		displayData(nameA, grossPay, dayTally, out);
		
		in.close();
		out.close();
		}
		
	
	
	public static void main(String[] args) throws FileNotFoundException {
		printHeading();
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
		
		in.useDelimiter(" ");
		int numLines = 12;
		
		parseData(inputFile, outputFile, numLines);
	}
	

}
