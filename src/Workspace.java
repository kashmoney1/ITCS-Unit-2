//Enter all test problems/review problems to solve for them in this workspace
//Whiteboard problems too

public class Workspace {

    public static String mystery(String word) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < word.length()-1; i++) {
            output.append(word, i, i + 2);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String test = "ITCS";
        System.out.println(mystery(test));
    }
}
