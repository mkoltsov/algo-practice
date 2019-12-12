import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public class Collectors {
    public static void main(String... args) {
        Comparator<String> dishCaloriesComparator =
                Comparator.comparingInt(String::length);
        Optional<String> mostCalorieDish =
                Stream.of("Curry", "Steak")
                        .collect(maxBy(dishCaloriesComparator));

        Map<Currency, List<Transaction>> transactionsByCurrencies =
                transactions.stream().collect(groupingBy(Transaction::getCurrency));

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));

        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));

        String shortMenu = menu.stream().map(Dish::getName).collect(joining());

        String shortMenu = menu.stream().collect(joining());

        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));

        int totalCalories = menu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));

        Optional<Dish> mostCalorieDish =
                menu.stream().collect(reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        Stream<Integer> stream = asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l; },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1; });

        int totalCalories = menu.stream().collect(reducing(0,
                Dish::getCalories,
                Integer::sum));

        int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();

        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        public enum CaloricLevel { DIET, NORMAL, FAT }
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                } ));

        Map<Dish.Type, List<Dish>> caloricDishesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                filtering(dish -> dish.getCalories() > 500, toList())));

        Map<Dish.Type, List<String>> dishNamesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                mapping(Dish::getName, toList())));


        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        Map<Dish.Type, Set<String>> dishNamesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
                                        toSet())));
//multilevel grouping
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                } )
                        )
                );

        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));


        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCalories))));


        Map<Dish.Type, Dish> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));


        Map<Dish.Type, Dish> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));

//        PARTITIONING

        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                groupingBy(Dish::getType)));

        menu.stream().collect(partitioningBy(Dish::isVegetarian,
                counting()));


        public boolean isPrime(int candidate) {
            int candidateRoot = (int) Math.sqrt((double) candidate);
            return IntStream.rangeClosed(2, candidateRoot)
                    .noneMatch(i -> candidate % i == 0);

            public Map<Boolean, List<Integer>> partitionPrimes(int n) {
                return IntStream.rangeClosed(2, n).boxed()
                        .collect(
                                partitioningBy(candidate -> isPrime(candidate)));
            }
        }
//        Custom collector
//        public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector
//        (int n) {
//            IntStream.rangeClosed(2, n).boxed()
//                    .collect(
//                            () -> new HashMap<Boolean, List<Integer>>() {{    1
//                                put(true, new ArrayList<Integer>());
//                                put(false, new ArrayList<Integer>());
//                            }},
//                            (acc, candidate) -> {                                     2
//                                acc.get( isPrime(acc.get(true), candidate) )
//                                        .add(candidate);
//                            },
//                            (map1, map2) -> {                                        3
//                                map1.get(true).addAll(map2.get(true));
//                                map1.get(false).addAll(map2.get(false));
//                            });
//        }
//        1 Supplier
//        2 Accumulator
//        3 Combiner

    }



}