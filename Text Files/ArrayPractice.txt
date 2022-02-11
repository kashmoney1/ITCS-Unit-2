//ITCS - Array Practice

public class ArrayPractice {

	private static void printArray(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	private static void swapFirstLast(int[] nums) {

		int x = nums[nums.length - 1];
		nums[nums.length - 1] = nums[0];
		nums[0] = x;
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

	}

	private static double findAverage(int[] nums) {

		double x = 0;
		for (int i = 0; i < nums.length; i++) {
			x += nums[i];
		}

		System.out.println(x / nums.length);

		return x / nums.length;
	}

	private static int findSmallest(int[] nums) {

		int x = nums[0];
		int y = 0;
		for (int i = 0; i < nums.length; i++) {
			if (x > nums[i]) {
				x = nums[i];
				y = i;
			}
		}
		return y;
	}

	private static boolean isPresent(String[] words, String target) {
		boolean isThere = false;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				isThere = true;
			}
		}
		return isThere;
	}

	public static void main(String[] args) {
		// Generates a test array of variable size and values.
		int[] testArray = new int[(int) (Math.random() * 7 + 3)];
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = (int) (Math.random() * 25);
		}
		// sample array of words
		String[] wordsTest = { "The", "wheels", "go", "round", "and", "round" };


		printArray(testArray);
		swapFirstLast(testArray);
		findAverage(testArray);
		System.out.println(findSmallest(testArray));
		System.out.println(isPresent(wordsTest, "go"));

	}

	/*
	 * Optional Extra Challenge. Complete if you finish early.
	 * Given an array, nums, return true if the elements of the array are in
	 * ascending order.
	 * return false otherwise.
	 * Ex.
	 * {1, 5, 9, 9, 10, 50} -> In order
	 * {9, 3, 5, 10, 50, 25} -> Not In Order
	 * 
	 * Note: you may need to create your own array in main to test this
	 * as the given array will very rarely be in order.
	 */
	public static boolean isInOrder(int[] nums) {

		return false; // placeholder
	}

}
