import java.util.stream.IntStream;

public class ElectronicsShop {
    public static void main(String... args) {
        System.out.println(getMoneySpent(new int[]{3, 1}, new int[]{5, 2, 8}, 10));
        System.out.println(getMoneySpent(new int[]{4}, new int[]{5}, 5));
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
//        int maxSum = -1;
//        for (int i : keyboards) {
//            for (int j : drives) {
//                if (i + j < b && i + j > maxSum) {
//                    maxSum = i + j;
//                }
//            }
//        }
//        return maxSum;
        try {
            return IntStream.range(0, keyboards.length)
                    .flatMap(x -> IntStream
                            .range(0, drives.length)
                            .map(y -> drives[y] + keyboards[x]))
                    .filter(x -> x <= b)
                    .map(x -> x * -1)
                    .sorted()
                    .map(x -> x * -1)
                    .toArray()[0];
        } catch (Exception ex) {
            return -1;
        }
    }
}
