package chapter8;

public class TestValidator {
    public static void main(String[] args) {
        // 策略模式使用 Lambda表达式来代替策略的实现类
        Validator numbericValidator = new Validator((s -> s.matches("[a-z]+")));
        numbericValidator.validate("aaa");

        Validator lowerCaseValidator = new Validator((s -> s.matches("\\d+")));
        lowerCaseValidator.validate("aaa");
    }
}
