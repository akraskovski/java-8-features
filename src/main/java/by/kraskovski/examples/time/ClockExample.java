package by.kraskovski.examples.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ClockExample {

    public static void main(String... args) {
//        getClockAtUTC();
//        getLocalDate();
//        getLocalTime();
//        getLocalDateTime();
//        testChromoUnits();
    }

    private static Clock getClockAtUTC() {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        return clock;
    }

    private static void getLocalDate() {
        final LocalDate localDate = LocalDate.now();
        final LocalDate localDateFromClock = LocalDate.now(getClockAtUTC());

        System.out.println(localDate);
        System.out.println(localDateFromClock);
    }

    private static void getLocalTime() {
        final LocalTime localTime = LocalTime.now();
        final LocalTime localTimeFromClock = LocalTime.now(getClockAtUTC());

        System.out.println(localTime);
        System.out.println(localTimeFromClock);
    }

    private static void getLocalDateTime() {
        final LocalDateTime localDateTime = LocalDateTime.now();
        final LocalDateTime localDateTimeFromClock = LocalDateTime.now(getClockAtUTC());

        System.out.println(localDateTime);
        System.out.println(localDateTimeFromClock);
    }

    private static void testChromoUnits() {
        //Get the current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        //add 1 week to the current date
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeek);

        //add 1 month to the current date
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + nextMonth);

        //add 1 year to the current date
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Next year: " + nextYear);

        //add 10 years to the current date
        LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
        System.out.println("Date after ten year: " + nextDecade);
    }
}
