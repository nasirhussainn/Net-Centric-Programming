package Lecture_9;

public class ThreadInterruptExample implements Runnable {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("This is message #" + i);
            try {
                Thread.sleep(2000);
                continue;
            } catch (InterruptedException ex) {
                System.out.println("I'm resumed");
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadInterruptExample());
        t1.start();
        try {
            Thread.sleep(5000);
            t1.interrupt();
        } catch (InterruptedException ex) {
            // do nothing
        }

    }
}

