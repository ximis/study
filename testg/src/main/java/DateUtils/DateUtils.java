package DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static String getDayOfWeek() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("");

        Date date = new Date();
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//        dateFormat.set
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        System.out.println(getDayOfWeek());
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);


    }
}
