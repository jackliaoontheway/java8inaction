package chapter10;

import chapter5.Trader;
import chapter5.Transaction;

import javax.swing.text.html.Option;
import java.util.Optional;

public class TestOptional {

    public static void main(String[] args) {
        //System.out.println(test(new Person()));
        Insurance insurance = new Insurance();
        Car car = new Car();
        Person person = new Person();
        car.setInsurance(Optional.ofNullable(insurance));
        person.setCar(Optional.ofNullable(car)); // 必须要有Optional ， 不然会报NPE
        Optional<Person> personOpt = Optional.of(person);
        System.out.println(testUsingOptional(personOpt));

        testFilter(personOpt);
    }

    private static void testFilter(Optional<Person> personOpt) {
        personOpt.filter(person -> "Jack".equals(person.getName()))
                .ifPresent(x -> System.out.println("hello" + x.getName()));
    }

    public static String testUsingOptional(Optional<Person> person) {
        return person.
                flatMap(Person::getCar).
                flatMap(Car::getInsurance).
                map(Insurance::getName).orElse("Unknown");
    }

    public static String test(Person person) {
       /* if (person != null) {
            Optional<Car> car = person.getCar();
            if (!car.isEmpty()) {
                Insurance insurance = car.get().getInsurance().get();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }*/
        return null;
    }
}
