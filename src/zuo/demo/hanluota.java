package zuo.demo;

public class hanluota {
    public static void main(String[] args) {
//        process(64,"左","右","中");
        System.out.println(Float.MIN_VALUE);
    }

    public static void process(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            process(n - 1, from, help, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            process(n - 1, help, to, from);
        }
    }
}
