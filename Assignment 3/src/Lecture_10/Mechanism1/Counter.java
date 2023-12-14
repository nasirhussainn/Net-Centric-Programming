package Lecture_10.Mechanism1;

public class Counter implements Runnable {
    private final App1 mainApp;
    private final int loopLimit;
    public Counter(App1 mainApp, int loopLimit)
    {
        this.mainApp = mainApp;
        this.loopLimit = loopLimit;
    }
    public void run() {
        for(int i=0; i<loopLimit; i++)
        { String threadName = Thread.currentThread().getName();
            System.out.printf("%s: %s%n", threadName, i);
            mainApp.pause(Math.random());
        }
    }
}