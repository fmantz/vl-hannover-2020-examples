package de.fmantz.hannover.numbers;

import java.util.Random;

public class NumberExamples {

    private static final double ZERO_POINT_THREE = 0.3;

    public static void main(String[] args) {
        compareNumberExample();
        sumNumberExample();
        notANumberExample();
    }

    /**
     * Numbers are difficult to compare
     */
    private static void compareNumberExample() {
        System.out.println("compareNumberExample():");
        double x = 0.29999999999999997;

        if (x == ZERO_POINT_THREE) {
            //Beide Literale sind nah genug an der gleichen
            //internen Double-Darstellung die weder
            //exakt 0.3 ist noch exakt 0.29999999999999997 ist:
            System.out.println("Korrekt!");
        } else {
            System.out.println("Warum bin ich hier?");
        }

        if (0.4 - 0.3 == 0.1) {
            System.out.println("Das Ergebnis ist:" + 0.1);
        } else {
            //Double Literale ergeben intern selten
            //exakte Zahlen:
            System.out.println("Keine Ahnung!");
        }
    }

    /**
     * Number sums may be unexpected
     */
    private static void sumNumberExample() {
        System.out.println("sumNumberExample():");
        double total = 0d;

        //Erwartetes Ergebnis, da das Zahlenliteral
        //einfach auf die binäre Gleitkommadarstellung
        //abgebildet werden kann:
        for (int i = 0; i < 100; i++) {
            total += 0.5;
            System.out.println(total);
        }
        //das ist meist anders:
        total = 0d;
        for (int i = 0; i < 100; i++) {
            total += 0.6;
            System.out.println(total);
        }

        double[] array = new double[1000];
        Random rnd = new java.util.Random(2);
        for (int i = 0; i < array.length; i++) {
            array[i] = 1d / Math.max(1L , Math.abs(rnd.nextInt())); //dummy Zahlen
        }

        //Die Ergebnisse können auf euren Computern gleich sein, müssen aber nicht:
        //https://en.wikipedia.org/wiki/Strictfp
        //Allerdings ist es heute so, dass auf fast allen
        //modernen PCs der IEEE754 standard automatisch verwendet wird!
        System.out.println(sum(array) + "\n" + sumStrictFp(array));
    }

    /**
     * Add sum numbers according to your processors precision
     * i.e. numbers are always rounded to 64bit at the end of the calculation
     */
    static double sum(double[] array) {
        double rs = 0d;
        for (double v : array) {
            rs += v;
        }
        return rs;
    }

    /**
     * Sum three numbers according to IEEE754 standard
     * i.e. numbers are always rounded to 64bit
     */
    static strictfp double sumStrictFp(double[] array) {
        double rs = 0d;
        for (double v : array) {
            rs += v;
        }
        return rs;
    }

    /**
     * "Not a number" comparisons examples
     */
    private static void notANumberExample() {
        System.out.println("notANumberExample():");

        System.out.println("Gleitkommadivision durch Null: " + 1d / 0); //Infinity bekommt man z.B. bei einer Gleitkommadivision durch Null
        double quotient = Double.NEGATIVE_INFINITY / Double.POSITIVE_INFINITY; //Bei der Weiterverarbeitung kommt es zu NaN (Not A Number)
        System.out.println(quotient);

        //NaNs lassen sich nicht direkt vergleichen,
        //obwohl sie Gleitkommazahlen sind:
        if (quotient == Double.NaN) {
            System.out.println("Keine Zahl");
        } else {
            System.out.println("Schöne Zahl: " + quotient);
        }

        //So vergleicht man auf "Not a Number":
        if (Double.isNaN(quotient)) {
            System.out.println("Keine Zahl");
        } else {
            System.out.println("Schöne Zahl: " + quotient);
        }

        Double a = Double.valueOf(Double.NaN);
        Double b = Double.valueOf(Double.NaN);

        System.out.println("== " +  (Double.NaN == Double.NaN)); //"double" NaN - Werte lassen sich nicht vergleichen!
        System.out.println("equals " + a.equals(b)); //"Boxed" Double NaN Werte aber schon
    }

}
