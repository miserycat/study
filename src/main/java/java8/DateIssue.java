package java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shengchao wu on 5/23/2018.
 */
public class DateIssue {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = "2012-12-12";
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() ->{
                try {
                    System.out.println(sdf.parse(dateStr));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }

    }
}
