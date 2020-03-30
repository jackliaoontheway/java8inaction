package chapter12;

import java.time.*;
import java.time.temporal.ChronoField;

public class TestLocalDateAndLocalTime {

    public static void main(String[] args) {
        testLocalDate();
        testLocalTime();
        testLocalDateTime();
    }

    private static void testLocalDateTime() {

        LocalDate date = LocalDate.of(2020, 03, 30);
        LocalTime time = LocalTime.of(07, 43);

        LocalDateTime localDateTime0 = LocalDateTime.of(
                date, time
        );

        LocalDateTime  localDateTime1 = LocalDateTime.of(2020, 03, 30, 07, 43);

        LocalDateTime localDateTime2 = date.atTime(time);
        LocalDateTime localDateTime3 = time.atDate(date);

        LocalDate date1 = localDateTime1.toLocalDate();
        LocalTime time1 = localDateTime1.toLocalTime();

    }

    private static void testLocalTime() {
        LocalTime localTime = LocalTime.of(7, 38);
        int hour = localTime.getHour();
        int minute = localTime.getMinute();

        LocalTime time = LocalTime.parse("07:38");
        System.out.println(time);
    }

    private static void testLocalDate() {
        LocalDate localDate = LocalDate.of(2020, 3, 30);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int len = localDate.lengthOfMonth();
        boolean leap = localDate.isLeapYear();
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(dayOfWeek);
        System.out.println(len);
        System.out.println(leap);

        year = localDate.get(ChronoField.YEAR);
        int monthInt = localDate.get(ChronoField.MONTH_OF_YEAR);
        day = localDate.get(ChronoField.DAY_OF_MONTH);

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate parsedLocalDate = LocalDate.parse("2020-03-30");
        System.out.println(parsedLocalDate);

    }

}
