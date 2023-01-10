package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.Input.ReviewDtoInput;
import com.example.peerexchange.Dtos.ReviewDto;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import com.example.peerexchange.Models.Review;
import com.example.peerexchange.Repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    // import van de repository in de service in plaats van in de controller
    private final ReviewRepository repos;

    // constructor injection BEST PRACTICE!!!!!!
    public ReviewService(ReviewRepository repos) {this.repos = repos;}


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

    // vertaal methode van ReviewDto naar Review
    public Review transferToReview(ReviewDtoInput dto){
        var review = new Review();

        review.setId(dto.getId());
        review.setStudent_id(dto.getStudent_id());
        review.setSubmission_id(dto.getSubmission_id());
        review.setScore(dto.getScore());
        review.setFeedback(dto.getFeedback());
        review.setTimestamp(dto.getTimestamp());

        return review;
    }

    // vertaal methode van Review naar ReviewDto
    public ReviewDto transferToDto(Review rv){
        ReviewDto dto = new ReviewDto();

        dto.setId(rv.getId());
        dto.setStudent_id(rv.getStudent_id());
        dto.setSubmission_id(rv.getSubmission_id());
        dto.setScore(rv.getScore());
        dto.setFeedback(rv.getFeedback());
        dto.setTimestamp(rv.getTimestamp());

        return dto;
    }

}
