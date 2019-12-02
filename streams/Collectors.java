import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;

public class Collectors {
    public static void main(String... args) {
        Comparator<String> dishCaloriesComparator =
                Comparator.comparingInt(String::length);
        Optional<String> mostCalorieDish =
                Stream.of("Curry", "Steak")
                        .collect(maxBy(dishCaloriesComparator));
    }

}