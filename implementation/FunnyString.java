import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunnyString {
    public static void main(String[] args) {
        System.out.println(funnyString("lmnop"));
        System.out.println(funnyString("bcxz"));
    }

    static String funnyString(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
       return Arrays.equals(findDifference(s.toCharArray()),findDifference(reverse.toCharArray())) ? "Funny":"Not Funny";
    }

    static int[] findDifference(char[] source) {
    List<Integer> diff = new ArrayList<>();
        for (int i=0; i<source.length-1; i++){
            diff.add(Math.abs(source[i]-source[i+1]));
        }
        return diff.stream().mapToInt(x->x).toArray();
    }

}
