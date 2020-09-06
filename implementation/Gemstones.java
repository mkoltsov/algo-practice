import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Gemstones {
    public static void main(String[] args) {
        System.out.println(gemstones(new String[]{"abcdde", "baccd", "eeabg"}));
    }

    static int gemstones(String[] arr) {

        return (int) Arrays.stream(arr).map(i -> i.chars().distinct().toArray()).flatMapToInt(j -> Arrays.stream(j, 0, j.length)).boxed().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()))
                .values().stream().filter(k -> k == arr.length).count();
    }
}
