import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AcmICPCTeam {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(acmTeam(new String[]{"10101", "11110", "00010"})));
        System.out.println(Arrays.toString(acmTeam(new String[]{"10101", "11100", "11010", "00101"})));
    }

    static int[] acmTeam(String[] topic) {
        List<char[]> list = Arrays.stream(topic).map(String::toCharArray).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < topic.length; i++) {
            for (int j = i; j < topic.length; j++) {
                if (i == j) {
                    continue;
                }
                char[] opt1 = list.get(i);
                char[] opt2 = list.get(j);
//                System.out.println(Arrays.toString(opt1));
//                System.out.println(Arrays.toString(opt2));
//                System.out.println(result);

                AtomicInteger currentMax = new AtomicInteger(0);
                IntStream.range(0, opt1.length).forEach(k -> {
//                    System.out.println("333" + k + "  " + opt1[k] + "   " + opt2[k]);
                    if (opt1[k] == '1' || opt2[k] == '1') currentMax.incrementAndGet();
                });
//                System.out.println(currentMax.get());
//               if(currentMax.get()>max.get()) {
//                   max.set(currentMax.intValue());
//                   result[0]=i;
//                   result[1]=j;
//               }
                result.add(currentMax.get());
//               if ()
            }
        }
//        System.out.println(max.get());
//        System.out.println(result);
//        System.out.println("---------------------");
        Collections.sort(result);
        int max = result.get(result.size() - 1);

        return new int[]{max, (int) result.stream().filter(x -> x == max).count()};
    }
}
