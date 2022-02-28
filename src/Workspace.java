//Enter all test problems/review problems to solve for them in this workspace
//Whiteboarding problems too

public class Workspace {

    public static String mystery(String word) {
        String output = "";
        for (int i = 0; i < word.length()-1; i++) {
            output += word.substring(i, i + 2);
        }
        return output;
    }

    public static void main(String[] args) {
        String test = "ITCS";
        System.out.println(mystery(test));
    }
}
