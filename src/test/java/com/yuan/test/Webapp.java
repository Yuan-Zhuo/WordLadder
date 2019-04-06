package com.yuan.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Controller.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Webapp {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void init() {
        System.out.println("测试Webapp层");
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
    }

    @Test
    public void exceptionTesting() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/?word1={str1}&word2={str2}","axz","cat")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.path").value("#word1 error"))
                .andDo(MockMvcResultHandlers.print());

        mvc.perform(MockMvcRequestBuilders.post("/?word1={str1}&word2={str2}","word","zzzz")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.path").value("#word2 error"))
                .andDo(MockMvcResultHandlers.print());

        mvc.perform(MockMvcRequestBuilders.post("/?word1={str1}&word2={str2}","word","cat")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.path").value("#length error"))
                .andDo(MockMvcResultHandlers.print());

        mvc.perform(MockMvcRequestBuilders.post("/?word1={str1}&word2={str2}","spherules", "aasvogels")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.path").value("#no path"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void stringTesting() throws Exception {

        String template = "the path from %s to %s is:\n";

        mvc.perform(MockMvcRequestBuilders.post("/?word1={str1}&word2={str2}","cat", "dog")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.path").value(String.format(template,"dog","cat")+"dog\tdot\tcot\tcat"))
                .andDo(MockMvcResultHandlers.print());
    }

    @After
    public void after() {
        System.out.println("测试结束");
    }
}
