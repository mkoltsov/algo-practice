import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.maxBy;

public class Collectors {
    public static void main(String... args) {
        Comparator<String> dishCaloriesComparator =
                Comparator.comparingInt(String::length);
        Optional<String> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));
    }

}