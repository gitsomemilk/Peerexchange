package com.example.peerexchange.controllers;

import com.example.peerexchange.Controllers.AssignmentController;
import com.example.peerexchange.Dtos.AssignmentDto;
import com.example.peerexchange.Filter.JwtRequestFilter;
import com.example.peerexchange.Services.AssignmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.servlet.MockMvc;;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.io.File;
import java.util.Date;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(AssignmentController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AssignmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssignmentService assignmentService;

    @MockBean
    JwtRequestFilter jwtRequestFilter;



    @Test
    public void GetAssignmentById() throws Exception {
        AssignmentDto assignment = new AssignmentDto();
        assignment.setId(1L);
        assignment.setTitle("titel");
        assignment.setDescription("description");
        assignment.setDeadline(new Date(01-02-2023));
        assignment.setAddon(new File("no"));

        when(assignmentService.getAssignmentById(1L)).thenReturn(assignment);

        mockMvc.perform(get("/1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$.id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$.title", is("titel")))
                .andExpect((ResultMatcher) jsonPath("$.description", is("description")))
                .andExpect((ResultMatcher) jsonPath("$.deadline", is("2023/02/01")))
                .andExpect((ResultMatcher) jsonPath("$.addon", is("no")));

        verify(assignmentService, times(1)).getAssignmentById(1L);
        verifyNoMoreInteractions(assignmentService);
    }

    private AssignmentController verify(AssignmentService assignmentService, ExpectedCount times) {
        return null;
    }

}
