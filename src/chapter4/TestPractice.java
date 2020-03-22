package chapter4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class TestPractice {
    public static void main(String[] args) {
        List<Transaction> data = buildData();
        //testPractice1(data);
        //testPractice2(data);
        //testPractice3(data);
        //testPractice4(data);
        //testPractice5(data);
        //testPractice6(data);
        //testPractice7(data);
        testPractice8(data);
    }

    private static void testPractice8(List<Transaction> data) {
        data.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findFirst()
                .ifPresent(System.out::println);

        data.stream()
                .reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2)
                .ifPresent(System.out::println);

        data.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .ifPresent(System.out::println);
    }

    private static void testPractice7(List<Transaction> data) {
        data.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
    }

    private static void testPractice6(List<Transaction> data) {
        data.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    private static void testPractice5(List<Transaction> data) {
        boolean result = data.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                .findAny()
                .isPresent();
        System.out.println(result);
        result = data.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(result);
    }

    private static void testPractice4(List<Transaction> data) {
        String result = data.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(n1,n2) -> n1 + n2);
        System.out.println(result);
        result = data.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
    }

    private static void testPractice3(List<Transaction> data) {
        data.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(t -> System.out.println(t));
    }

    private static void testPractice2(List<Transaction> data) {
        data.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(t -> System.out.println(t));

        data.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                // .collect(Collectors.toList())
                .forEach(t -> System.out.println(t));

        // 使用toSet 代替 distinct
        data.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet())
                .forEach(t -> System.out.println(t));
    }

    private static void testPractice1(List<Transaction> data) {
        data.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(t -> System.out.println(t));
        // reversed
        data.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .collect(Collectors.toList())
                .forEach(t -> System.out.println(t));
    }

    private static List<Transaction> buildData() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2011, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }


}

class Trader {
    private final String name;
    private final String city;


    Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
