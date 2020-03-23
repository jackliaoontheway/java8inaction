package chapter6;

import chapter5.Trader;
import chapter5.Transaction;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class TestReduce {

    public static void main(String[] args) {
        List<Transaction> data = buildData();
        testGroupingBy(data);
        testCounting(data);
        testMaxBy(data);
        testSummingInt(data);
        testAveragingInt(data);
        testSummarizingInt(data);
        testJoining(data);

        //广义的归约汇总
        testReducing(data);
    }

    private static void testReducing(List<Transaction> data) {
        data.stream().collect(reducing(0,Transaction::getValue,(i,j) -> i + j));
        data.stream().collect(reducing(0,Transaction::getValue,Integer::sum));
        data.stream().mapToInt(Transaction::getValue).sum();
    }

    private static void testJoining(List<Transaction> data) {
        String result = data.stream().map(t -> t.getTrader().getName()).collect(joining());
        // 内部使用了 StringBuilder
        System.out.println(result);
        result = data.stream().map(t -> t.getTrader().getName()).collect(joining(", "));
        // 内部使用了 StringBuilder
        System.out.println(result);
    }

    private static void testSummarizingInt(List<Transaction> data) {
        IntSummaryStatistics summary = data.stream().collect(summarizingInt(Transaction::getValue));
        System.out.println(summary);
        //IntSummaryStatistics{count=6, sum=4060, min=300, average=676.666667, max=1000}
    }

    private static void testAveragingInt(List<Transaction> data) {
        double result = data.stream().collect(averagingInt(Transaction::getValue));
        System.out.println(result);
    }

    private static void testSummingInt(List<Transaction> data) {
        int result = data.stream().collect(summingInt(Transaction::getValue));
        System.out.println(result);
    }

    private static void testMaxBy(List<Transaction> data) {
        Optional<Transaction> result = data.stream().collect(maxBy(comparingInt((Transaction::getValue))));
    }

    private static void testCounting(List<Transaction> data) {
        data.stream().count();
        data.stream().collect(counting());
    }

    private static void testGroupingBy(List<Transaction> data) {
        data.stream().collect(groupingBy(Transaction::getCurrency));
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
