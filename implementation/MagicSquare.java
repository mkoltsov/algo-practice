import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MagicSquare {

    public static void main(String... args) {
        System.out.println(formingMagicSquare(new int[][]{{4, 8, 2}, {4, 5, 7}, {6, 1, 6}}));
    }

    static int formingMagicSquare(int[][] s) {

        int[] matrix = new int[9];
        int[] sums = new int[8];

        int[][] finalPatterns = {{8, 1, 6, 3, 5, 7, 4, 9, 2},
                {4, 3, 8, 9, 5, 1, 2, 7, 6},
                {2, 9, 4, 7, 5, 3, 6, 1, 8},
                {6, 7, 2, 1, 5, 9, 8, 3, 4},
                {6, 1, 8, 7, 5, 3, 2, 9, 4},
                {8, 3, 4, 1, 5, 9, 6, 7, 2},
                {4, 9, 2, 3, 5, 7, 8, 1, 6},
                {2, 7, 6, 9, 5, 1, 4, 3, 8}};
        int ind = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                matrix[ind] = s[i][j];
                ind++;
            }

        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (finalPatterns[i][j] != matrix[j]) {
                    sums[i] = sums[i] + Math.abs(matrix[j] - finalPatterns[i][j]);
                }
            }
        }

        int result = sums[0];

        for (int i = 1; i < 8; i++) {
            if (sums[i] < result) {
                result = sums[i];
            }
        }

        return result;
//        int p1 = IntStream.of(s[0]).reduce(0, Integer::sum);
//        int p2 = IntStream.of(s[1]).reduce(0, Integer::sum);
//        int p3 = IntStream.of(s[2]).reduce(0, Integer::sum);
//        int p4= 0;
//
//        for (int i =0 ; i< s.length; i++) {
//            System.out.println(s[i][i]);
//            p4+=s[i][i];
//        }
//        int p5= 0;
//        for (int i =s.length-1 ; i>=0; i--) {
//            p5+=s[i][i];
//        }
//        int[] arr = new int[] {p1,p2,p3,p4,p5};
//        List<Integer> p = Arrays.asList(p1,p2,p3,p4,p5);
//        System.out.println(IntStream.of(p1,p2,p3,p4,p5).filter(e-> Collections.frequency(p,e)> 1).reduce(Integer::min).orElse(IntStream.of(p1,p2,p3,p4,p5).min().getAsInt()));
//
//
//
//
//        System.out.println(String.format("%d,%d,%d,%d,%d,", p1, p2,p3,p4,p5));
//        return 0;

    }
}
