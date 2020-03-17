package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Version3 {

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("red", 100d), new Apple("green", 150d), new Apple("red", 299d));

        filterApples(list, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.color.equals("green");
            }
        });

        filterApples(list, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.weight > 150;
            }
        });
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
