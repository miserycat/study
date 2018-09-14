package baeldung.java8.dateapi;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class CompatibilityOldDateAndCalendar {
    public static void main(String[] args) {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        Calendar calendar = Calendar.getInstance();
        localDateTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());


        /*
            For organization that are on the path of moving to Java 8 from Java 7 or Java 6 and want to use date and time API,
            project threeten provides the backport capability.
            Developers can use classes available in this project to achieve the same functionality as that of new Java 8 Date and Time API and once they move to Java 8, the packages can be switched
            <dependency>
                <groupId>org.threeten</groupId>
                <artifactId>threetenbp</artifactId>
                <version>1.3.1</version>
            </dependency>

            Another alternative for Java 8 Date and Time library is Joda-Time library.
            In fact Java 8 Date Time APIs has been led jointly by the author of Joda-Time library (Stephen Colebourne) and Oracle.
            This library provides pretty much all capabilities that is supported in Java 8 Date Time project.
            The Artifact can be found in the maven central by including the below pom dependency in your project:
            <dependency>
                <groupId>joda-time</groupId>
                <artifactId>joda-time</artifactId>
                <version>2.9.4</version>
            </dependency>

         */
    }
}
