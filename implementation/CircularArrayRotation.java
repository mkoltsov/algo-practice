import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CircularArrayRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularArrayRotation(new int[]{1, 2, 3}, 2, new int[]{0, 1, 2})));
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
//        int[] copy;
        int[] result = new int[a.length];
//        for (int j = 0; j < k; j++) {
//            copy = result.length == 0 ? Arrays.copyOf(a, a.length) : Arrays.copyOf(result, a.length);
//            int shifted = copy[a.length - 1];
//            result = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                result[(i + k)%a.length] = a[i];
            }
        System.out.println(Arrays.toString(result));
//            result[0] = shifted;
//        }
        int[] queryResults = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
           queries[i] = result[i];
        }
        return queries;
    }

//    static void swapElements(int[] arr) {

}

//}
