package chapter4;

import chapter3.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class TestFilterDistinct {

    public static void main(String[] args) {
        processByJDK8();
    }

    static void processByJDK8() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 2, 1, 3, 4, 5);
        List<Integer> result = numbers.stream()
                .filter(d -> d > 1)
                .distinct()
                .limit(3)
                .collect(toList());
        System.out.print(result);

        System.out.println();

        numbers.stream()
                .filter(d -> d > 1)
                .distinct()
                .skip(3)  // skip 和 limit 互补
                .forEach(System.out::print);

        System.out.println();

        numbers.stream()
                .filter(d -> d > 1)
                .distinct()
                .forEach(System.out::print);
    }
}
