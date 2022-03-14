package com.chess.chessbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
class AuthControllerTest
{

    @Autowired
    WebApplicationContext webApplicationContext;

    //POST
    @Test
    public void singUp() throws Exception
    {
        // RUNNING SECOND TIME WILL GET ERROR BECAUSE USERNAME EXISTS
        Map<String,String> jsonMap = new HashMap<>();
        jsonMap.put("username","username55d"); //JSON VALUES FROM API REQUEST
        jsonMap.put("password","password");
        String json = new ObjectMapper().writeValueAsString(jsonMap);

        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/auth/signup"; // API URL
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
    //SIGN IN
    @Test
    public void signIn() throws Exception
    {
        Map<String,String> jsonMap = new HashMap<>();
        jsonMap.put("username","username1"); //JSON VALUES FROM API REQUEST
        jsonMap.put("password","password");
        String json = new ObjectMapper().writeValueAsString(jsonMap);

        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/auth/signin"; // API URL
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

}
