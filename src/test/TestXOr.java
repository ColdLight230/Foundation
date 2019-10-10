package test;

public class TestXOr {
    public static void main(String[] args) {
        boolean changed = false;

        System.out.println(" isChanged: " + (changed ^ false ^ false));
        System.out.println(" isChanged: " + (changed ^ true ^ false));
        System.out.println(" isChanged: " + (changed ^ false ^ true));
        System.out.println(" isChanged: " + (changed ^ true ^ true));
    }
}
