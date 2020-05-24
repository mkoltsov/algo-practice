import java.math.BigInteger;

public class ExtraLongFactorial {
    public static void main(String[] args) {
        extraLongFactorials(25);
    }

    static void extraLongFactorials(int n) {
        System.out.println(factorial(n));
    }

    static BigInteger factorial(int curr) {
        if (curr == 1) {
            return BigInteger.valueOf(curr);
        } else {
            return BigInteger.valueOf(curr).multiply(factorial(curr - 1));
        }
    }
//primitive
    //    static int factorial(int curr) {
//        if (curr == 1) {
//            return curr;
//        } else {
//            return curr * factorial(curr - 1);
//        }
//    }
}
