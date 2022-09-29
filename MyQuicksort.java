/*
 * Daanish Fiaz
 * CMSC 401
 * MyQuickSort implmentation
 */
import java.util.*;
public class MyQuicksort {
	private static int counter = 0; //Counter to keep track of comparisons
	//Double check to see if counter is correct
	public static void main(String[]args) { //Driver code
		//Create scanner to read in
		int [] inputArr = new int[args.length];
		for(int i = 0; i < args.length; i++) {
			inputArr[i] = Integer.parseInt(args[i]);
		}
		
		int low = 0; // assign low to first index
		int high = inputArr.length - 1; // assign high to last index
		quickSort(inputArr, low, high);
		
		//final print statements
		for(int val : inputArr) {
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println(counter);
		
	}
	
	//Recursive quicksort algorithm
	public static void quickSort(int [] arr, int low, int high) {
		
		
		if(low < high) { //if the low is less than the high
			//This will prevent indexoutofbounds exception
			int pIndex = partition(arr,low,high);
			
			quickSort(arr,low,pIndex-1); //first half
			quickSort(arr,pIndex+1,high); //second half
		}
	}
	//divide and conquer partition helper method
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; // set pivot as last element
		int i = low - 1;
		
		for(int j = low; j <= high - 1; j++) { 
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i]; //do swap
				arr[i] = arr[j];
				arr[j] = temp;
				counter++; //increment counter for each comparison with the pivot
			}
		}
		//last swap to perform
		int temp = arr[i+1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1; //return the partition index
	}
}
