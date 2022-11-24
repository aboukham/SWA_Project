package com.example.ReviewService.Service;

import com.example.ReviewService.Domain.Review;
import com.example.ReviewService.Repository.ReviewRepository;
import com.example.ReviewService.Service.Dto.ReviewAdapter;
import com.example.ReviewService.Service.Dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public void addReview(ReviewDto reviewDto, String isbn){
        Review review = ReviewAdapter.getReview(reviewDto);
        review.setIsbn(isbn);
        reviewRepository.save(review);
    }
}
