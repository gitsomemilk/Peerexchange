package com.example.peerexchange.Controllers;

import com.example.peerexchange.Dtos.Input.ReviewDtoInput;
import com.example.peerexchange.Dtos.Input.SubmissionDtoInput;
import com.example.peerexchange.Dtos.ReviewDto;
import com.example.peerexchange.Dtos.SubmissionDto;
import com.example.peerexchange.Services.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("submission")
public class SubmissionController {

    private final SubmissionService submissionService;


    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    ///---------------Mapping Blok--------------------\\\\\\\


    // ophalen van alle submissions
    @GetMapping("/all")
    public ResponseEntity<List<SubmissionDto>> getAllSubmissions(){
        List<SubmissionDto> dtos;
        dtos = submissionService.getAllSubmissions();

        return ResponseEntity.ok().body(dtos);
    }
    // ophalen van een submission op basis van id
    @GetMapping("/{id}")
    public ResponseEntity<SubmissionDto> getSubmissionById(@PathVariable("id") Long id) {

        SubmissionDto submission = submissionService.getSubmissionById(id);

        return ResponseEntity.ok().body(submission);
    }

    // het plaatsen van een submission door middel van de inputDto submission
    @PostMapping("")
    public ResponseEntity<SubmissionDto> addSubmission(@RequestBody SubmissionDtoInput submissionDtoInput ){

        SubmissionDto dto = submissionService.addSubmission(submissionDtoInput);

        return ResponseEntity.created(null).body(dto);
    }
    // verwijderen van een submission door middel van id
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSubmission(@PathVariable Long id) {

        submissionService.deleteSubmission(id);

        return ResponseEntity.noContent().build();
    }

}
