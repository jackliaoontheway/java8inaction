package chapter6;

import chapter5.Trader;
import chapter5.Transaction;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.partitioningBy;

public class TestPartition {

    public static void main(String[] args) {
        List<Transaction> data = buildData();
        testPartitioningBy(data);
    }

    private static void testPartitioningBy(List<Transaction> data) {
        data.stream().collect(partitioningBy(t -> t.getCurrency().equals("USD")));
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
