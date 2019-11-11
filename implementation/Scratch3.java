import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Scratch3 {
    public static void main(String... args) {
        System.out.println(Arrays.toString(breakingRecords(new int[]{10, 5, 20, 20, 4, 5, 2, 25, 1})));
    }

    static int[] breakingRecords(int[] scores) {
        int max = scores[0];
        int countMaxRecord = 0;
        int countMinRecord = 0;
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                countMaxRecord++;
            }

            if (scores[i] < min) {
                min = scores[i];
                countMinRecord++;
            }
        }
        return new int[]{countMaxRecord, countMinRecord};
    }

}
