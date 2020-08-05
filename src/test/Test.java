package test;

public class Test {

    public static void main(String[] args) {
        try {
            new Test().test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void test() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join();
        System.out.println("B");
    }

    private void test1() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                synchronized (this) {
                    Thread.sleep(1000);
                    System.out.println("A");
                    this.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        synchronized (this) {
            this.wait();
            System.out.println("B");
        }
    }
}
