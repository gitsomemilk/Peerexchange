package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.AssignmentDto;
import com.example.peerexchange.Dtos.Input.AssignmentDtoInput;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import com.example.peerexchange.Models.Assignment;
import com.example.peerexchange.Models.Submission;
import com.example.peerexchange.Repositories.AssignmentRepository;
import com.example.peerexchange.Repositories.SubmissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    // import van de repository in de service in plaats van in de controller
    private final AssignmentRepository repos;
    private final SubmissionRepository submissionRepos;

    // constructor injection BEST PRACTICE!!!!!!
    public AssignmentService(AssignmentRepository repos, SubmissionRepository submissionRepos) {
        this.repos = repos;
        this.submissionRepos = submissionRepos;
    }


    // alle opdrachten op hallen
    public List<AssignmentDto> getAllAssignments() {

        List<Assignment> assignmentList = repos.findAll();
        List<AssignmentDto> assignmentListDto = new ArrayList<>();

        for (Assignment am : assignmentList) {
            AssignmentDto dto = transferToDto(am);
            assignmentListDto.add(dto);
        }
        return assignmentListDto;


    }

    // een specifieke opdracht ophalen door middel van een id
    public AssignmentDto getAssignmentById(Long id) {
        Optional<Assignment> assignmentOptional = repos.findById(id);
        if (assignmentOptional.isPresent()) {
            Assignment am = assignmentOptional.get();
            return transferToDto(am);
        } else {
            throw new RecordNotFoundException("geen opdracht gevonden met dat ID nummer");
        }
    }

    // een opdracht aanmaken met de inputDto assignment
    public AssignmentDto addAssignment(AssignmentDtoInput dto) {
        Assignment am = transferToAssignment(dto);
        repos.save(am);

        return transferToDto(am);

    }

    // deleten van een opdracht
    public void deleteAssignment(@RequestBody Long id) {

        repos.deleteById(id);
    }

    // toevoegen van een submission aan een Assignment
    public void addSubmissionToAssignment(Long id, Long submissionId) {
        Optional<Assignment> assignmentOptional = repos.findById(id);
        Optional<Submission> submissionOptional = submissionRepos.findById(submissionId);
        if (assignmentOptional.isPresent() && submissionOptional.isPresent()) {
            Assignment assignment = assignmentOptional.get();
            Submission submission = submissionOptional.get();
            submission.setAssignment(assignment);
            submissionRepos.save(submission);
        } else {
            throw new RecordNotFoundException();
        }

    }


    // vertaal methode van AssignmentDto naar Assignment
    public Assignment transferToAssignment(AssignmentDtoInput dto) {

        var assignment = new Assignment();

        assignment.setId(dto.getId());
        assignment.setTitle(dto.getTitle());
        assignment.setDescription(dto.getDescription());
        assignment.setDeadline(dto.getDeadline());
        assignment.setClasses(dto.getClasses());
        assignment.setAddon(dto.getAddon());


        return assignment;

    }

    // de vertaal methode van Assignment naar AssignmentDto
    public AssignmentDto transferToDto(Assignment am) {
        AssignmentDto dto = new AssignmentDto();

        dto.setId(am.getId());
        dto.setTitle(am.getTitle());
        dto.setDescription(am.getDescription());
        dto.setDeadline(am.getDeadline());
        dto.setSubmissions(am.getSubmissions());
        dto.setClasses(am.getClasses());
        dto.setAddon(am.getAddon());

        return dto;
    }

}
