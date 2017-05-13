package ru.nashikhmin.zodiac.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.nashikhmin.zodiac.model.Date;
import ru.nashikhmin.zodiac.utils.ZodiacSignDeterminer;

/**
 * Class that implement a REST Interface for AJAX methods
 */
@RestController
public class RestWebController {
    @RequestMapping(value = "/zodiacSign", method = RequestMethod.POST)
    public String getZodiacSignByDate(@RequestBody Date date) {
        return ZodiacSignDeterminer.getSignByDate(date).toString();
    }
}
