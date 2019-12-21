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
    }

}
