import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ServiceLane {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(serviceLane(5, new int[][]{{0,3},{4,6},{6,7},{3,5},{0,7}},new int[]{2, 3, 1, 2, 3, 2, 3, 3})));
        System.out.println(Arrays.toString(serviceLane(5, new int[][]{{2, 3}, {1, 4}, {2, 4}, {2, 4}, {2, 3}}, new int[]{1, 2, 2, 2, 1})));
    }

    static int[] serviceLane(int n, int[][] cases, int[] width) {
//        int[] result = ;
//        int j = 0;

//        IntStream.range(0,n).map( )
//        var a = ;
//        System.out.println(a);
//        for (int[] i : cases) {
//            System.out.println(Arrays.toString(i));
//            System.out.println(Arrays.toString(Arrays.copyOfRange(width, i[0], i[1])));
//            result[j] = IntStream.rangeClosed(i[0], i[1]).map(k -> width[k]).min().getAsInt(); // of(Arrays.copyOfRange(width, i[0], i[1])).peek(System.out::println).min().getAsInt();
//            j++;
//        }
        return Arrays.stream(cases).map(x -> IntStream.rangeClosed(x[0], x[1]).map(k -> width[k]).min()).filter(OptionalInt::isPresent).map(OptionalInt::getAsInt).mapToInt(x->x).toArray();
    }
}
