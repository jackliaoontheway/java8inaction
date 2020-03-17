package chapter2;

import java.util.ArrayList;
import java.util.List;

public class Version1 {

    public List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.color)) {
                result.add(apple);
            }
        }
        return result;
    }

    // ============>> 将color 参数化
    public List<Apple> filterAppleByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.color)) {
                result.add(apple);
            }
        }
        return result;
    }

    // ============>> 增加weight 判断
    public List<Apple> filterAppleByWeight(List<Apple> inventory, Double weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.weight > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    // ============>> 使用flag 标识要用哪个属性来判断
    public List<Apple> filterByCriteria(List<Apple> inventory, String color, Double weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && color.equals(apple.color)) ||
                    (!flag && apple.weight > weight)
            ) {
                result.add(apple);
            }
        }
        return result;
    }

}
