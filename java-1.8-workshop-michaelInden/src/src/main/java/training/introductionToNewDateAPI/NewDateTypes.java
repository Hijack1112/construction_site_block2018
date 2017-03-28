package src.main.java.training.introductionToNewDateAPI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.*;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Hijack
 */
public class NewDateTypes {

    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
        Month may = Month.MAY;

        System.out.println(dayOfWeek.minus(3));
        System.out.println(may.plus(5));

        //TASK: Train departure @2017-04-01 12:30:00, plus 5 minutes delay, Train arrival @2017-04-01 17:15:00, plus 10 minutes delay, print out duration
        Instant departure = Instant.parse("2017-04-01T12:30:00Z");
        departure.plus(10, ChronoUnit.MINUTES);
        Instant arrival = Instant.parse("2017-04-01T17:15:00Z");
        arrival.plus(Duration.ofMinutes(5));

        Duration duration = Duration.between(departure, arrival);
        long durationInHours = ChronoUnit.HOURS.between(departure, arrival);

        System.out.println("durationInHours = " + durationInHours);
        
        //LOCAL DATE
        LocalDate birthDayX = LocalDate.of(1986, Month.MAY, 17);
        LocalDate birthDayY = birthDayX.minusYears(4);
        
        System.out.println("birthDayY = " + birthDayY);
        
        //LOCAL TIME
        LocalTime time = LocalTime.of(15, 30, 11);
        System.out.println("time = " + time);
        time = time.plusHours(5);
        System.out.println("time = " + time);
        
        
        // ThreadSafe
        DateTimeFormatter dateTimeFormatter = ofPattern("dd-MM-yyyy");
        
        //Local Date Time
        LocalDateTime localDateTime = LocalDateTime.now();
        String localDateTimeFormatted = dateTimeFormatter.format(localDateTime);
        
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("localDateTimeFormatted = " + localDateTimeFormatted);
       
    }
}
