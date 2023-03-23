package com.example.toy_01.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ClassificationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getClassificationSelectBox() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/classifications/select-box"))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }
}