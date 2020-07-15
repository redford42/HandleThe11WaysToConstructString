package element.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Hanz
 * @date 2020/7/7
 */
public class TestOfJoda {

    public static void main(String[] args) {

        long test1 = new DateTime("20200610").getMillis();
        DateTimeFormatter yyyyMMddHH = DateTimeFormat.forPattern("yyyyMMddHH");
        DateTime dateTime = DateTime.parse("2020061001", yyyyMMddHH);
        System.out.println(dateTime.getMillis());
    }


    public static void eachMonthBetween() {
        long startTime = 1591718400000L;
        long endTime = 1593964800000L;
        List<String> gapList = new ArrayList<>();
        while (startTime <= (endTime + 86400000)) {
            DateTime startDate = new DateTime(startTime);
            String time = startDate.toString("yyyyMMdd");
            gapList.add(time);
            int dayOfMonth = startDate.dayOfMonth().getMaximumValue() - startDate.getDayOfMonth() + 1;
            startTime = startTime + (86400000L * dayOfMonth);
        }
        String lastGap = gapList.get(gapList.size() - 1);
        String lastTime = new DateTime((endTime + 86400000)).toString("yyyyMMdd");
        if (!lastGap.equals(lastTime)) {
            gapList.add(lastTime);
        }

        System.out.println(gapList.toString());
    }

    public static void eachWeekBetween() {
        long startTime = 1591718400000L;
        long endTime = 1593964800000L;
        List<String> gapList = new ArrayList<>();
        while (startTime <= (endTime + 86400000)) {
            DateTime startDate = new DateTime(startTime);
            String time = startDate.toString("yyyyMMdd");
            gapList.add(time);
            int dayOfWeek = 8 - startDate.getDayOfWeek();
            startTime += 86400000 * dayOfWeek;
        }
        String lastGap = gapList.get(gapList.size() - 1);
        String lastTime = new DateTime((endTime + 86400000)).toString("yyyyMMdd");
        if (!lastGap.equals(lastTime)) {
            gapList.add(lastTime);
        }

        System.out.println(gapList.toString());
    }
}
