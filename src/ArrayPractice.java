public class ArrayPractice {

	private static void printArray(int[] nums) {

		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	private static void swapFirstLast(int[] nums) {

		int x = nums[nums.length - 1];
		nums[nums.length - 1] = nums[0];
		nums[0] = x;
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();

	}

	private static void findAverage(int[] nums) {

		double x = 0;
		for (int num : nums) {
			x += num;
		}

		System.out.println(x / nums.length);

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

	private static boolean isPresent(String[] words) {
		boolean isThere = false;
		for (String word : words) {
			if (word.equals("go")) {
				isThere = true;
				break;
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
		System.out.println(isPresent(wordsTest));

	}

}
