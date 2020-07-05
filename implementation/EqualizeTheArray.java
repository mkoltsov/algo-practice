import java.util.Arrays;
import java.util.stream.IntStream;

public class EqualizeTheArray {
    public static void main(String[] args) {
        System.out.println(equalizeArray(new int[]{3, 3, 2, 1, 3}));
        System.out.println(equalizeArray(new int[]{10, 27, 9, 10, 100, 38, 30, 32, 45, 29, 27, 29, 32, 38, 32, 38, 14, 38, 29, 30 ,63, 29, 63, 91, 54, 10, 63}));
    }

    static int equalizeArray(int[] arr) {
        int[] index = new int[101];

        for (int i=0; i< arr.length; i++) {
            ++index[arr[i]];
        }

        return arr.length - Arrays.stream(index).filter(i->i>0).max().orElse(0);
    }
}
