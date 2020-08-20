package de.fmantz.hannover.numbers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Generates list of 'seeded' random numbers
 * and writes them to a file
 * Helper for: "NumberSums"
 */
public class NumberGenerator {

    private static final int NumberCount = 10000;

    public static void main(String[] args) {
        Random rnd = new Random(1L);
        ArrayList<Double> arrayList = new ArrayList<>(NumberCount);

        for(int i = 0; i < NumberCount; i++){
            arrayList.add(Math.abs(rnd.nextDouble()));
        }

        printFirst10Elements(arrayList);
        writeFile(arrayList, "numbers1.txt");

        //Permutate:
        Collections.shuffle(arrayList, rnd);

        printFirst10Elements(arrayList);
        writeFile(arrayList, "numbers2.txt");
    }

    /**
     * Show first 10 elements of list:
     */
    private static void printFirst10Elements(ArrayList<Double> arrayList) {
        System.out.println("\nFirst 10 Elements:");
        for(int i=0; i < 10; i++){
            System.out.println(arrayList.get(i));
        }
    }

    /**
     * Writes each double number in a new line of a text file
     * @param arrayList of double values to write
     * @param fileName of the file to create
     */
    private static void writeFile(ArrayList<Double> arrayList, String fileName){
        try (PrintWriter myWriter = new PrintWriter(fileName)){ //auto-close streams!
            for(double d : arrayList){
                myWriter.println(d);
            }
            System.out.println("Successfully wrote to the file: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Failed to write the file: " + fileName);
            e.printStackTrace();
        }
    }
}
