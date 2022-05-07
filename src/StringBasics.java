import java.util.Scanner;

public class StringBasics {

    public static String greet(String name) {

        return "Hello " + name + "!" + " How are you?";
    }

    public static String reverse(String s) {

        StringBuilder reverse = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse.append(s.charAt(i));
        }

        return reverse.toString();
    }

    public static String lastFirst(String fullName) {

        String firstName = fullName.substring(0, fullName.indexOf(" "));
        String lastName = fullName.substring(fullName.indexOf(" ") + 1);
        fullName = lastName + ", " + firstName;

        return fullName;
    }

    public static String initials(String fullName) {

        char x = fullName.charAt(0);
        StringBuilder initials = new StringBuilder(Character.toString(x));

        for (int i = 0; i < fullName.length(); i++) {
            if (fullName.charAt(i) == ' ') {
                initials.append(fullName.charAt(i + 1));
            }
        }

        return initials.toString();
    }

    public static int countVowels(String s) {

        s = s.toLowerCase();
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ('a') || s.charAt(i) == ('e') || s.charAt(i) == ('i') || s.charAt(i) == ('o') || s.charAt(i) == ('u')) {
                x++;
            }
        }

        return x;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (!scan.nextLine().equals("quit")) {

            System.out.println("Enter a name: ");
            String name = scan.nextLine();
            System.out.println(greet(name));
            System.out.println(reverse(name));
            System.out.println(lastFirst(name));
            System.out.println(initials(name));
            System.out.println(countVowels(name));
        }

    }

}
