package de.fmantz.hannover.dates;

import java.time.*;

public class ZonedDateTimeDiffs {

    public static void main(String[] args) {
        dateDiffsForSomeSpecificYears(ZoneId.of("Europe/Oslo"));
        dateDiffsForSomeSpecificYears(ZoneId.of("Europe/Helsinki")); //Finland changed timzone in 1921
    }

    /**
     * Calculate and print the time difference between 1st and 2nd of May from year 1915 until 1925
     *
     * @param zoneId TimeZoneId
     */
    private static void dateDiffsForSomeSpecificYears(ZoneId zoneId) {
        System.out.println("Timezone is:" + zoneId);
        for (int year = 1915, month = 5, day = 1; year < 1925; year++) {
            ZonedDateTime zdt1 = ZonedDateTime.of(
                    year, month, day, 0, 0, 0, 0, zoneId
            );
            ZonedDateTime zdt2 = ZonedDateTime.of(
                    year, month, day + 1, 0, 0, 0, 0, zoneId
            );
            Duration diff = Duration.between(zdt1, zdt2);
            System.out.println("year=" + year + " diff=" + diff);
        }
        System.out.println();
    }

}
