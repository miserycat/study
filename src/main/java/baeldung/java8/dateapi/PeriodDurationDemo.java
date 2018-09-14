package baeldung.java8.dateapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDurationDemo {
    public static void main(String[] args) {

        //The Period class is widely used to modify values of given a date or to obtain the difference between two dates:
        LocalDate initialDate = LocalDate.parse("2007-05-10");

        LocalDate finalDate = initialDate.plus(Period.ofDays(5));

        System.out.println(finalDate);

        int five = Period.between(finalDate, initialDate).getDays();

        //Similar to Period, the Duration class is use to deal with Time.
        //In the following code we create a LocalTime of 6:30 am and then add a duration of 30 seconds to make a LocalTime of 06:30:30am:
        LocalTime initialTime = LocalTime.of(6, 30, 6);

        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));

        //The Duration between two instants can be obtained either as a Duration or as a specific unit.
        //In the first code snippet we use the between() method of the Duration class to find the time difference between finalTime and initialTime and return the difference in seconds:
        long thirty = Duration.between(initialTime, finalTime).getSeconds();

        System.out.println(thirty);

        //In the second example we use the between() method of the ChronoUnit class to perform the same operation:
        thirty = ChronoUnit.SECONDS.between(initialTime, finalTime);

        System.out.println(thirty);




    }
}
