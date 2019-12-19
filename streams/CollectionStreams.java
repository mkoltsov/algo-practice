import java.util.Map;

public class CollectionStreams {
    public static void main(String... args) {
        Set<String> friends
                = Stream.of("Raphael", "Olivia", "Thibaut")
                .collect(Collectors.toSet());

        List<String> friends = List.of("Raphael", "Olivia", "Thibaut");

        Set<String> friends = Set.of("Raphael", "Olivia", "Thibaut");

        Map<String, Integer> ageOfFriends
                = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);

        import static java.util.Map.entry;
        Map<String, Integer> ageOfFriends
                = Map.ofEntries(entry("Raphael", 30),
                entry("Olivia", 25),
                entry("Thibaut", 26));

        transactions.removeIf(transaction ->
                Character.isDigit(transaction.getReferenceCode().charAt(0)));

        referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) +
                code.substring(1));
        //map
        ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " +
                age + " years old"));

        Map<String, String> favouriteMovies
                = Map.ofEntries(entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"),
                entry("Olivia",
                        "James Bond"));

        favouriteMovies
                .entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .forEachOrdered(System.out::println);

        Map<String, String> favouriteMovies
                = Map.ofEntries(entry("Raphael", "Star Wars"),
                entry("Olivia", "James Bond"));

        System.out.println(favouriteMovies.getOrDefault("Olivia", "Matrix"));
        System.out.println(favouriteMovies.getOrDefault("Thibaut", "Matrix"));

        Map<String, byte[]> dataToHash = new HashMap<>();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        lines.forEach(line ->
                dataToHash.computeIfAbsent(line,
        this::calculateDigest));

        private byte[] calculateDigest(String key) {
            return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
        }

        friendsToMovies.computeIfAbsent("Raphael", name -> new ArrayList<>())
                .add("Star Wars");

        favouriteMovies.remove(key, value);

        //replacing elements in a map
        Map<String, String> favouriteMovies = new HashMap<>();                1
        favouriteMovies.put("Raphael", "Star Wars");
        favouriteMovies.put("Olivia", "james bond");
        favouriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
        System.out.println(favouriteMovies);


        //merging maps
        Map<String, String> family = Map.ofEntries(
                entry("Teo", "Star Wars"), entry("Cristina", "James Bond"));
        Map<String, String> friends = Map.ofEntries(
                entry("Raphael", "Star Wars"), entry("Cristina", "Matrix"));

        Map<String, String> everyone = new HashMap<>(family);
        friends.forEach((k, v) ->
                everyone.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));   1
        System.out.println(everyone);
//        this is equal
        Map<String, Long> moviesToCount = new HashMap<>();
        String movieName = "JamesBond";
        long count = moviesToCount.get(movieName);
        if(count == null) {
            moviesToCount.put(movieName, 1);
        }
        else {
            moviesToCount.put(moviename, count + 1);
        }

        //to
        moviesToCount.merge(movieName, 1L, (key, count) -> count + 1L);

//        reducing a concurrenthashmap

        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();        1
        long parallelismThreshold = 1;
        Optional<Integer> maxValue =
                Optional.ofNullable(map.reduceValues(parallelismThreshold, Long::max));
    }

}
