package chapter6;

import chapter3.Dish;
import chapter5.Trader;
import chapter5.Transaction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class TestGroup {
    public static void main(String[] args) {
        List<Transaction> data = buildData();
        testGroupingBy(data);
        testMultipleGroupingBy(data);
        testGroupingByAndCounting(data);
        testGroupingByAndMaxBy(data);
        testCollectingAndThen(data);
        testGroupingByAndMapping(data);
    }

    private static void testGroupingByAndMapping(List<Transaction> data) {
        data.stream().collect(groupingBy(Transaction::getYear,
                mapping(Transaction::getCurrency, toSet())));

        data.stream().collect(groupingBy(Transaction::getYear,
                mapping(Transaction::getCurrency, toCollection(HashSet::new))));
    }

    private static void testCollectingAndThen(List<Transaction> data) {
        data.stream().collect(groupingBy(Transaction::getYear,
                collectingAndThen(
                        maxBy(comparingInt(Transaction::getValue))
                        , Optional::get)
        ));
    }

    private static void testGroupingByAndMaxBy(List<Transaction> data) {
        data.stream().collect(groupingBy(Transaction::getYear, maxBy(comparingInt(Transaction::getValue))));
        data.stream().collect(groupingBy(Transaction::getYear, summingInt(Transaction::getValue)));
    }

    private static void testGroupingByAndCounting(List<Transaction> data) {
        data.stream().collect(groupingBy(Transaction::getYear, counting()));
    }

    private static void testMultipleGroupingBy(List<Transaction> data) {
        data.stream().collect(groupingBy(Transaction::getYear, groupingBy(Transaction::getCurrency)));
    }

    private static void testGroupingBy(List<Transaction> data) {
        data.stream().collect(groupingBy(Transaction::getCurrency));
        data.stream().collect(
                groupingBy(t -> {
                    if (t.getValue() > 100) {
                        return 0;
                    } else if (t.getValue() > 100 && t.getValue() < 300) {
                        return 1;
                    }
                    return 2;
                }));
    }

    private static List<Transaction> buildData() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, "USD", 300),
                new Transaction(raoul, 2012, "USD", 1000),
                new Transaction(raoul, 2011, "USD", 400),
                new Transaction(mario, 2011, "USD", 710),
                new Transaction(mario, 2012, "CNY", 700),
                new Transaction(alan, 2012, "CNY", 950)
        );
    }
}
