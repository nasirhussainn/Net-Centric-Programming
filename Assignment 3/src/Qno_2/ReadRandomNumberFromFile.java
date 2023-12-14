package Qno_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadRandomNumberFromFile {

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

    public static void main(String[] args) {

        String fileName = "random_numbers.txt";

        List<Double> numbersList = readNumbersFromFile(fileName);

        if (numbersList != null) {
            Double[] numbersArray = numbersList.toArray(new Double[0]);
            System.out.println("Numbers read from file and stored in an array:");
            for (Double number : numbersArray) {
                System.out.println(number);
            }
        } else {
            System.out.println("Failed to read numbers from file.");
        }


    }
}
