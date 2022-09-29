/*
 * Daanish Fiaz
 * CMSC 401 Assignment 2
 * BTNode Class
 */
import java.util.*;

//MyBinaryTree Class
public class MyBinaryTree{
	//BTNode Class
	static class BTNode {
		int key; //value at that node
		BTNode parent; //Parent Node
		BTNode left; //Left child
		BTNode right; //Right child
		int count; //Number of occurrences of that given key
		
		public BTNode(int newNum) {
			key = newNum;
			left = null;
			right = null;
		}
		
	}
		//Root of Btree
		BTNode root;
		private static int inputArr[]; //Global variable specifically utilized for deletion
		
		//Driver code
		public static void main(String[] args) {
			MyBinaryTree tree = new MyBinaryTree();
			inputArr = new int[args.length];
			
			//Convert string array to int array
			for(int i = 0; i < args.length;i++) {			
				inputArr[i] = (Integer.parseInt(args[i]));
			}
			quickSort(inputArr, 0, inputArr.length - 1); //Sort array
			//Now we need to remove duplicates
			int len = inputArr.length;
			len = removeDuplicates(inputArr, len);
			
			//make new array then assign elements up until that point
			int [] inputArr2 = new int [len];
			for(int i = 0; i < len; i++) {
				inputArr2[i] = inputArr[i];
			}
			inputArr = inputArr2;
			
			tree.root = sortedArrayToBTree(inputArr, 0, inputArr.length - 1);
			

			System.out.println(tree.inOrder());

			
			/* 
			 * 1 3 6 9 2 8 5
			 * 1 2 3 5 6 8 9 inorder
			 * 5 2 1 3 8 6 9 preorder
			 * 1 3 2 6 9 8 5 postorder
			 */
			
		}
		
		//Default Constructor
		public MyBinaryTree() {
			this.root = null;
		}
		
		//add new integer number into the binsary searach tree
		void add(int newNum) {
			if(this.contains(newNum)) {
				//Find that node and just increase the count for that node
				BTNode node = search(this.root, newNum);
				node.count++;
			}
			else {
				//Update BTree as well as inputArr
				this.root = addRecursive(root, newNum);
			
				int inputArr2 [] = new int[inputArr.length + 1];
				for(int i = 0; i < inputArr.length; i++) {
					inputArr2[i] = inputArr[i];
					}
				inputArr2[inputArr2.length - 1] = newNum; //add newNum to the end
				quickSort(inputArr2, 0, inputArr2.length - 1);
				inputArr = inputArr2;
			}
		}
		//Search helper method that will find a node given a number and the root of the tree
		BTNode search(BTNode node, int num) {
			if(node != null) {
				if(node.key == num) { //If that node contains the num just return that node
					return node;
				}
				//else keep search left and right childs
				else {
					BTNode foundNode = search(node.left, num);
					if(foundNode == null) {
						foundNode = search(node.right, num);
					}
					return foundNode;
				}				
				
			}
			else {return null;}
		}
		
		//helper recursive function for adding nums
		private BTNode addRecursive(BTNode node, int newNum) {
			//if node is null, just create a new node with newNum as the value
			if(node == null) {
				return new BTNode(newNum);
			}
			
			if(newNum < node.key) { //if it is less, assign left
				node.left = addRecursive(node.left, newNum);
			}
			else if(newNum > node.key) { //if it is greater than assign right
				node.right = addRecursive(node.right, newNum);
			}
			
			return node;
		}
		
		//delete the number if it exists, return true if succeeds or return false if num doesn't exist
		boolean delete(int delNum) {	
			ArrayList<Integer> arr = new ArrayList<>(); 
			for(int val : inputArr) {arr.add(val);} //add vals from inputArr to arr
			int delIndex = -1; //deletion index for delNum
			for(int i = 0; i < arr.size(); i++) {
				if(arr.get(i) == delNum) {
					delIndex = i;
				}
			}
			//create new array that will be one less than current
			int newInputArr [] = new int[arr.size() - 1]; 
			//if the number is in the btree, remove it and update inputArr, and return true
			if(this.contains(delNum)) {
				arr.remove(delIndex);
				for(int i = 0; i < arr.size(); i++) {
					newInputArr[i] = arr.get(i);
				}

				inputArr = newInputArr; //update inputArr
				this.root = sortedArrayToBTree(newInputArr, 0, newInputArr.length - 1);
				return true;
			}
			
			return false;
		}
		
		
		//check whether tree contains the number num or not return true if it contains it, return false if it does not
		boolean contains(int num) {
			return containsRecursive(this.root, num);
		}
		//Recursive helper function
		//Check if node has the num, if not, search the left or right child
		boolean containsRecursive(BTNode node, int num) {
			if(node == null) {return false;}
			if(num == node.key) {return true;}
			if(num > node.key) {return containsRecursive(node.right, num);} 
			else if(num < node.key) {return containsRecursive(node.left, num);}
			return false;
		}
		
		//return in order traversal (numbers serparated by spaces)
		String inOrder() {
			return inOrderRecursive(this.root);
		}
		//left root right
		String inOrderRecursive(BTNode node) {
			String s = "";
			if(node != null) {//base case check
				s += inOrderRecursive(node.left) + " ";
				s += (node.key + " ");
				s += inOrderRecursive(node.right);
			}
			return s.trim();
		}
		
		//return preOrder traversal (numbers separated by spaces)
		//Root Left Right
		String preOrder() {
			return preOrderRecursive(this.root);
		}
		String preOrderRecursive(BTNode node) { 
			String s = "";
			if(node == null) {return "";}//base
			
			s += (node.key + " ");
			s += preOrderRecursive(node.left);
			s += preOrderRecursive(node.right);
			
			return s;
		}
		//return postOrder traversal(numbers separated by spaces)
		//left right root
		String postOrder() {
			return postOrderRecursive(this.root);
		}
		String postOrderRecursive(BTNode node) {
			String s = "";
			if(node == null) {return "";}//base
			
			s += postOrderRecursive(node.left);
			s += postOrderRecursive(node.right);
			s += node.key + " ";
			
			return s;
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
		//divide and conquer
		private static int partition(int[] arr, int low, int high) {
			int pivot = arr[high]; // set pivot as last element
			int i = low - 1; 
			//for loop to go over partition
			for(int j = low; j <= high - 1; j++) { 
				if(arr[j] < pivot) {
					i++;
					int temp = arr[i]; //do swap
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			//last swap to perform
			int temp = arr[i+1];
			arr[i + 1] = arr[high];
			arr[high] = temp;
			return i + 1;
		}
		//Given a sorted array, construct a balanced BTree
		public static BTNode sortedArrayToBTree(int arr[], int low, int high) {
			if(low > high) {return null;} //base case
			
			int middleElement = (low + high) / 2;
			
			BTNode node = new BTNode(arr[middleElement]);
			//Recursive calls for right and left subtrees
			node.left = sortedArrayToBTree(arr, low, middleElement - 1);
			node.right = sortedArrayToBTree(arr,middleElement + 1, high);
			
			return node;
		}
	
		//we pass in a sorted array, then check for repeated elements.
		//if there are multiple elements, adjust the array
		static int removeDuplicates(int arr[], int length) {
			if(length == 0 || length == 1) {return length;}
			
			int j = 0;
			//for loop to compare each element in the array and check for repetition
			for(int i = 0; i < length - 1; i++) {
				if(arr[i] != arr[i+1]) {
					arr[j++] = arr[i];
				}
			}
			arr[j++] = arr[length-1];
			return j; //return index of modified array, j is the last element to index to
		}
		
}


