package com.example.peerexchange.Controllers;

import com.example.peerexchange.Dtos.Input.ReviewDtoInput;
import com.example.peerexchange.Dtos.ReviewDto;
import com.example.peerexchange.Services.ReviewService;
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
    // verwijderen van een review door middel van id
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReview(@PathVariable Long id) {

        reviewService.deleteReview(id);

        return ResponseEntity.noContent().build();
    }

}
