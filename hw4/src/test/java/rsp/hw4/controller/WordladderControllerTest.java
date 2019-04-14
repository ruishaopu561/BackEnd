package rsp.hw4.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import rsp.hw4.wordLadder.Wordladder;

import javax.print.attribute.standard.Media;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ContextConfiguration(classes = WordladderController.class)
public class WordladderControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void ladderTest() throws Exception {
        Wordladder wl = new Wordladder();

        String output = mvc.perform(get("/ladder")
                .param("b", "cat")
                .param("e", "dog")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals(output, wl.ss("cat", "dog"));

        output = mvc.perform(get("/ladder")
                .param("b","happy")
                .param("e","steop")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals(output, wl.ss("happy", "steop"));
    }
}