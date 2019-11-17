import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawingBook {
    public static void main(String... args) {
        System.out.println(pageCount(6, 2));
        System.out.println(pageCount(5, 4));
    }

    static int pageCount(int n, int p){
        int totalPageTurnCountFromFront = n / 2;
        int targetPageTurnCountFromFront = p / 2;
        int targetPageTurnCountFromBack = totalPageTurnCountFromFront - targetPageTurnCountFromFront;

        return Math.min(targetPageTurnCountFromFront, targetPageTurnCountFromBack);
    }

    static int pageCountNaive(int n, int p) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(-1, 1));
        for (int i = 1; i < n; i += 2) {
            if (i + 1 != n) {
                list.add(Arrays.asList(i + 1, i + 2));
            } else {
                list.add(Arrays.asList(i + 1, -1));
            }
        }
        int found = 0;
        int found1 = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).indexOf(p) != -1) {
                found = i;
                break;
            }
        }
        int count = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            count++;
            if (list.get(i).indexOf(p) != -1) {
                found1 = count - 1;
                break;
            }
        }

        return Math.min(found, found1);

    }

}

