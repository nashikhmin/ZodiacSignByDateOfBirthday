package ru.nashikhmin.zodiac.utils;

import ru.nashikhmin.zodiac.model.Date;

/**
 * This class allows to get zodiac sign by date
 */
public class ZodiacSignDeterminer {
    public enum ZodiacSign {
        AQUARIUS(new Date(20, 1), new Date(18, 2)),
        PISCES(new Date(19, 2), new Date(20, 3)),
        ARIES(new Date(21, 3), new Date(19, 4)),
        TAURUS(new Date(20, 4), new Date(20, 5)),
        GEMINI(new Date(21, 5), new Date(20, 6)),
        CANCER(new Date(21, 6), new Date(22, 7)),
        LEO(new Date(23, 7), new Date(22, 8)),
        VIRGO(new Date(23, 8), new Date(22, 9)),
        LIBRA(new Date(23, 9), new Date(22, 10)),
        SCORPIO(new Date(23, 10), new Date(21, 11)),
        SAGITTARIUS(new Date(22, 11), new Date(21, 12)),
        CAPRICORN(new Date(22, 12), new Date(19, 1));

        ZodiacSign(Date begin, Date end) {
            this.begin = begin;
            this.end = end;
        }

        private Date begin, end;

        public Date getBegin() {
            return begin;
        }

        public Date getEnd() {
            return end;
        }
    }

    public static ZodiacSign getSignByDate(Date date) {
        for (ZodiacSign zodiacSign : ZodiacSign.values()) {
            if (zodiacSign.getBegin().compareTo(date) < 0 && zodiacSign.getEnd().compareTo(date) > 0) {
                return zodiacSign;
            }
        }
        //otherwise select CAPRICORN because it stay at border of years
        return ZodiacSign.CAPRICORN;
    }
}
