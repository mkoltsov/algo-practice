public class ParallelStreams {

    public static void main (String... args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism",
                "12");
    }
}
