import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PseudoAsync {

    public static void main(String[] args) throws InterruptedException {
        int x = 1337;
        Result result = new Result();

        Thread t1 = new Thread(() -> { result.left = f(x); } );
        Thread t2 = new Thread(() -> { result.right = g(x); });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(result.left + result.right);
    }

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        int x = 1337;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> y = executorService.submit(() -> f(x));
        Future<Integer> z = executorService.submit(() -> g(x));
        System.out.println(y.get() + z.get());

        executorService.shutdown();
    }

    private static class Result {
        private int left;
        private int right;
    }

//    void f(int x, IntConsumer dealWithResult);

    public class CallbackStyleExample {
        public static void main(String[] args) {

            int x = 1337;
            Result result = new Result();

            f(x, (int y) -> {
                result.left = y;
                System.out.println((result.left + result.right));
            } );

            g(x, (int z) -> {
                result.right = z;
                System.out.println((result.left + result.right));
            });

        }
    }
}
