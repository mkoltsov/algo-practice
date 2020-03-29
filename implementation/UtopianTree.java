import java.util.stream.IntStream;

public class UtopianTree {
    public static void main(String[] args) {
        System.out.println(utopianTree(5));
        System.out.println(utopianTree(4));
    }

    static int utopianTree(int n) {
        return IntStream.rangeClosed(0, n - 1).reduce(1, (acc, i) -> {
            if (i % 2 == 0) {
                return acc *= 2;
            } else
                return acc += 1;
        });
    }
}
