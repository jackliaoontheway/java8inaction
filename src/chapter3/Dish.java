package chapter3;

public class Dish {
    private String name;
    private double calories;
    private boolean vegetarian;
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public CaloricLevel getCaloricLevel() {
        if (getCalories() < 400) {
            return CaloricLevel.LOW;
        }
        if (getCalories() > 400 && getCalories() < 800) {
            return CaloricLevel.LOW;
        }
        return CaloricLevel.HIGH;
    }
}
