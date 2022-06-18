import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftRotation {
    public static void main(String[] args) {
        System.out.println(rotLeft(Arrays.asList(1, 2, 3,4,5), 4));
//                                                 0  1  2 3 4
//                                                 1  2  3 4 0
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int[] result = new int[a.size()];
        for (int i=0; i<a.size(); i++){
            int futureIndex = i-d<0 ?(i-d)+a.size(): i-d ;
//            System.out.println(a.size());
//            System.out.printf(String.format("%s-%s-%s \n", a.get(i), i, futureIndex));
            result[futureIndex]=a.get(i);

        }
        //        System.out.printf(String.format("test string %s", "yo"));
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
