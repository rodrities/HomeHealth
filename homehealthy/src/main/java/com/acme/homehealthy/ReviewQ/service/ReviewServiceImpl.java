package com.acme.homehealthy.ReviewQ.service;



import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.ReviewQ.domain.model.Review;
import com.acme.homehealthy.ReviewQ.domain.repository.ReviewRepository;
import com.acme.homehealthy.ReviewQ.domain.service.ReviewService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements  ReviewService {

    @Autowired
    private ReviewRepository ReviewRepository;

    @Override
    public Review getReviewById(Long id) {

        return ReviewRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Review","Id",id));
    }



    @Override
    public Review createReview(Review Review) {
        Review existingReview = ReviewRepository.findById(Review.getId()).orElse(null);

        if(existingReview != null){
            throw new ResourceNotFoundException("This Review it was qualified");
        }

        return ReviewRepository.save(Review);
    }
    @Override
    public Review updateReview(Long id, Review Review) {


        Review existingReview = ReviewRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Review","Id",id));

        return ReviewRepository.save(
                existingReview.setName(Review.getName()).setDescription(Review.getDescription()).setdetailrevision(Review.getdetailrevision())

        );
    }
    @Override
    public ResponseEntity<?> deleteReview(long id) {
        Review Review = ReviewRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Review","id",id));
        ReviewRepository.delete(Review);
        return ResponseEntity.ok().build();
    }


}
