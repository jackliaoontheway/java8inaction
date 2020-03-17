package chapter2;

import java.util.Arrays;
import java.util.List;

public class InAction {

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("red", 100d), new Apple("green", 150d), new Apple("red", 299d));

        list.sort((Apple a1, Apple a2) -> a1.weight.compareTo(a2.weight));
        list.sort((Apple a1, Apple a2) -> {
            return a1.weight.compareTo(a2.weight);
        });

        Thread t = new Thread(() -> System.out.print("go"));
    }


}
