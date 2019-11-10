import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Scratch {
    public static void main(String[] args) {
        char[] arr = {'#', '#', '#', '#', '#', '#', '#', '#', '#'};

        //        System.out.println(Stream.of(arr).map(String::valueOf).collect(Collectors.joining()));
        //        ArrayUtils.addAll

        //        staircase(6);
        System.out.println(birthday(Arrays.asList(1, 2, 1, 3, 2), 3, 2));
        System.out.println("------------");
        System.out.println(birthday(Arrays.asList(4), 4, 1));
        System.out.println("------------");
        System.out.println(birthday(Arrays.asList(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1), 18, 7));

        //Arrays.s
        int[] ff = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4};
        int result =
                Arrays.stream(ff).boxed().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                ).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("rrrr" + result);

        bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12);
        bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 7);

        System.out.println(getTotalX(Arrays.asList(2, 6), Arrays.asList(24,36)));

    }

    static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            //            for (int j = 0; j < i; j++) {
            char[] arr = new char[i];
            char[] spaces = new char[n - i];
            Arrays.fill(arr, '#');
            Arrays.fill(spaces, ' ');
            System.out.println(String.valueOf(spaces) + String.valueOf(arr));
            //            }
            //
            //            System.out.println(Stream.concat(Stream.of(arr).map(String::valueOf), Stream.of(arr).map(String::valueOf))
            //                    .collect(Collectors.joining()));
            // System.out.println(Stream.of(arr).map(String::valueOf).collect(Collectors.joining()));
            // for (int j=0;j<i;j++) {

            //     System.out.print('#');
            // }

        }

    }


    static int birthday(List<Integer> s, int d, int m) {
        int result = 0;
        System.out.println(2);

        for (int i = 0; i < (s.size() == 1 ? s.size() : s.size() - 1); i++) {
            int sum = 0;
            System.out.println(2);
            for (int j = i; j < i + m && j < s.size(); j++) {
                System.out.println(String.format("i=%d, j=%d", i, j));
                sum = sum + s.get(j);
            }
            if (sum == d) {
                result++;
            }
            System.out.println("rrr" + result);

        }
        return result;
    }

    static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = IntStream.range(0, bill.size()).filter(i -> i != k).map(bill::get).reduce(0, Integer::sum);
        if (sum / 2 == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - (sum / 2));
        }


    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
//        List<Integer> divs = findDividers(a,false);
        List<Integer> divs2 = findDividers(a,false);
                List<Integer> divs = findDividers(a,true);

        return 0;
//        return (int) findDividers(b,true).stream().filter(i -> !divs.contains(i)).count();
    }

    private static boolean isFactor(int i, int j) {
        return i%j==0;
    }

    private static List<Integer> findDividers(List<Integer> a, boolean reverse) {
        List<Integer> ll = new ArrayList<>();
        a.sort(Integer::compareTo);
        Integer maxValue = a.get(a.size() - 1);



        for (int i = maxValue; i > 0; i--) {
            boolean isF=false;
            int divider = i;
//            boolean isCommonDivider = false;
            if (!reverse) {
                isF = a.stream().filter(j->isFactor(j, divider)).count()==a.size();
            } else {

//                j->j % checked!=0
                 isF = a.stream().filter(j->isFactor(divider, j)).count()==a.size();
//
//                for (int val : a) {
//                    System.out.println(String.format("val=%d, i=%d",val,i));
//                    if (val % i == 0) {
//                        System.out.println(String.format("match val=%d, i=%d",val,i));
//                        isCommonDivider = true;
//                    } else
//                        isCommonDivider = false;
//                }
            }


            if (isF) {
                ll.add(i);
            }

        }
        System.out.println("ll=" + ll.toString());
        return ll;
    }
}