import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PdfViewer {
    public static void main(String[] args) {
        System.out.println(designerPdfViewer(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, "abc"));
        System.out.println(designerPdfViewer(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}, "zaba"));
    }

    static int designerPdfViewer(int[] h, String word) {
        List<Character> alphabet = "abcdefghijklmnopqrstuvwxyz".chars().mapToObj(i-> (char)i).collect(Collectors.toList());
        List<Integer> costs = Arrays.stream(h).boxed().collect(Collectors.toList());
        char[] symbols = word.toCharArray();
        int maxCost = 0;
        System.out.println(alphabet);
        System.out.println(costs);
        for (char s: symbols) {
            int alphPosition = alphabet.indexOf(s);

            int cost = costs.get(alphPosition);
            System.out.printf( "position = %s cost = %s, symbol = %c \n", alphPosition, cost, s);
            if (cost>maxCost) {
                maxCost=cost;
            }
        }
        return maxCost*word.length();
    }
}
