package com.pramati.lnr.mvc;

import com.pramati.lnr.mvc.model.User;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class UserTests {

    static
    {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);
        rootLogger.addAppender(new ConsoleAppender(
                new PatternLayout("%-6r [%p] %c - %m%n")));
    }

    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/users"))
                .andExpect(status().isOk());

        System.out.println(resultActions.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void testGetUsersList() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.addHeader("Accept", "application/json");
        response.setHeader("Accept", "application/json");

        request.setMethod("GET");
        request.setContentType("application/json");
        request.setRequestURI("/users");

        //final ModelAndView mav = handle(request, response);
        String responseStr = response.getContentAsString();

        System.out.println("response: " + responseStr);
        //assertNotNull(response);
    }


    @Test
    public void testPostUser() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.addHeader("Accept", "application/json");
        response.setHeader("Accept", "application/json");

        request.setMethod("POST");
        request.setContentType("application/json");
        request.setRequestURI("/users/addBody");
        /*User user;
        request.setContent(user);*/

        //final ModelAndView mav = handle(request, response);
        String responseStr = response.getContentAsString();

        System.out.println("response: " + responseStr);
        //assertNotNull(response);
    }


    @Test
    public void getUserDetails() throws Exception {
        ResultActions resultActions = null;

        resultActions = mockMvc.perform(get("/users/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.firstName", is("Narendra")))
                .andExpect(jsonPath("$.lastName", is("Reddy Lingam")))
                .andExpect(jsonPath("$.email", is("lingam.reddy@gmail.com")))
                .andExpect(jsonPath("$.telephone", is("9989320602")))
        ;

        System.out.println("########################getUserDetails#############################");
        System.out.println(resultActions.andReturn().getRequest().toString());
        System.out.println(resultActions.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void listUsers() throws Exception {
        ResultActions resultActions = null;

        resultActions = mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].firstName", is("Narendra")))
                .andExpect(jsonPath("$[0].lastName", is("Reddy Lingam")))
                .andExpect(jsonPath("$[0].email", is("lingam.reddy@gmail.com")))
                .andExpect(jsonPath("$[0].telephone", is("9989320602")))
        ;

        System.out.println("########################listUsers#############################");
        System.out.println(resultActions.andReturn().getRequest().toString());
        System.out.println(resultActions.andReturn().getResponse().getContentAsString());
    }

    /*@Test
    public void deleteUser() throws Exception {
        ResultActions resultActions = null;

        resultActions = mockMvc.perform(delete("/users/13"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        ;

        System.out.println("########################simplePost#############################");
        System.out.println(resultActions.andReturn().getRequest().toString());
        System.out.println(resultActions.andReturn().getResponse().getContentAsString());
    }     */
}
