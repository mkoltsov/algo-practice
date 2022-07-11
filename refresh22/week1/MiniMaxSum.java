package week1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MiniMaxSum {
    public static void main(String[] args) {
        miniMaxSum(Arrays.asList(1,3,5,7,9));
    }

    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);

        int minSum = IntStream.range(0, arr.size()-1).map(arr::get).sum();
        int maxSum = IntStream.range(1, arr.size()).map(arr::get).sum();
        System.out.println( minSum +" "+ maxSum);

    }

}
