package com.yuan.wordladder;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void logInWithValidUser() throws Exception {
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder
                login = formLogin()
                .user("user")
                .password("123456");
        mockMvc.perform(login)
                .andExpect(authenticated().withUsername("user"));
    }

    @Test
    public void logInWithInvalidUser() throws Exception{
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder
                login = formLogin()
                .user("user")
                .password("invalid");
        mockMvc.perform(login)
                .andExpect(unauthenticated());
    }

    @Test
    public void accessSecuredResourceUnauthenticatedThenRedirectsToLogin() throws Exception{
        mockMvc.perform(get("http://localhost:8080/hello"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/authentication/require"));

        mockMvc.perform(get("http://localhost:8080/index"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/authentication/require"));

        mockMvc.perform(get("http://localhost:8080/abcdefg"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/authentication/require"));
    }

    @Test
    @WithMockUser
    public void accessSecuredResourceAuthenticatedThenOk() throws Exception {
        mockMvc.perform(get("http://localhost:8080/login.html"))
                .andExpect(status().isOk());
    }
}
