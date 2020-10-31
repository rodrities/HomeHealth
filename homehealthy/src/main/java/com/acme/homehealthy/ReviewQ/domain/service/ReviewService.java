package com.acme.homehealthy.ReviewQ.domain.service;



import com.acme.homehealthy.ReviewQ.domain.model.Review;
import org.springframework.http.ResponseEntity;

public interface ReviewService {
    Review getReviewById(Long id);

    Review createReview(Review Review);

    Review updateReview(Long id, Review Review);

    ResponseEntity<?> deleteReview(String name);
}
