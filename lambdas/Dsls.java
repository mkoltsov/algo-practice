import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Dsls {
    public static void main(String... args) {
        Collections.sort(persons, comparing(Person::getAge));

        Collections.sort(persons, comparing(Person::getAge).reverse());

        Collections.sort(persons, comparing(Person::getAge)
                .thenComparing(Person::getName));

        persons.sort(comparing(Person::getAge)
                .thenComparing(Person::getName));

        List<String> errors = Files.lines(Paths.get(fileName))
                .filter(line -> line.startsWith("ERROR"))
                .limit(40)
                .collect(toList());

        Map<String, Map<Color, List<Car>>> carsByBrandAndColor =
                cars.stream().collect(groupingBy(Car::getBrand,
                        groupingBy(Car::getColor)));

        Comparator<Person> comparator =
                comparing(Person::getAge).thenComparing(Person::getName);

        Collector<? super Car, ?, Map<Brand, Map<Color, List<Car>>>>
                carGroupingCollector =
                groupingBy(Car::getBrand, groupingBy(Car::getColor));


        import static java.util.stream.Collectors.groupingBy;

        public class GroupingBuilder<T, D, K> {
            private final Collector<? super T, ?, Map<K, D>> collector;

            private GroupingBuilder(Collector<? super T, ?, Map<K, D>> collector) {
                this.collector = collector;
            }

            public Collector<? super T, ?, Map<K, D>> get() {
                return collector;
            }

            public <J> GroupingBuilder<T, Map<K, D>, J>
            after(Function<? super T, ? extends J> classifier) {
                return new GroupingBuilder<>(groupingBy(classifier, collector));
            }

            public static <T, D, K> GroupingBuilder<T, List<T>, K>
            groupOn(Function<? super T, ? extends K> classifier) {
                return new GroupingBuilder<>(groupingBy(classifier));
            }

            Collector<? super Car, ?, Map<Brand, Map<Color, List<Car>>>>
                    carGroupingCollector =
                    groupOn(Car::getColor).after(Car::getBrand).get()
        }

        Order order = forCustomer( "BigBank" )
                .buy( 80 )
                .stock( "IBM" )
                .on( "NYSE" )
                .at( 125.00 )
                .sell( 50 )
                .stock( "GOOGLE" )
                .on( "NASDAQ" )
                .at( 375.00 )
                .end();
    }

    public class Order {

        private String customer;
        private List<Trade> trades = new ArrayList<>();

        public void addTrade(Trade trade) {
            trades.add(trade);
        }

        public String getCustomer() {
            return customer;
        }
        public void setCustomer(String customer) {
            this.customer = customer;
        }

        public double getValue() {
            return trades.stream().mapToDouble(Trade::getValue).sum();
        }
    }

    public class MethodChainingOrderBuilder {

        public final Order order = new Order();                                1

        private MethodChainingOrderBuilder(String customer) {
            order.setCustomer(customer);
        }

        public static MethodChainingOrderBuilder forCustomer(String customer) {
            return new MethodChainingOrderBuilder(customer);                   2
        }

        public TradeBuilder buy(int quantity) {
            return new TradeBuilder(this, Trade.Type.BUY, quantity);           3
        }

        public TradeBuilder sell(int quantity) {
            return new TradeBuilder(this, Trade.Type.SELL, quantity);          4
        }

        public MethodChainingOrderBuilder addTrade(Trade trade) {
            order.addTrade(trade);                                             5
            return this;                                                       6
        }

        public Order end() {
            return order;                                                      7
        }
    }

    public class TradeBuilder {
        private final MethodChainingOrderBuilder builder;
        public final Trade trade = new Trade();

        private TradeBuilder(MethodChainingOrderBuilder builder,
                             Trade.Type type, int quantity) {
            this.builder = builder;
            trade.setType( type );
            trade.setQuantity( quantity );
        }

        public StockBuilder stock(String symbol) {
            return new StockBuilder(builder, trade, symbol);
        }
    }

    public class StockBuilder {
        private final MethodChainingOrderBuilder builder;
        private final Trade trade;
        private final Stock stock = new Stock();

        private StockBuilder(MethodChainingOrderBuilder builder,
                             Trade trade, String symbol) {
            this.builder = builder;
            this.trade = trade;
            stock.setSymbol(symbol);
        }

        public TradeBuilderWithStock on(String market) {
            stock.setMarket(market);
            trade.setStock(stock);
            return new TradeBuilderWithStock(builder, trade);
        }
    }

    public class TradeBuilderWithStock {
        private final MethodChainingOrderBuilder builder;
        private final Trade trade;

        public TradeBuilderWithStock(MethodChainingOrderBuilder builder,
                                     Trade trade) {
            this.builder = builder;
            this.trade = trade;
        }

        public MethodChainingOrderBuilder at(double price) {
            trade.setPrice(price);
            return builder.addTrade(trade);
        }
    }

    Order order = order("BigBank",
            buy(80,
                    stock("IBM", on("NYSE")),
                    at(125.00)),
            sell(50,
                    stock("GOOGLE", on("NASDAQ")),
                    at(375.00))
    );

    public class NestedFunctionOrderBuilder {

        public static Order order(String customer, Trade... trades) {
            Order order = new Order();                                      1
            order.setCustomer(customer);
            Stream.of(trades).forEach(order::addTrade);                     2
            return order;
        }

        public static Trade buy(int quantity, Stock stock, double price) {
            return buildTrade(quantity, stock, price, Trade.Type.BUY);      3
        }

        public static Trade sell(int quantity, Stock stock, double price) {
            return buildTrade(quantity, stock, price, Trade.Type.SELL);     4
        }

        private static Trade buildTrade(int quantity, Stock stock, double price,
                                        Trade.Type buy) {
            Trade trade = new Trade();
            trade.setQuantity(quantity);
            trade.setType(buy);
            trade.setStock(stock);
            trade.setPrice(price);
            return trade;
        }

        public static double at(double price) {                             5
            return price;
        }

        public static Stock stock(String symbol, String market) {
            Stock stock = new Stock();                                      6
            stock.setSymbol(symbol);
            stock.setMarket(market);
            return stock;
        }

        public static String on(String market) {                            7
            return market;
        }
    }

    Order order = order( o -> {
        o.forCustomer( "BigBank" );
        o.buy( t -> {
            t.quantity( 80 );
            t.price( 125.00 );
            t.stock( s -> {
                s.symbol( "IBM" );
                s.market( "NYSE" );
            } );
        });
        o.sell( t -> {
            t.quantity( 50 );
            t.price( 375.00 );
            t.stock( s -> {
                s.symbol( "GOOGLE" );
                s.market( "NASDAQ" );
            } );
        });
    } );

    public class LambdaOrderBuilder {

        private Order order = new Order();                                   1

        public static Order order(Consumer<LambdaOrderBuilder> consumer) {
            LambdaOrderBuilder builder = new LambdaOrderBuilder();
            consumer.accept(builder);                                        2
            return builder.order;                                            3
        }

        public void forCustomer(String customer) {
            order.setCustomer(customer);                                     4
        }

        public void buy(Consumer<TradeBuilder> consumer) {
            trade(consumer, Trade.Type.BUY);                                 5
        }

        public void sell(Consumer<TradeBuilder> consumer) {
            trade(consumer, Trade.Type.SELL);                                6
        }

        private void trade(Consumer<TradeBuilder> consumer, Trade.Type type) {
            TradeBuilder builder = new TradeBuilder();
            builder.trade.setType(type);
            consumer.accept(builder);                                        7
            order.addTrade(builder.trade);                                   8
        }
    }

    public class TradeBuilder {
        private Trade trade = new Trade();

        public void quantity(int quantity) {
            trade.setQuantity( quantity );
        }

        public void price(double price) {
            trade.setPrice( price );
        }

        public void stock(Consumer<StockBuilder> consumer) {
            StockBuilder builder = new StockBuilder();
            consumer.accept(builder);
            trade.setStock(builder.stock);
        }
    }

    public class StockBuilder {
        private Stock stock = new Stock();

        public void symbol(String symbol) {
            stock.setSymbol( symbol );
        }

        public void market(String market) {
            stock.setMarket( market );
        }
    }

    Order order =
            forCustomer( "BigBank",
                    buy( t -> t.quantity( 80 )
                            .stock( "IBM" )
                            .on( "NYSE" )
                            .at( 125.00 )),
                    sell( t -> t.quantity( 50 )
                            .stock( "GOOGLE" )
                            .on( "NASDAQ" )
                            .at( 125.00 )) );

    public class MixedBuilder {

        public static Order forCustomer(String customer,
                                        TradeBuilder... builders) {
            Order order = new Order();
            order.setCustomer(customer);
            Stream.of(builders).forEach(b -> order.addTrade(b.trade));
            return order;
        }

        public static TradeBuilder buy(Consumer<TradeBuilder> consumer) {
            return buildTrade(consumer, Trade.Type.BUY);
        }

        public static TradeBuilder sell(Consumer<TradeBuilder> consumer) {
            return buildTrade(consumer, Trade.Type.SELL);
        }

        private static TradeBuilder buildTrade(Consumer<TradeBuilder> consumer,
                                               Trade.Type buy) {
            TradeBuilder builder = new TradeBuilder();
            builder.trade.setType(buy);
            consumer.accept(builder);
            return builder;
        }
    }

    public class TradeBuilder {
        private Trade trade = new Trade();

        public TradeBuilder quantity(int quantity) {
            trade.setQuantity(quantity);
            return this;
        }

        public TradeBuilder at(double price) {
            trade.setPrice(price);
            return this;
        }

        public StockBuilder stock(String symbol) {
            return new StockBuilder(this, trade, symbol);
        }
    }

    public class StockBuilder {
        private final TradeBuilder builder;
        private final Trade trade;
        private final Stock stock = new Stock();

        private StockBuilder(TradeBuilder builder, Trade trade, String symbol){
            this.builder = builder;
            this.trade = trade;
            stock.setSymbol(symbol);
        }

        public TradeBuilder on(String market) {
            stock.setMarket(market);
            trade.setStock(stock);
            return builder;
        }
    }

    public class Tax {
        public static double regional(double value) {
            return value * 1.1;
        }

        public static double general(double value) {
            return value * 1.3;
        }

        public static double surcharge(double value) {
            return value * 1.05;
        }
    }

    public class TaxCalculator {
        public DoubleUnaryOperator taxFunction = d -> d;              1

        public TaxCalculator with(DoubleUnaryOperator f) {
            taxFunction = taxFunction.andThen(f);                    2
            return this;                                             3
        }

        public double calculate(Order order) {
            return taxFunction.applyAsDouble(order.getValue());      4
        }
    }

    double value = new TaxCalculator().with(Tax::regional)
            .with(Tax::surcharge)
            .calculate(order);
}



