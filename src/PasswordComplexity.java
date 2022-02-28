//Akash Patel   ITCS

public class PasswordComplexity {

    public static boolean isComplex(String pass) {
        boolean t = true;


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
