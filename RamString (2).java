package cmsc256;

public class RamString implements WackyStringInterface {
	public static void main(String[] arg) {
		
	}
	
	private String string;
	//Constructor with arg
	public void RamString(String string) {
		setWackyString(string);
	}
	//Constructor without arg
	public void RamString() {
		this.string = "Rodney the Ram";
		if(this.string == null) {
			this.string = "Rodney the Ram";
		}
	}
	
	//Mutator methods, getter and setter
	//setter
	@Override
	public void setWackyString(String string) {
		//just setting, no return
		if(string == null) {
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		this.string = string;
		
	}

	@Override
	//Getter
	public String getWackyString() {
		//Return this.string
		return this.string;
	}

	@Override
	public String getFirstMiddleLast() {
		//create string to index, as well as create lengths
		//Change this method so that middle char is first index + last index divided by two
		//But isn't the first index the same for every case? it's zero.
		String inputString = this.string;
		int stringLength = inputString.length();
		int middleIndex = inputString.length() / 2;
		//Find characters first middle last
		char firstChar = inputString.charAt(0);
		char lastChar = inputString.charAt(
				stringLength - 1);
		char middleChar = inputString.charAt(
				middleIndex);
		//Initialize final string and add chars
		String finalString = "";
		finalString = "" + firstChar + middleChar
				+ lastChar;
		
		return inputString;
	}

	@Override
	public String getEveryThirdCharacter() {
		//Creat inputstring as well as return string
		String inputString = this.string;
		String finalString = "";
		//Loop to get every 3 characters 
		for(int i = 0; i < inputString.length(); i+= 3) {
			finalString += inputString.charAt(i);
		}
		return finalString;
	}

	@Override
	//Double check this method with different strings
	public int countEvenDigits() {
		String inputString = this.string;
		int numEvenDigits = 0;
		for(int i = 0; i < inputString.length(); i++) {
			if(inputString.charAt(i) % 2 == 0
					&& Character.isDigit(inputString.charAt(i))) {
				numEvenDigits++;
			}
		}
		return numEvenDigits;
	}

	@Override
	public boolean isValidEID() {
		String inputString = this.string;
		boolean isValid = true;
		//Checks first letter
		if(inputString.charAt(0) != 'V') {
			isValid = false;
		}
		//Check second and third letters
		if(inputString.charAt(1) != '0' || inputString.charAt(2) != '0') {
			isValid = false;
		}
		//Check fourth letters onward.
		for(int i = 3; i < inputString.length(); i++) {
			if(Character.isDigit((inputString.charAt(i)))) {}
			else {isValid = false;}
		}
		return isValid;
	}

	@Override
	public void convertDigitsToWordsInSubstring(int startPosition, int endPosition)
			throws MyIndexOutOfBoundsException, IllegalArgumentException {
		//Create a string to look through as well as a newString to convert
		String inputString = this.string;
		String newString = "";
		//For loop to perform the conversion
		for(int i = startPosition - 1; i < endPosition; i++) {
			if(inputString.charAt(i) == '0') {
				newString += "0";
			}
			if(inputString.charAt(i) == '1') {
				newString += "one";
			}
			if(inputString.charAt(i) == '2') {
				newString += "two";
			}
			if(inputString.charAt(i) == '3') {
				newString += "three";
			}
			if(inputString.charAt(i) == '4') {
				newString += "four";
			}
			if(inputString.charAt(i) == '5') {
				newString += "five";
			}
			if(inputString.charAt(i) == '6') {
				newString += "six";
			}
			if(inputString.charAt(i) == '7') {
				newString += "seven";
			}
			if(inputString.charAt(i) == '8') {
				newString += "eight";
			}
			if(inputString.charAt(i) == '9') {
				newString += "nine";
			}
		}
		//Update instance variable
		this.string = newString;
	}

}
