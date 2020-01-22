public class FP {
    Function<String, Integer> strToInt = Integer::parseInt;
    Comparator<Apple> c = comparing(Apple::getWeight);

    Function<String, String> transformationPipeline
            = addHeader.andThen(Letter::checkSpelling)
            .andThen(Letter::addFooter);
}