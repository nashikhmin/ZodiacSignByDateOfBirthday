package ru.nashikhmin.zodiac.model;

import ru.nashikhmin.zodiac.utils.ZodiacSignDeterminer;

public class ZodiacSignResponse {
    public ZodiacSignResponse() {
    }

    public ZodiacSignResponse(ZodiacSignDeterminer.ZodiacSign zodiacSign) {
        this.zodiacSign = zodiacSign;
        this.status = "DONE";
    }

    private ZodiacSignDeterminer.ZodiacSign zodiacSign;
    private String status;

    public ZodiacSignDeterminer.ZodiacSign getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(ZodiacSignDeterminer.ZodiacSign zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
