package ru.nashikhmin.zodiac.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.nashikhmin.zodiac.model.Date;
import ru.nashikhmin.zodiac.model.ZodiacSignResponse;
import ru.nashikhmin.zodiac.utils.ZodiacSignDeterminer;

/**
 * Class that implement a REST Interface for AJAX methods
 */
@RestController
public class RestWebController {
    @RequestMapping(value = "/zodiacSign", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ZodiacSignResponse getZodiacSignByDate(@RequestBody Date date) {
        ZodiacSignDeterminer.ZodiacSign zodiacSign = ZodiacSignDeterminer.getSignByDate(date);
        return new ZodiacSignResponse(zodiacSign);
    }
}
