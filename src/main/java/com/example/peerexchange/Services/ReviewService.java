package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.Input.ReviewDtoInput;
import com.example.peerexchange.Dtos.ReviewDto;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import com.example.peerexchange.Models.Review;
import com.example.peerexchange.Models.Submission;
import com.example.peerexchange.Models.User;
import com.example.peerexchange.Repositories.ReviewRepository;
import com.example.peerexchange.Repositories.SubmissionRepository;
import com.example.peerexchange.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    // import van de repository in de service in plaats van in de controller
    private final ReviewRepository repos;
    private final SubmissionRepository submissionRepos;
    private final UserRepository userRepository;

    // constructor injection BEST PRACTICE!!!!!!
    public ReviewService(ReviewRepository repos, SubmissionRepository submissionRepos,
                         UserRepository userRepository) {
        this.repos = repos;
        this.submissionRepos = submissionRepos;
        this.userRepository = userRepository;
    }


    // alle reviews ophalen
    public List<ReviewDto> getAllReviews(){

        List<Review> reviewList = repos.findAll();
        List<ReviewDto> reviewDtoList= new ArrayList<>();

        for (Review rv : reviewList){
            ReviewDto dto = transferToDto(rv);
            reviewDtoList.add(dto);
        }
        return reviewDtoList;
    }

    // een specifieke review ophalen door middel van id
    public ReviewDto getReviewById(Long id){
        Optional<Review> reviewOptional = repos.findById(id);

        if (reviewOptional.isPresent()){
            Review rv = reviewOptional.get();
            return transferToDto(rv);
        }else {
            throw new RecordNotFoundException("geen review gevonden met dat ID nummer");
        }
    }

    // een review aanmaken met de inputdto Review
    public ReviewDto addReview(ReviewDtoInput dto){
        Review rv = transferToReview(dto);
        repos.save(rv);

        return transferToDto(rv);
    }

    // een review deleten
    public void deleteReview(@RequestBody Long id){

        repos.deleteById(id);
    }

    // een review toevoegen aan een Submission
    public void addReviewToSubmission(Long reviewId , Long submissionId) {
        Optional<Review> optionalReview = repos.findById(reviewId);
        Optional<Submission> optionalSubmission = submissionRepos.findById(submissionId);

        if (optionalReview.isPresent() && optionalSubmission.isPresent()){
            Review review = optionalReview.get();
            Submission submission = optionalSubmission.get();

            review.setSubmission(submission);
            repos.save(review);

        } else {
            throw new RecordNotFoundException("Review or Submission not found");
        }
    }

    // een student User toevoegen aan een review
    public void addStudentToReview(Long reviewId , String studentId){
        Optional<Review> optionalReview = repos.findById(reviewId);
        Optional<User> optionalUser = userRepository.findById(studentId);

        if (optionalReview.isPresent() && optionalUser.isPresent()) {
            Review review = optionalReview.get();
            User student = optionalUser.get();

            review.setStudent(student);
            repos.save(review);
        }else {
            throw new RecordNotFoundException("Review of student not found");
        }
    }




    // vertaal methode van ReviewDto naar Review
    public Review transferToReview(ReviewDtoInput dto){
        var review = new Review();

        review.setId(dto.getId());
        review.setScore(dto.getScore());
        review.setFeedback(dto.getFeedback());
        review.setTimestamp(dto.getTimestamp());
        review.setSubmission(dto.getSubmission());
        review.setStudent(dto.getStudent());

        return review;
    }

    // vertaal methode van Review naar ReviewDto
    public ReviewDto transferToDto(Review rv){
        ReviewDto dto = new ReviewDto();

        dto.setId(rv.getId());
        dto.setScore(rv.getScore());
        dto.setFeedback(rv.getFeedback());
        dto.setTimestamp(rv.getTimestamp());
        dto.setSubmission(rv.getSubmission());
        dto.setStudent(rv.getStudent());

        return dto;
    }

}
