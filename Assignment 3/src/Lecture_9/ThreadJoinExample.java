package Lecture_9;

public class ThreadJoinExample implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("This is message #" + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("I'm about to stop");
                return;
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadJoinExample());
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            // do nothing
        }
        System.out.println("I'm " + Thread.currentThread().getName());
    }
}
