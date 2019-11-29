import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Streams {

    static class Trader{
        private final String name;
        private final String city;
        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }
        public String getName(){
            return this.name;
        }
        public String getCity(){
            return this.city;
        }
        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }

     static class Transaction{
        private final Trader trader;
        private final int year;
        private final int value;
        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }
        public Trader getTrader(){
            return this.trader;
        }
        public int getYear(){
            return this.year;
        }
        public int getValue(){
            return this.value;
        }
        public String toString(){
            return "{" + this.trader + ", " +
                    "year: "+this.year+", " +
                    "value:" + this.value +"}";
        }
    }

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println(transactions.stream().filter(i-> i.year==2011).sorted(Comparator.comparingInt(a -> a.value)).collect(toList()));
        System.out.println(transactions.stream().map(i->i.trader.city).distinct().collect(toList()));
        System.out.println(transactions.stream().filter(i->i.trader.city.equals("Cambridge")).sorted(comparing(i-> i.trader.name)).collect(toList()));
        System.out.println(transactions.stream().map(i->i.trader.name).distinct().sorted(comparing(i-> i)).collect(toList()));
        System.out.println(transactions.stream().anyMatch(i->i.trader.city.equals("Milan")));
        System.out.println(transactions.stream().filter(i->i.trader.city.equals("Cambridge")).map(i->i.value).collect(toList()));
        System.out.println(transactions.stream().map(i->i.value).reduce(0, Integer::max));
        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .reduce((t1, t2) ->
                                t1.getValue() < t2.getValue() ? t1 : t2);
        Optional<Transaction> smallestTransaction2 =
                transactions.stream()
                        .min(comparing(Transaction::getValue));
    }

}
