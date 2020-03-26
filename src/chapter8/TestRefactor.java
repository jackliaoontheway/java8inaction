package chapter8;

import chapter2.Apple;
import chapter3.CaloricLevel;
import chapter3.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class TestRefactor {

    public static void main(String[] args) {
        testRunnable();
        ;
        testOverride();

        testMethodRef1(null);
        testMethodRef2(null);
    }

    private static void testMethodRef2(List<Apple> list) {
        list.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        // ===>>
        list.sort(Comparator.comparing(Apple::getWeight));
    }

    private static void testMethodRef1(List<Dish> list) {
        Map<CaloricLevel, List<Dish>> map = list.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() < 400) {
                        return CaloricLevel.LOW;
                    }
                    if (dish.getCalories() > 400 && dish.getCalories() < 800) {
                        return CaloricLevel.LOW;
                    }
                    return CaloricLevel.HIGH;
                }));
        // ===>> refactor
        Map<CaloricLevel, List<Dish>> map2 = list.stream()
                .collect(groupingBy(Dish::getCaloricLevel));

        double totalCalories = list.stream()
                .map(Dish::getCalories)
                .reduce(0d, (c1, c2) -> c1 + c2);
        // ===>> refactor
        totalCalories = list.stream()
                .collect(summingDouble(Dish::getCalories));
    }

    private static void testOverride() {
        doSomething(new Runnable() {
            @Override
            public void run() {
                System.out.println("OK");
            }
        });

        // 如果有重载的情况，需要做显示的类型转换(Task)
        doSomething((Task) () -> System.out.println("Danger danger"));
    }

    static void testRunnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        Runnable runnable1 = () -> System.out.println("Hello");
    }

    static void doSomething(Runnable run) {
        run.run();
    }

    static void doSomething(Task task) {
        task.execute();
    }
}
