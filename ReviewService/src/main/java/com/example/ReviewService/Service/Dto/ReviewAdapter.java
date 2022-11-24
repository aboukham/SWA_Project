package com.example.ReviewService.Service.Dto;

import com.example.ReviewService.Domain.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewAdapter {
    public static Review getReview(ReviewDto reviewDto){
        Review review = new Review("", reviewDto.getRating(), reviewDto.getCustomerName(), reviewDto.getDescription());
        return review;
    }

    public static ReviewDto getReviewDto(Review review){
        ReviewDto reviewDto = new ReviewDto( review.getRating(), review.getCustomerName(), review.getDescription());
        return reviewDto;
    }
}
