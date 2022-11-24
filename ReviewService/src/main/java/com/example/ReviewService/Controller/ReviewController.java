package com.example.ReviewService.Controller;

import com.example.ReviewService.Service.Dto.ReviewDto;
import com.example.ReviewService.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ReviewController {
    @Autowired
    ReviewService   reviewService;

    @PostMapping("/reviews/{isbn}")
    public ResponseEntity<?> add(@RequestBody ReviewDto reviewDto, @PathVariable String isbn){
        reviewService.addReview(reviewDto, isbn);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }
}
