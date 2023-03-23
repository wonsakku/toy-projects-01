package com.example.toy_01.controller;

import com.example.toy_01.dto.RequestContentDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@AutoConfigureMockMvc
@SpringBootTest
class ContentControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void saveTest() throws Exception {
        mockMvc.perform(
                (MockMvcRequestBuilders.post("/contents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writeToString( new RequestContentDto("테스트 레퍼", "테스트 바디", Arrays.asList(1l, 2l)) ))
                )).andDo(print());

    }



    private <T> String writeToString(T target) throws JsonProcessingException {
        return objectMapper.writeValueAsString(target);
    }


}







