package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeTest {
    public static void main(String[] arg){

        System.out.println(getFriendlyTimeSpanByNow(1514736000000L));
        System.out.println(getFriendlyTimeSpanByNow(1512057600000L));
    }

    public static final String FORMAT_DATE = "yyyy年MM月dd日 HH:mm";
    public static final String FORMAT_DATE_THIS_YEAR = "MM月dd日 HH:mm";

    /**
     * 获取友好型与当前时间的差
     *
     * @param millis 毫秒时间戳
     * @return 友好型与当前时间的
     * 今天内则显示聊天的具体时间，如“ 16：14 ”
     * 非今天内则显示聊天的月、日，如“ 3月22日  16：14 ”
     * 非今年内则显示聊天的年、月、日，如：“ 2017年3月22日  16：14 ”
     */
    public static String getFriendlyTimeSpanByNow(final long millis) {
        long now = System.currentTimeMillis();
        long span = now - millis;
        // 获取当天 00:00
        long wee = getWeeOfToday();
        // 获取当年 1月1号 00：00
        long firstWee = getFirstWeeOfThisYear();
        if (millis >= wee) {
            return String.format("%tR", millis);
        } else if (millis >= firstWee) {
            Date date = new Date(millis);
            SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_THIS_YEAR, Locale.getDefault());
            return sdf.format(date);
        } else {
            Date date = new Date(millis);
            SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE, Locale.getDefault());
            return sdf.format(date);
        }
    }

    // 获取当天 00:00
    private static long getWeeOfToday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    // 获取当年 1月1号 00：00
    private static long getFirstWeeOfThisYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
}
