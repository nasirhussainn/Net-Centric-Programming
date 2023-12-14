package Qno_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RandomNumberFileWriter {

    public static void main(String[] args) {
        String fileName = "random_numbers.txt";
        int numbersToGenerate = 1000;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < numbersToGenerate; i++) {
                double randomNumber = Math.random() * 1000;
                writer.write(String.valueOf(randomNumber));
                writer.newLine();
            }
            System.out.println(numbersToGenerate + " random numbers generated and saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

