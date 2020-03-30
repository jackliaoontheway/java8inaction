package chapter12;

import java.time.*;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;
import java.util.TimeZone;

public class TestZoneId {

    public static void main(String[] args) {
        testZoneId();
        testOtherCalendar();
    }

    private static void testOtherCalendar() {
        LocalDate date1 = LocalDate.of(2020, 03, 18);
        ThaiBuddhistDate date2 = ThaiBuddhistDate.from(date1);

        MinguoDate minguoDate = MinguoDate.now();
        System.out.print(minguoDate);

        //JapaneseDate
        //HijrahDate
    }

    private static void testZoneId() {
        ZoneId romeZone = ZoneId.of("Europe/Rome");

        // 将旧的TimeZone 转为 ZoneId
        ZoneId zoneId = TimeZone.getDefault().toZoneId();

        LocalDate date1 = LocalDate.of(2020, 03, 18);
        ZonedDateTime zdt1 = date1.atStartOfDay(romeZone);

        LocalDateTime dateTime = LocalDateTime.of(2020, 03, 18, 13, 45
        );
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);

        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

    }


}
