package com.example.peerexchange.controllers;

import com.example.peerexchange.Controllers.AssignmentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AssignmentController.class)
@ContextConfiguration(classes = AssignmentController.class)
public class AssignmentControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetAllAssignments() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/assignments/all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        assertEquals("[]", result.getResponse().getContentAsString());
    }


}
