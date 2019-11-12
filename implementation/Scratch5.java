import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scratch5 {
    public static void main(String... args) {
        System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

    static int sockMerchant(int n, int[] ar) {

        int[] pairs = new int[1000];

        for (int i: ar) {
            pairs[i]+=1;
        }
        return Arrays.stream(pairs).boxed().filter(i->i!=0).map(i->i/2).reduce(0, Integer::sum);
    }
}
