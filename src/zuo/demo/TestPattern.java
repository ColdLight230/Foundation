package zuo.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {
    public static void main(String[] args) {
        String source = "http://baobab.kaiyanapp.com/api/v4/tabs/selected?date=1542762000000&num=21&page=5";
        Pattern compile = Pattern.compile("num=([0-9]+)", Pattern.UNICODE_CASE);
        Pattern compile1 = Pattern.compile("page=([0-9]+)", Pattern.UNICODE_CASE);
        Matcher matcher = compile.matcher(source);
        while (matcher.find()) {
            String num = source.substring(matcher.start() + "num=".length(), matcher.end());
            System.out.println(num);
        }
        Matcher matcher1 = compile1.matcher(source);
        while (matcher1.find()) {
            String num = source.substring(matcher1.start() + "page=".length(), matcher1.end());
            System.out.println(num);
        }
        System.out.println("http://baobab.kaiyanapp.com/api/v4/tabs/selected?date=1542762000000&".length());
    }
}
