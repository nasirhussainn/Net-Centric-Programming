package Lecture_9;

public class Thread2 implements Runnable {

    public class PrintNumbers {
        static public void printNumbers() {
            for(int i=0; i<1000; i++) {
                System.out.println(
                        Thread.currentThread().getId() +
                                ": " + i);
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Thread2 ThreadId: " + 				Thread.currentThread().getId());
        // do our thing
        PrintNumbers.printNumbers();
    }

    static public void main(String[] args) {
        System.out.println("Main ThreadId: " + 					Thread.currentThread().getId());
        for(int i=0; i<3; i++) {
            new Thread(new Thread2()).start();
            // again, don't call run!
            // (if you want a separate thread)
        }
        PrintNumbers.printNumbers();
    }

}

