package chapter7;

import chapter5.Transaction;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TestParallel {

    public static void main(String[] args) {
        // testNormalSum();
        testParallelSum();
    }

    private static void testNormalSum() {

        Long result = Stream.iterate(0L, i -> i + 1)
                .limit(10)
                .reduce(0L, Long::sum);
        System.out.println(result);

        result = Stream.iterate(0L, i -> i + 1)
                .limit(10)
                .collect(reducing(0L, Long::sum));
        System.out.println(result);

        result = Stream.iterate(0L, i -> i + 1)
                .limit(10)
                .collect(summingLong(Long::longValue));
        System.out.println(result);
    }

    private static void testParallelSum() {
        Long result = Stream.iterate(0L, i -> i + 1)
                .limit(10)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(result);

        result = Stream.iterate(0L, i -> i + 1)
                .limit(10)
                .parallel()
                .collect(reducing(0L, Long::sum));
        System.out.println(result);

        result = Stream.iterate(0L, i -> i + 1)
                .limit(10)
                .parallel()
                .collect(summingLong(Long::longValue));
        System.out.println(result);
    }

}
