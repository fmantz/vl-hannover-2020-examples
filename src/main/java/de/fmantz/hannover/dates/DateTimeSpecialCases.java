package de.fmantz.hannover.dates;

import net.time4j.*;
import net.time4j.format.expert.ChronoFormatter;
import net.time4j.format.expert.PatternType;
import net.time4j.history.ChronoHistory;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Examples taken from https://github.com/MenoData/Time4J
 * The standard Java libraries cannot handle all special cases
 */
public class DateTimeSpecialCases {
    public static void main(String... args) {

        //Schaltsekunden werden benutzt um die langsamere Erdrotation auszugleichen
        //https://de.wikipedia.org/wiki/Schaltsekunde

        // How does last UTC-leapsecond look like in Japan?
        Moment leapsecondUTC =
                PlainDate.of(2012, Month.JUNE, 30)
                        .at(PlainTime.midnightAtEndOfDay()) // 2012-06-30T24 => 2012-07-01T00
                        .atUTC().minus(1, SI.SECONDS);
        System.out.println(leapsecondUTC); // 2012-06-30T23:59:60Z

        //Historisch gab es den 30. Februar 1712 in Schweden
        //https://de.wikipedia.org/wiki/30._Februar

        // following code requires v4.20 (or later) and Java-8 using java.time.LocalDate
        ChronoFormatter<LocalDate> formatter2 =
                ChronoFormatter.setUp(PlainDate.threeten(), new Locale("en", "SE"))
                        .addPattern("GGGG yyyy, MMMM ", PatternType.CLDR)
                        .addEnglishOrdinal(ChronoHistory.ofSweden().dayOfMonth())
                        .build();
        System.out.println(formatter2.format(LocalDate.of(1712, 3, 11)));
        // output: Anno Domini 1712, February 30th
    }
}
