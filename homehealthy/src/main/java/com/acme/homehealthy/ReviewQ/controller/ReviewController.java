package com.acme.homehealthy.ReviewQ.controller;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.ReviewQ.domain.model.Review;
import com.acme.homehealthy.Initialization.domain.service.CustomerService;
import com.acme.homehealthy.ReviewQ.domain.service.ReviewService;
import com.acme.homehealthy.Initialization.resource.CustomerResource;
import com.acme.homehealthy.ReviewQ.resource.ReviewResource;
import com.acme.homehealthy.Initialization.resource.SaveCustomerResource;
import com.acme.homehealthy.ReviewQ.resource.SaveReviewResource;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Review", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class ReviewController {
    @Autowired
    private ReviewService ReviewService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/Review/{ReviewId}")
    public ReviewResource getReviewname(@Valid @PathVariable (value = "ReviewId") Long ReviewId){

        return convertToResource(ReviewService.getReviewById(ReviewId));
    }


    @PostMapping("/Reviews")
    public ReviewResource createReview(@Valid @RequestBody SaveReviewResource resource){
        Review Review = convertToEntity(resource);
        return convertToResource(ReviewService.createReview(Review));
    }

    @PutMapping("/Reviews/{ReviewId}")
    public ReviewResource updateReview( @Valid @PathVariable (value = "ReviewId") Long ReviewId,
                                    @Valid @RequestBody SaveReviewResource resource){
        Review Review = convertToEntity(resource);
        return convertToResource(ReviewService.updateReview(ReviewId,Review));
    }

    @DeleteMapping("/Reviews/{name}")
    public ResponseEntity<?> deleteReview(@Valid @PathVariable (value = "id") long id){
        return  ReviewService.deleteReview(id);
    }

    private ReviewResource convertToResource(Review Review){ return mapper.map(Review, ReviewResource.class); }

    private Review convertToEntity(SaveReviewResource resource){ return mapper.map(resource, Review.class); }


}
