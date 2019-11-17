import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingValleys {
    public static void main(String... args) {
        System.out.println();
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(8, "UDUUUDUDDD"));
        System.out.println(countingValleys(8, "DDUUDDUDUUUD"));
    }

    static int countingValleys(int n, String s) {
        int level = 0;
        int prevLevel = 0;
        int numberOfValleys = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'U':
                    prevLevel = level;
                    level += 1;
                    break;
                case 'D':
                    prevLevel = level;
                    level -= 1;
                    break;
            }
            if (i < s.length() - 1 && (s.charAt(i) == s.charAt(i + 1)) && prevLevel >= 0) {
                continue;
            }
            if (i != 0 && level == 0 && prevLevel <= 0) {
                numberOfValleys++;
            }
        }
        return numberOfValleys;
    }


}

