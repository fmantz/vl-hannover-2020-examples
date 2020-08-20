package de.fmantz.hannover.numbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Example summing double numbers
 */
public class NumberSums {

    public static void main(String[] args) throws Exception {

        //Die Summenbildung ist oft leicht unterschiedlich, wenn die
        //Reihenfolge der Zahlen sich ändert:
        String path = NumberSums.class.getResource("/").toURI().getPath();
        double sum1 = sumNumbers(path + "/numbers1.txt");
        double sum2 = sumNumbers(path + "/numbers2.txt");
        System.out.println("sum1= " + sum1 + "\nsum2= " + sum2);

        //Bei gleicher Reihenfolgen sind die Summen dagegen gleich:
        double sum1b = orderAndSumNumbers(path + "/numbers1.txt");
        double sum2b = orderAndSumNumbers(path + "/numbers2.txt");
        System.out.println("sum1b=" + sum1b + "\nsum2b=" + sum2b);

    }

    /**
     * Read a file that is containing a double value per line
     * and sums these numbers according to the given order
     */
    private static double sumNumbers(String fileName) throws IOException {
        return readFile(fileName).stream().reduce(0d, Double::sum);
    }

    /**
     * Read a file that is containing a double value per line
     * and sums these numbers in ascending order
     */
    private static double orderAndSumNumbers(String fileName) throws IOException {
        ArrayList<Double> numbers = readFile(fileName);
        Collections.sort(numbers);
        return numbers.stream().reduce(0d, Double::sum);
    }

    /**
     * Read a file that is containing a double value per line
     */
    private static ArrayList<Double> readFile(String fileName) throws IOException {
        ArrayList<Double> rs = new ArrayList<>();
        try (BufferedReader myReader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = myReader.readLine()) != null) {
                rs.add(Double.parseDouble(line));
            }
            return rs;
        }
    }
}
