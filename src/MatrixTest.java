public class MatrixTest {
    public static void main(String[] args) {
        Integer [][] ints = new Integer[5][8];

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = ((int)(Math.random()*20) + 1);
            }
        }

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] % 2 == 0) {
                    ints[i][j] *= 2;
                }
            }
        }

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println();
    }
}
