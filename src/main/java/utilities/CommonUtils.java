package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CommonUtils {
    public static String getEmailRandom(){
        Random rand = new Random();
        return "john.brown" + rand.nextInt(99999) + "@gmail.com";
    }

    public static int getNumberRandom(){
        Random rand = new Random();
        return rand.nextInt(999);
    }

    public static String getCurrentDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }
}
