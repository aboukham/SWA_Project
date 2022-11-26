package com.example.ReviewService.Service;

import com.example.ReviewService.Domain.Review;
import com.example.ReviewService.Integration.EventSender;
import com.example.ReviewService.Repository.ReviewRepository;
import com.example.ReviewService.Service.Dto.ReviewAdapter;
import com.example.ReviewService.Service.Dto.ReviewDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    EventSender eventSender;

    public void addReview(ReviewDto reviewDto, String isbn){
        Review review = ReviewAdapter.getReview(reviewDto);
        review.setIsbn(isbn);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String reviewString = objectMapper.writeValueAsString(review);
            eventSender.send("add-review", reviewString);
            System.out.println(reviewRepository.save(review));
        }catch (Exception e){
            e.printStackTrace();
        }
        reviewRepository.save(review);
    }
}
