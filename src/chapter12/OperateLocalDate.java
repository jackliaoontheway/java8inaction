package chapter12;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class OperateLocalDate {

    public static void main(String[] args) {
        testWithAttribute();
        testOtherMethod();
    }

    private static void testOtherMethod() {
        LocalDate localDate = LocalDate.of(2020, 03, 31);
        LocalDate date1 = localDate.plusWeeks(1);
        LocalDate date2 = date1.plusYears(1);
        LocalDate date3 = date2.plus(6, ChronoUnit.MONTHS);
    }

    private static void testWithAttribute() {
        LocalDate localDate = LocalDate.of(2020, 03, 31);
        LocalDate date1 = localDate.withYear(2021);
        LocalDate date2 = date1.withDayOfMonth(04);
        LocalDate date3 = date2.with(ChronoField.MONTH_OF_YEAR, 9);
    }


}
