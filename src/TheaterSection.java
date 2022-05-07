public class TheaterSection {

    private final boolean[][] section;

    public TheaterSection() {
        section = new boolean[5][20];
        int num;
        for (int r = 0; r < section.length; r++) {
            for (int c = 0; c < section[0].length; c++) {
                num = (int) (Math.random() * 4);
                section[r][c] = num == 0;
            }
        }
    }

    public TheaterSection(boolean[][] premadeSection) {
        section = new boolean[premadeSection.length][premadeSection[0].length];
        for (int i = 0; i < premadeSection.length; i++) {
            System.arraycopy(premadeSection[i], 0, section[i], 0, premadeSection[0].length);
        }
    }

    public void printSection() {
        char a = 'A';
        System.out.print("\t\t");
        for (int i = 1; i <= section[0].length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (boolean[] booleans : section) {
            System.out.print("Row " + a + "\t");
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    System.out.print("*\t");
                } else {
                    System.out.print("X\t");
                }
            }
            a++;
            System.out.println();
            System.out.println();
        }
    }

    public void printAvailable() {
        char a = 'A';
        int count = 0;

        System.out.print("\t\t");

        System.out.println();
        for (boolean[] booleans : section) {
            boolean flag = true;
            System.out.print("Row " + a + "\t");
            for (int col = 0; col < booleans.length; col++) {
                if (booleans[col]) {
                    System.out.print((col + 1) + "\t");
                    flag = false;
                    count++;
                }
            }

            if (flag) System.out.print("No Available Seats");
            a++;
            System.out.println();
            System.out.println();
        }
        System.out.println("The total number of seats available is " + count);
    }

    public static void main(String[] args) {

        boolean[][] example = {{true, true, false}, {false, false, false}};
        TheaterSection test1 = new TheaterSection(example);
        test1.printSection();
        System.out.println();
        test1.printAvailable();

        System.out.println();

        TheaterSection test2 = new TheaterSection();
        test2.printSection();
        System.out.println();
        test2.printAvailable();
    }

}
