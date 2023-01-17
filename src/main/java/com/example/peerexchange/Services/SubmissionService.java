package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.Input.SubmissionDtoInput;
import com.example.peerexchange.Dtos.SubmissionDto;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import com.example.peerexchange.Models.Submission;
import com.example.peerexchange.Repositories.SubmissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {
    // import van de repository in de service in plaats van in de controller
private final SubmissionRepository repos;

    // constructor injection BEST PRACTICE!!!!!!
    public SubmissionService(SubmissionRepository repos) {
        this.repos = repos;
    }

    // alle ingeleverde opdrachten ophalen
    public List<SubmissionDto> getAllSubmissions(){

        List<Submission> submissionList = repos.findAll();
        List<SubmissionDto> submissionDtoList = new ArrayList<>();

        for (Submission sm : submissionList) {
            SubmissionDto dto = transferToDto(sm);
            submissionDtoList.add(dto);
        }
        return submissionDtoList;
    }

    // een specifieke submission ophalen door middel van een id

    public SubmissionDto getSubmissionById(Long id){
        Optional<Submission> submissionOptional = repos.findById(id);
        if (submissionOptional.isPresent()) {
            Submission sm = submissionOptional.get();
            return transferToDto(sm);
        }else {
            throw new RecordNotFoundException("geen ingeleverde opdracht gevonden met dat ID nummer");
        }
    }

    // een submission aanmaken met de inputDto van Submission
    public SubmissionDto addSubmission(SubmissionDtoInput dto){
        Submission sm = transferToSubmission(dto);
        repos.save(sm);

        return transferToDto(sm);

    }

    // deleten van een submission
    public void deleteSubmission(@RequestBody Long id){

        repos.deleteById(id);
    }

    // vertaal methode van SubmissionDto naar Submission
    public Submission transferToSubmission(SubmissionDtoInput dto){

        var submission = new Submission();

        submission.setId(dto.getId());
        submission.setFile(dto.getFile());
        submission.setTimestamp(dto.getTimestamp());
        submission.setAssignment(dto.getAssignment());
        submission.setStudent(dto.getStudent());
        submission.setReviews(dto.getReviews());

        return submission;
    }

    // vertaal methode van Submission naar SubmissionDto
    public SubmissionDto transferToDto(Submission sm){
        SubmissionDto dto = new SubmissionDto();

        dto.setId(sm.getId());
        dto.setFile(sm.getFile());
        dto.setTimestamp(sm.getTimestamp());
        dto.setAssignment(sm.getAssignment());
        dto.setStudent(sm.getStudent());
        dto.setReviews(sm.getReviews());

        return dto;
    }

}
