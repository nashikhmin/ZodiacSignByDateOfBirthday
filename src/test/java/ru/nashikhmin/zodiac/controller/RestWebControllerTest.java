package ru.nashikhmin.zodiac.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.nashikhmin.zodiac.model.Date;
import ru.nashikhmin.zodiac.utils.ZodiacSignDeterminer;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class RestWebControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(new RestWebController()).build();
    }

    @Test
    public void getZodiacSignByDateTest() throws Exception {
        Date date = new Date(2, 2);

        String json = date.toString();
        mockMvc.perform(post("/zodiacSign").contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.zodiacSign", is(ZodiacSignDeterminer.ZodiacSign.AQUARIUS.toString())))
                .andExpect(jsonPath("$.status", is("DONE")));
    }
}