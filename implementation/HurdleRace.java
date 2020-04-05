import java.util.stream.IntStream;

public class HurdleRace {
    public static void main(String[] args) {
        System.out.println(hurdleRace(4, new int[]{1, 6, 3, 5, 2}));
        System.out.println(hurdleRace(5, new int[]{2, 5, 4, 5, 2}));
    }

    static int hurdleRace(int k, int[] height) {
        return IntStream.of(height).boxed().reduce(0, (acc, i) -> acc < i - k ? i - k : acc);
    }
}
