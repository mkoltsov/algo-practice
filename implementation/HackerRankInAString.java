import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class HackerRankInAString {
    public static void main(String[] args) {
        System.out.println(hackerrankInString("hereiamstackerrank"));
        System.out.println(hackerrankInString("hhaacckkekraraannk"));
        System.out.println(hackerrankInString("rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt"));
    }

    static String hackerrankInString(String s) {
        char[] pattern = "hackerrank".toCharArray();
        List<Integer> positions = new ArrayList<>();
        char[] source = s.toCharArray();
        int curPosition = 0;
        for (int i = 0; i < pattern.length; i++) {
            for (int j = curPosition; j < source.length; j++) {
                if (pattern[i] == source[j]) {
                    System.out.println(String.format("i= %d j=%d", i, j));
                    positions.add(j);
                    curPosition = j;
                    source[j] = '0';
                    break;
                }
            }
//            int currentIndex =
//                    IntStream.range(0, s.length()).anyMatch();
//            if (currentIndex>0) {
//                positions[i]=currentIndex;
//                s.
//            }
        }
//        System.out.println(Arrays.toString(positions));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Arrays.stream(positions).reduce(0, (acc, b)-> b>acc ? b : Integer.MAX_VALUE));
        return positions.stream().reduce(0, (acc, b) -> b > acc ? b : -1) != -1 && positions.size() == pattern.length ? "YES" : "NO";
    }
}
