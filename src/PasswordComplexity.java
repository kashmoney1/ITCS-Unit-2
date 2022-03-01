//Akash Patel   ITCS

public class PasswordComplexity {

    public static boolean isComplex(String pass) {
        String check = pass.toLowerCase();
        boolean special = false;
        boolean upper = false;
        boolean lower = false;

        if (pass.length() < 8) {
            return false;
        }

        if (check.contains("password")) {
            return false;
        }

        for (int i = 0; i < pass.length(); i++) {
            int ascii = (int)pass.charAt(i);
            if (ascii > 33 && ascii < 64) {
                special = true;
            }
            if (ascii > 64 && ascii < 90) {
                upper = true;
            }
            if (ascii > 96 && ascii < 123) {
                lower = true;
            }
        }

        if (special && upper && lower) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isComplex("bigTurtle44")); //true
        System.out.println(isComplex("@paSSpaSS?")); //true
        System.out.println(isComplex("myPassword123!")); //false
        System.out.println(isComplex("pAc!")); //false
        System.out.println(isComplex("FlyingOrange")); //false
        System.out.println(isComplex("turtles=true")); //false
    }

}
