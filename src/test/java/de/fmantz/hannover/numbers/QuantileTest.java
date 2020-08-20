package de.fmantz.hannover.numbers;

import de.fmantz.hannover.numbers.Quantile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuantileTest {

    private static final int ARRAY_SIZE = 10000000;
    private static final double BUCKET_SIZE = 1d / ARRAY_SIZE;

    /**
     * calculateQuantileIndexCorrected should work correctly in an array of size 10000000
     */
    @Test
    public void testcalculateQuantileIndexCorrected(){
        double q = BUCKET_SIZE;
        for(int i = 0; i < ARRAY_SIZE; i++) {
            double quantile = BUCKET_SIZE * (i + 1); //hier muss man aufpassen, da Gleitkomma-multiplikation!
            assertEquals(Quantile.calculateQuantileIndexCorrected(ARRAY_SIZE, quantile), i);
        }
    }

    /**
     * calculateQuantileIndexCorrected2 should work correctly in an array of size 10000000
     */
    @Test
    public void testcalculateQuantileIndexCorrected2(){
        double q = BUCKET_SIZE;
        for(int i = 0; i < ARRAY_SIZE; i++) {
            double quantile = BUCKET_SIZE * (i + 1); //hier muss man aufpassen, da Gleitkomma-multiplikation!
            assertEquals(Quantile.calculateQuantileIndexCorrected2(ARRAY_SIZE, quantile), i);
        }
    }

}
