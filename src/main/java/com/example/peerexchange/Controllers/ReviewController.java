package com.example.peerexchange.Controllers;

import com.example.peerexchange.Dtos.Input.ReviewDtoInput;
import com.example.peerexchange.Dtos.ReviewDto;
import com.example.peerexchange.Models.Review;
import com.example.peerexchange.Models.Submission;
import com.example.peerexchange.Services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
public class ReviewController {

    // import van de ReviewService
    private final ReviewService reviewService;

    // constructor injection best practice
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    ///---------------Mapping Blok--------------------\\\\\\\

    // ophalen van alle reviews
    @GetMapping("/all")
    public ResponseEntity<List<ReviewDto>> getAllReviews(){
        List<ReviewDto> dtos;
        dtos = reviewService.getAllReviews();

        return ResponseEntity.ok().body(dtos);
    }
    // ophalen van een review op basis van id
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable ("id") Long id) {

        ReviewDto review = reviewService.getReviewById(id);

        return ResponseEntity.ok().body(review);
    }

    // het plaatsen van een review door middel van de inputDto Review
    @PostMapping("")
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDtoInput reviewDtoInput ){

        ReviewDto dto = reviewService.addReview(reviewDtoInput);

        return ResponseEntity.created(null).body(dto);
    }

    // het plaatsen van een review bij een submission
    @PostMapping("/{reviewId}/submission")
    public ResponseEntity<String> addReviewToSubmission(@PathVariable Long reviewId, @RequestBody Long submissionId){
     reviewService.addReviewToSubmission(reviewId,submissionId);
       return new ResponseEntity<>("Review toegevoegd aan de Submission", HttpStatus.OK);
    }

    // het koppelen van een student bij een review
    @PostMapping("/{id}/student")
    public ResponseEntity<String> addStudentToReview(@PathVariable Long id, @RequestBody String studentUsername){
        reviewService.addStudentToReview(id, studentUsername);
        return new ResponseEntity<>("Student toegevoegd aan de review",HttpStatus.OK);
    }

    // verwijderen van een review door middel van id
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReview(@PathVariable Long id) {

        reviewService.deleteReview(id);

        return ResponseEntity.noContent().build();
    }

}
