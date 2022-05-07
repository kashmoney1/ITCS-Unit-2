public class ForEachPractice {

    public static void main(String[] args) {
        //prints every element of the array to the console
        int[] nums = {2, 4, 6, 8, 10};
        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();

        //calculates the sum of the array - nums
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        System.out.println(sum);

        //counts the number of elements above 10
        int[][] grid = {{3, 2, 34, 9},
                        {5, 15, 7, 18},
                        {8, 10, 11, 12}};
        int count = 0;
        for (int[] row : grid) {
            for (int x : row) {
                if (x > 10) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

}
