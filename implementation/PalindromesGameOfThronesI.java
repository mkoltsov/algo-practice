import java.util.stream.Collectors;

public class PalindromesGameOfThronesI {
    public static void main(String[] args) {
        System.out.println(gameOfThrones("aaabbbb"));
        System.out.println(gameOfThrones("cdefghmnopqrstuvw"));
        System.out.println(gameOfThrones("cdcdcdcdeeeef"));
    }

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        return s.chars().boxed().collect(Collectors.groupingBy((Integer c) -> c, Collectors.counting())).values().stream().filter(c -> c % 2 != 0).count() == 1 ? "YES" : "NO";
    }
}
