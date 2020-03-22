package chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class TestChapter4 {

    public static void main(String[] args) {
        testDistinctAndLimitAndSkip();
        testMapAndFlatMap();
        testAnyMatchFindAny();
        testReduce();
    }

    static void testDistinctAndLimitAndSkip() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 2, 1, 3, 4, 5);
        List<Integer> result = numbers.stream()
                .filter(d -> d > 1)
                .distinct()
                .limit(3)
                .collect(toList());
        System.out.println(result);
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

    static void testMapAndFlatMap() {
        List<String> strings = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> result = strings.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(result);

        strings = strings.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(strings);

        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(3, 4);

        List<int[]> l3 = l1.stream()
                .flatMap(i -> l2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());
        System.out.println(l3);

        l3 = l1.stream()
                .flatMap(i -> l2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());
        System.out.println(l3);
    }

    static void testAnyMatchFindAny() {
        List<String> strings = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        strings.stream()
                .anyMatch(s -> s.length() < 1);

        List<String> strings2 = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        strings2.stream()
                .filter(s -> s.equals("Action"))
                .findAny()
                .ifPresent(s -> System.out.println(s));
    }

    static void testReduce() {
        List<Integer> l1 = Arrays.asList(2, 3, 4);
        int sum = l1.stream()
                .reduce(0, (i, j) -> i + j);
        System.out.println(sum);
        sum = l1.stream()
                .reduce(1, (i, j) -> i * j);
        System.out.println(sum);
        // 使用方法引用代替 (i,j) -> i + j
        sum = l1.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
        // 没有初始值得重载
        Optional<Integer> os = l1.stream()
                .reduce(Integer::sum);
        System.out.println(os.get());
        // 使用 ifPresent 代替syso
        l1.stream()
                .reduce(Integer::sum)
                .ifPresent(s -> System.out.println(s));
        ;
        // 返回最大值
        l1.stream()
                .reduce(Integer::max)
                .ifPresent(s -> System.out.println(s));
        l1.stream()
                .reduce(Integer::min)
                .ifPresent(s -> System.out.println(s));
        l1.stream()
                .reduce((x, y) -> x < y ? x : y);

        //count
        long count = l1.stream().count();

    }
}
