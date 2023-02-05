package com.example.peerexchange.controllers;

import com.example.peerexchange.Controllers.UserController;
import com.example.peerexchange.Dtos.UserDto;
import com.example.peerexchange.Filter.JwtRequestFilter;
import com.example.peerexchange.Models.User;
import com.example.peerexchange.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import java.util.List;import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    JwtRequestFilter jwtRequestFilter;

    @MockBean
    private UserService userService;

    // dtos
    UserDto userDto1;
    UserDto userDto2;
    UserDto userDto3;


    @Test
    void getAllUsers() throws Exception {
        given(userService.getUsers()).willReturn(List.of(userDto1, userDto2, userDto3));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("User1"))
                .andExpect(jsonPath("$[0].password").value("password"))
                .andExpect(jsonPath("$[0].b").value(false))
                .andExpect(jsonPath("$[0].apikey").value("apikey1"))
                .andExpect(jsonPath("$[0].s").value("student1@test.nl"))
                .andExpect(jsonPath("$[0].student").value("student1"))
                .andExpect(jsonPath("$[0].test").value("test"))

                .andExpect(jsonPath("$[0].username").value("User2"))
                .andExpect(jsonPath("$[0].password").value("password"))
                .andExpect(jsonPath("$[0].b").value(false))
                .andExpect(jsonPath("$[0].apikey").value("apikey2"))
                .andExpect(jsonPath("$[0].s").value("student2@test.nl"))
                .andExpect(jsonPath("$[0].student").value("student2"))
                .andExpect(jsonPath("$[0].test").value("test"))

                .andExpect(jsonPath("$[0].username").value("User3"))
                .andExpect(jsonPath("$[0].password").value("password"))
                .andExpect(jsonPath("$[0].b").value(true))
                .andExpect(jsonPath("$[0].apikey").value("apikey3"))
                .andExpect(jsonPath("$[0].s").value("student3@test.nl"))
                .andExpect(jsonPath("$[0].student").value("student3"))
                .andExpect(jsonPath("$[0].test").value("test"))
        ;
    }

}

