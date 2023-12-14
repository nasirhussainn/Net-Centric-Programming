package Qno_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinValuePerformanceComparison {

    public static void main(String[] args) {
        String fileName = "random_numbers.txt";
        List<Double> numbersList = readNumbersFromFile(fileName);

        if (numbersList != null && !numbersList.isEmpty()) {
            Double[] numbersArray = numbersList.toArray(new Double[0]);

            long startSequential = System.nanoTime();
            double minFromSequential = findMinSequential(numbersArray);
            long endSequential = System.nanoTime();
            long timeSequential = endSequential - startSequential;

            long startMultiThread = System.nanoTime();
            double minFromMultiThread = findMinMultiThread(numbersArray);
            long endMultiThread = System.nanoTime();
            long timeMultiThread = endMultiThread - startMultiThread;

            System.out.println("Minimum value found using sequential approach: " + minFromSequential);
            System.out.println("Time taken for sequential approach: " + timeSequential + " nanoseconds");

            System.out.println("Minimum value found using multi-threading: " + minFromMultiThread);
            System.out.println("Time taken for multi-threading: " + timeMultiThread + " nanoseconds");
        } else {
            System.out.println("Failed to read numbers from file or the list is empty.");
        }
    }

    private static List<Double> readNumbersFromFile(String fileName) {
        List<Double> numbersList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double number = Double.parseDouble(line);
                numbersList.add(number);
            }
            return numbersList;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return null;
        }
    }

    private static double findMinSequential(Double[] numbersArray) {
        double min = Double.MAX_VALUE;
        for (double number : numbersArray) {
            min = Math.min(min, number);
        }
        return min;
    }

    private static double findMinMultiThread(Double[] numbersArray) {
        int threadCount = 5;
        int segmentSize = numbersArray.length / threadCount;
        MinValueThread[] threads = new MinValueThread[threadCount];

        double min = Double.MAX_VALUE;

        for (int i = 0; i < threadCount; i++) {
            int start = i * segmentSize;
            int end = (i == threadCount - 1) ? numbersArray.length : start + segmentSize;
            threads[i] = new MinValueThread(numbersArray, start, end);
            threads[i].start();
        }

        for (MinValueThread thread : threads) {
            try {
                thread.join();
                min = Math.min(min, thread.getMinValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return min;
    }
}

class MinValueThreads extends Thread {
    private final Double[] numbersArray;
    private final int start;
    private final int end;
    private double minValue = Double.MAX_VALUE;

    public MinValueThreads(Double[] numbersArray, int start, int end) {
        this.numbersArray = numbersArray;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            minValue = Math.min(minValue, numbersArray[i]);
        }
    }

    public double getMinValue() {
        return minValue;
    }
}

