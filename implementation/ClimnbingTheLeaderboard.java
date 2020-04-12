import java.util.Arrays;
import java.util.stream.IntStream;

public class ClimnbingTheLeaderboard {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(climbingLeaderboard(new int[]{100, 100, 50, 40, 40, 20, 10}, new int[]{5, 25, 50, 120})));
        System.out.println(Arrays.toString(climbingLeaderboard(new int[]{100, 90, 90, 80, 75, 60}, new int[]{50, 65, 77, 90, 102})));
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        Integer[] arr = IntStream.of(scores).boxed().sorted().distinct().toArray(Integer[]::new);
        int[] result = new int[alice.length];
        IntStream.range(0, alice.length).forEach(i -> {
            int elem = Arrays.binarySearch(arr, alice[i]);
            result[i] = elem >= 0 ?
                    arr.length - elem : Math.abs(elem) == arr.length + 1 ? 1 : arr.length - (Math.abs(elem)) + 2;
        });
        return result;
    }
}
