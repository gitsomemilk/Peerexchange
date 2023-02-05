package com.example.peerexchange.controllers;

import com.example.peerexchange.Controllers.ClassController;
import com.example.peerexchange.Dtos.ClassDto;
import com.example.peerexchange.Filter.JwtRequestFilter;
import com.example.peerexchange.Services.ClassService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ClassController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ClassControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClassService classService;

    @MockBean
    JwtRequestFilter jwtRequestFilter;

    @Test
    public void getClassById_ShouldReturnClassDto() throws Exception {
        ClassDto classdto = new ClassDto();
        classdto.setId(1L);
        classdto.setName("Class 1");

        when(classService.getClassById(1L)).thenReturn(classdto);

        mockMvc.perform(get("/{id}", 1))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$.id", is(String.valueOf(1))))
                .andExpect((ResultMatcher) jsonPath("$.name", is("Class 1")));
    }

    private Object is(String s) {
        return null;
    }
}
