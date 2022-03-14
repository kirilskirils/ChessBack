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
class MoveControllerTest
{

    @Autowired
    WebApplicationContext webApplicationContext;


    //POST
    @Test
    public void makeMove() throws Exception
    {
        Map<String,String> jsonMap = new HashMap<>();
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        jsonMap.put("gameId", "16");
        jsonMap.put("fen", "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        String json = new ObjectMapper().writeValueAsString(jsonMap);

        String uri = "/api/move/makemove";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

}
