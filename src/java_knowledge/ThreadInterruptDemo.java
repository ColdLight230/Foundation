package java_knowledge;

/**
 * 如何中断线程中执行的任务
 */
public class ThreadInterruptDemo {
    public static void main(String[] args) {
        Thread thread = new UninterruptableThread();
        thread.start();
        thread.interrupt();

        Thread thread1 = new InterruptableThread1();
        thread1.start();
        thread1.interrupt();

        InterruptableThread2 thread2 = new InterruptableThread2();
        thread2.start();
        thread2.isInterrupted = true;

        Thread thread3 = new InterruptableThread();
        thread3.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.interrupt();
    }
}

class InterruptableThread extends Thread {
    @Override
    public void run() {
        try {
            // sleep系统方法，只能通过thread.interrupt()来中断
            sleep(5000);
            System.out.println("completed");
        } catch (InterruptedException e) {
            System.out.println("interrupted...");
        }
    }
}

class UninterruptableThread extends Thread {
    @Override
    public void run() {
        // 未做线程 isInterrupted 判断，执行了thread.interrupt()后仍然会继续执行
        for (int i = 0; i < 100000; i++) {
            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }
    }
}

class InterruptableThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            // 判断线程 isInterrupted 结束线程中的任务，然后线程会自己结束
            if (isInterrupted()){
                return;
            }
            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }
    }
}

class InterruptableThread2 extends Thread {
    volatile boolean isInterrupted = false;
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            // 通过自己添加 boolean标志位 来结束线程中的任务 需要用volatile修饰
            if (isInterrupted){
                return;
            }
            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }
    }
}
