package ru.nashikhmin.zodiac.utils;

import org.junit.Test;
import ru.nashikhmin.zodiac.model.Date;

import static org.junit.Assert.assertEquals;

public class ZodiacSignDeterminerTest {
    @Test
    public void firstZodiacSignTest() throws Exception {
        Date date = new Date(2, 2);
        assertEquals(ZodiacSignDeterminer.ZodiacSign.AQUARIUS, ZodiacSignDeterminer.getSignByDate(date));
    }

    @Test
    public void lastZodiacSignTest() throws Exception {
        Date date = new Date(1, 1);
        assertEquals(ZodiacSignDeterminer.ZodiacSign.CAPRICORN, ZodiacSignDeterminer.getSignByDate(date));
    }

    @Test
    public void middleZodiacSignTest() throws Exception {
        Date date = new Date(1, 9);
        assertEquals(ZodiacSignDeterminer.ZodiacSign.VIRGO, ZodiacSignDeterminer.getSignByDate(date));
    }
}