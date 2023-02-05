package com.example.peerexchange.Controllers;

import com.example.peerexchange.Dtos.AssignmentDto;
import com.example.peerexchange.Dtos.Input.AssignmentDtoInput;
import com.example.peerexchange.Services.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    // importeren van de AssignmentService
    private final AssignmentService assignmentService;

    // Constructor injection best practice !!
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }


    ///---------------Mapping Blok--------------------\\\\\\\

    // ophalen van alle Assignments
    @GetMapping("/all")
    public ResponseEntity<List<AssignmentDto>> getAllAssignments() {
        List<AssignmentDto> dtos;
        dtos = assignmentService.getAllAssignments();

        return ResponseEntity.ok().body(dtos);
    }

    // ophalen van een Assignment op basis van id
    @GetMapping("/{id}")
    public ResponseEntity<AssignmentDto> getAssignmentById(@PathVariable("id") Long id) {

        AssignmentDto assignment = assignmentService.getAssignmentById(id);

        return ResponseEntity.ok().body(assignment);
    }

    // plaatsen van een Assignment door middel van de InputDto van Assignment Reminder -> (zorg dat de JSON object exact overeenkomt met het Assignment object!!!)
    @PostMapping("")
    public ResponseEntity<AssignmentDto> addAssignment(@RequestBody AssignmentDtoInput assignmentDtoInput) {

        AssignmentDto dto = assignmentService.addAssignment(assignmentDtoInput);

        return ResponseEntity.created(null).body(dto);

    }

    // het toevoegen van een Submission aan een Assignment
    @PostMapping("/{id}/submission")
    public ResponseEntity<String> addSubmissionToAssignment(@PathVariable Long id, @RequestBody Long submissionId) {
        assignmentService.addSubmissionToAssignment(id, submissionId);
        return new ResponseEntity<>("Submission toegevoegd aan de Assignment", HttpStatus.OK);
    }


    // verwijderen van een assignment door middel van id
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAssignment(@PathVariable Long id) {

        assignmentService.deleteAssignment(id);

        return ResponseEntity.noContent().build();
    }


}
