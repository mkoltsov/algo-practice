import java.util.*;

public class MinimumDistances {
    public static void main(String[] args) {
        System.out.println(minimumDistances(new int[]{7, 1, 3, 4, 1, 7}));
        System.out.println(minimumDistances(new int[]{3,2,1,2,3}));
    }

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        Map<Integer, List<Integer>> indexes = new HashMap<>();

        for (int i=0; i<a.length;i++) {
            if (indexes.get(a[i])==null){
                List<Integer> ll = new ArrayList<>();
                ll.add(i);
                indexes.put(a[i], ll);
            } else {
                List<Integer> l = indexes.get(a[i]);
                l.add(i);
            }
        }

        return indexes.values().stream()
                .filter((List<Integer> i) -> i.size()>1)
//                .peek(System.out::println)
                .map(i -> i.stream().reduce((k, p) -> k - p).get())
                .map(Math::abs).min(Integer::compareTo)
                .orElse(-1);

    }

}
