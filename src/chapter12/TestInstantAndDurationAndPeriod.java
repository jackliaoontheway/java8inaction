package chapter12;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TestInstantAndDurationAndPeriod {

    public static void main(String[] args) {
        testInstant();
        testDuration();
        testPeriod();
    }

    /**
     * Period 主要用于以date的长短，所以不能仅向between传递一个LocalDate
     */
    private static void testPeriod() {
        LocalDate date = LocalDate.of(2020, 03, 30);
        LocalTime time = LocalTime.of(07, 43);
        LocalDateTime localDateTime0 = LocalDateTime.of(
                date, time
        );
        LocalDateTime  localDateTime1 = LocalDateTime.of(2020, 03, 30, 07, 50);
        Period period = Period.between(date,localDateTime1.toLocalDate());
        System.out.println(period.getDays());

        Duration.ofMinutes(3);
        Duration.of(3, ChronoUnit.MINUTES);

        Period.ofDays(10);
        Period.ofWeeks(3);
        Period.of(2,6,1);

    }

    /**
     * Duration 主要用于以秒和纳秒衡量时间的长短，所以不能仅向between传递一个LocalDate
     * LocalDateTime 和 Instant 不可混用
     */
    private static void testDuration() {
        LocalTime localTime1 = LocalTime.of(7, 38);
        LocalTime localTime2 = LocalTime.of(7, 40);
        Duration d1 = Duration.between(localTime1, localTime2);
        System.out.println(d1.getSeconds());

        LocalDate date = LocalDate.of(2020, 03, 30);
        LocalTime time = LocalTime.of(07, 43);
        LocalDateTime localDateTime0 = LocalDateTime.of(
                date, time
        );
        LocalDateTime  localDateTime1 = LocalDateTime.of(2020, 03, 30, 07, 43);
        Duration d2 = Duration.between(localDateTime0, localDateTime1);
        System.out.println(d2.getSeconds());

        // date 没有 seconds
        // Duration d3 = Duration.between(date,date); // java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds

        Duration d4 = Duration.between(date.atTime(time),time.atDate(date));
        System.out.println(d4.getSeconds());
    }

    private static void testInstant() {

        Instant.ofEpochSecond(3);

    }


}
