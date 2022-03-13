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
class GameControllerTest
{

    @Autowired
    WebApplicationContext webApplicationContext;


    //GET
    @Test
    public void getAllGames() throws Exception
    {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/game/getall";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
    //GET
    @Test
    public void getGame() throws Exception
    {

    }
    //POST
    @Test
    public void joinGame() throws Exception
    {

    }
    //POST
    @Test
    public void createGame() throws Exception
    {
        Map<String,String> jsonMap = new HashMap<>();
        jsonMap.put("playerName","username");
        String json = new ObjectMapper().writeValueAsString(jsonMap);

        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/game/create";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

}
