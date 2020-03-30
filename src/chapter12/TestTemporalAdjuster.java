package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestTemporalAdjuster {

    public static void main(String[] args) {

        test();

    }

    private static void test() {
        LocalDate localDate = LocalDate.of(2014,3,18);
        LocalDate date1 = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date2 = date1.with(TemporalAdjusters.lastDayOfMonth());
        /// Summary at Page 253

        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if(dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            if(dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
    }


}
