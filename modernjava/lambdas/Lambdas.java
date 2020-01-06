public class Lambdas {
    public static void main (String... args){

//        chain of responsibility
        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;       1
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");          2
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);             3
        String result = pipeline.apply("Aren't labdas really sexy?!!");
//observer
        f.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        f.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet more news from London... " + tweet);
            }
        });
//template
        public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
            Customer c = Database.getCustomerWithId(id);
            makeCustomerHappy.accept(c);
        }

        new OnlineBankingLambda().processCustomer(1337, (Customer c) ->
                System.out.println("Hello " + c.getName());

//strategy

        Validator numericValidator =
                new Validator((String s) -> s.matches("[a-z]+"));       1
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator =
                new Validator((String s) -> s.matches("\\d+"));         1
        boolean b2 = lowerCaseValidator.validate("bbbb");

//factory
        final static Map<String, Supplier<Product>> map = new HashMap<>();
        static {
            map.put("loan", Loan::new);
            map.put("stock", Stock::new);
            map.put("bond", Bond::new);
        }

        public static Product createProduct(String name){
            Supplier<Product> p = map.get(name);
            if(p != null) return p.get();
            throw new IllegalArgumentException("No such product " + name);
        }

//testing

        public class Point {
            public final static Comparator<Point> compareByXAndThenY =
                    comparing(Point::getX).thenComparing(Point::getY);
    ...
        }

        @Test
        public void testComparingTwoPoints() throws Exception {
            Point p1 = new Point(10, 15);
            Point p2 = new Point(10, 20);
            int result = Point.compareByXAndThenY.compare(p1 , p2);
            assertTrue(result < 0);
        }

        public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
            return points.stream()
                    .map(p -> new Point(p.getX() + x, p.getY()))
                    .collect(toList());
        }

        @Test
        public void testMoveAllPointsRightBy() throws Exception {
            List<Point> points =
                    Arrays.asList(new Point(5, 5), new Point(10, 5));
            List<Point> expectedPoints =
                    Arrays.asList(new Point(15, 5), new Point(20, 5));
            List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
            assertEquals(expectedPoints, newPoints);
        }

//        logging
        List<Integer> result =
                numbers.stream()
                        .peek(x -> System.out.println("from stream: " + x))    1
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))      2
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))   3
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))    4
                .collect(toList());
    }

}
