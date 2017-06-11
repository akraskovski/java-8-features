package by.kraskovski.examples.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ClockExample {

    public static void main(String... args) {
//        getClockAtUTC();

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
}
