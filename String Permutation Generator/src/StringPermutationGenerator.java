import java.util.*;

// one class needs to have a main() method
public class StringPermutationGenerator {

	// Original String given
	public static String baseString;

	// List with answer strings
	public static ArrayList<String> answerList = new ArrayList<String>();

	// arguments are passed using the text field below this editor
	public static void main(String[] args) {
		if (args[0] == null) {
			System.out.println("Empty string given.");
			return;
		}

		// Original String given
		baseString = args[0];

		// Ensure that baseString is added
		answerList.add(baseString);

		// Recursive method
		makeSubStrings(baseString);
		printAnswer();
	}

	/**
	 * Builds the Answer by making substrings of base and adds them to the
	 * answerList.
	 * 
	 * Note: We know that this String is at least length 2 based on the earlier base
	 * case check
	 **/
	public static void makeSubStrings(String base) {

		// Have we reached the end of the string?
		if (base.length() == 1) {
			// Check for duplicate strings in solution set
			if (!checkForDuplicates(base)) {
				// No duplicates found and end of string reached
				answerList.add(base);
			}
			return;
		}

		// Before we start pruning we should see if base can
		// be added to the answer list
		if (!checkForDuplicates(base)) {
			// No duplicates found
			answerList.add(base);

		}
		// Given String is still longer than 1 char
		// Start pruning off chars one by one
		for (int x = 0; x < base.length(); x++) {
			StringBuilder subString = new StringBuilder(base);
			subString.deleteCharAt(x);
			String subBase = subString.toString();
			// Check for duplicate strings in solution set
			if (!checkForDuplicates(subBase)) {
				answerList.add(subBase);
			}
			//Recursive call
			makeSubStrings(subBase);
		}
		return;
	}

	/**
	 * Checks to make sure no unneeded duplicate strings exist in the answer True -
	 * Duplicate found. False - No duplicate.
	 **/
	public static boolean checkForDuplicates(String test) {
		return answerList.contains(test);
	}

	/**
	 * Return the answer and print it out.
	 **/
	public static String printAnswer() {
		System.out.println(answerList.toString());
		return answerList.toString();
	}

}
