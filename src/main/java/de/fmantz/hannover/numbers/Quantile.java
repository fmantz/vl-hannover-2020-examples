package de.fmantz.hannover.numbers;

public class Quantile {

    /**
     * Calculates the quantile index of an sorted array (WITH BUG)
     * @param arraySize number of elements in the sorted array
     * @param quantile percent number 0 < qunatile <= 1
     */
    static int calculateQuantileIndex(int arraySize, double quantile){
        return (int) Math.ceil(arraySize * quantile) - 1;
    }

    /**
     * Calculates the quantile index of an sorted array (corrected version 1)
     * @param arraySize number of elements in the sorted array
     * @param quantile percent number 0 < quantile <= 1
     * Note: works until arraysize 10000
     */
    static int calculateQuantileIndexCorrected(int arraySize, double quantile){
        double eps = 1E-10;
        int maxArraySize = 10000000;
        if(arraySize > maxArraySize) {
            throw new IllegalArgumentException("ArraySize is > " + maxArraySize);
        }
        return (int) Math.ceil(arraySize * quantile - eps) - 1;
    }

    /**
     * Calculates the quantile index of an sorted array (corrected version 2)
     * @param arraySize number of elements in the sorted array
     * @param quantile percent number 0 < quantile <= 1
     */
    static int calculateQuantileIndexCorrected2(int arraySize, double quantile){
        return (int) Math.nextUp(arraySize * quantile) - 1;
    }

    /**
     * Shows example index calculations for an sorted array of 50 numbers.
     */
    public static void main(String[] args) {
        final int arraySize = 50;
        final double percent = 0.02; //= 1d / arraySize
        for(int i = 1; i <= 50; i++){
            final double curPercentage = percent * i;
            final int v1 = calculateQuantileIndex(arraySize, curPercentage);
            final int v2 = calculateQuantileIndexCorrected(arraySize, curPercentage);
            final int v3 = calculateQuantileIndexCorrected2(arraySize, curPercentage);
            if(v1 != v2 || v1 != v3) System.out.print("Check this out>");
            System.out.println(String.format("%f  %2d %2d %2d", curPercentage, v1, v2, v3));
        }
    }

}
