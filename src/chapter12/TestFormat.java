package chapter12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class TestFormat {
    public static void main(String[] args) {
        testDateTimeFormat();
    }

    private static void testDateTimeFormat() {
        // DateTimeFormatter 是线程安全的
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(s1);
        System.out.println(s2);

        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.CHINA);

        DateTimeFormatter formatter3 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.CHINA);



    }


}
