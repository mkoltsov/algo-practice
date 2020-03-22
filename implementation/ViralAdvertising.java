import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ViralAdvertising {
    public static void main(String[] args) {
        System.out.println(viralAdvertising(1));
        System.out.println(viralAdvertising(3));
        System.out.println(viralAdvertising(5));
    }

    static int viralAdvertising(int n) {
        final AtomicInteger sharedToday = new AtomicInteger(5);
        return IntStream.rangeClosed(1, n).reduce(0, (acc, i) -> {
            int likedToday = Math.floorDiv(sharedToday.get(), 2);
            sharedToday.set(likedToday * 3);
            return acc + likedToday;
        });
    }
}
