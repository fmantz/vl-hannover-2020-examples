package de.fmantz.hannover.strings;

import java.util.Locale;

/**
 * toUpper does not work in Turkey as expected!
 */
public class TurkeyTest {

    private static final String MAIL = "MAIL";

    public static void main(String[] args) {

        String x = "mail";

        //Server eingestellt auf "deutsch" würde wie erwartet arbeiten:
        Locale.setDefault(new Locale("de", "DE"));
        checkMail(x);

        //Server eingestellt auf "türkisch" nicht:
        Locale.setDefault(new Locale("tr", "TR"));
        checkMail(x);

    }

    /**
     * Check if you got mail ;-)
     */
    private static void checkMail(String eventName) {
        System.out.println(eventName.toUpperCase());
        if (eventName.toUpperCase().equals(MAIL)) {
            System.out.println("You got email...");
        } else {
            System.out.println("You got *NO* email...");
        }
    }

}
