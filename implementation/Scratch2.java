import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Scratch2 {
    public static void main(String... args) {
        int f = applyF(Arrays.asList(2, 4), Scratch2::lcm);
        int l = applyF(Arrays.asList(16, 32, 96), Scratch2::gcd);
        int count = 0;
        for(int i = f, j =2; i<=l; i=f*j,j++){
            if(l%i==0){ count++;}
        }
        System.out.println(count);
    }

    static int gcd(int a, int b) {
        return b==0 ? a: gcd(b, a%b);
    }

    static int lcm (int a, int b) {
        return (a*b)/gcd(a,b);
    }

    private static int applyF(List<Integer> input, BiFunction<Integer,Integer, Integer> f) {
        int result = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            result = f.apply(result, input.get(i));
        }
        return result;
    }


}
