import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PickingNumbers {

    public static void main(String[] args) {
        System.out.println(pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
        System.out.println(pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2)));
    }

    public static int pickingNumbers(List<Integer> a) {
        int[] setSize = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                if (Math.abs(a.get(i)) - Math.abs(a.get(j))==1 || a.get(i) == a.get(j)) {
                    //System.out.println(String.format("%d -%d", a.get(i), a.get(j) ));
                    setSize[i]++;
                }
            }
        }
        return IntStream.of(setSize).max().orElse(0);
    }
}
