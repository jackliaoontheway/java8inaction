package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class Version4 {


    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple("red", 100d), new Apple("green", 150d), new Apple("red", 299d));

        //(Apple apple) -> "green".equals(apple.color) 这句话本质上代替了 version3 的匿名类
        // ApplePredicate 只能有一个 Apple apple 的参数方法 如果有多个会出现multiple nonoverride
        // 返回值要和 ApplePredicate 一致
        filterApples(inventory, (Apple apple) -> "green".equals(apple.color));
        filterApples(inventory, apple -> "green".equals(apple.color));
        int i = 10;
        filterApples(inventory, (Apple apple) -> {
            String a = "green";
            int x = i; // error
            //i = 100;
            return a == "green";
        });
        // i = 100;
        inventory.sort((a1,a2) -> a1.weight.compareTo(a2.weight));
        inventory.sort(comparing(Apple::getWeight));
        inventory.sort(comparing(Apple::getWeight));

        List<String> strings = Arrays.asList("a","c","b","d");
        strings.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
        strings.sort(String::compareToIgnoreCase);


        Function<Integer,Integer> f = x -> x + 1;
        Function<Integer,Integer> g = x -> x * 1;
        Function<Integer,Integer> h = f.andThen(g);
        int result = h.apply(1); // 先执行f 然后将f的结果作为 g的参数

        Function<Integer,Integer> j = f.compose(g);
         result = j.apply(1); // 先执行g 然后将g的结果作为 f的参数
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {

        }
        return result;
    }
}
