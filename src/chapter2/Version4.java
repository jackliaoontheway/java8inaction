package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Version4 {


    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("red", 100d), new Apple("green", 150d), new Apple("red", 299d));

        //(Apple apple) -> "green".equals(apple.color) 这句话本质上代替了 version3 的匿名类
        // ApplePredicate 只能有一个 Apple apple 的参数方法 如果有多个会出现multiple nonoverride
        // 返回值要和 ApplePredicate 一致
        filterApples(list, (Apple apple) -> "green".equals(apple.color));
        filterApples(list, (Apple apple) -> {
            return apple.weight.intValue() > 150;
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
