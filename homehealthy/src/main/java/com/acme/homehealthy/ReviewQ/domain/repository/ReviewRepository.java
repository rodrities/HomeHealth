package com.acme.homehealthy.ReviewQ.domain.repository;



import com.acme.homehealthy.ReviewQ.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;



public interface ReviewRepository extends JpaRepository<Review,Long> {
    Optional<Review>findreviewbyid(String id);

}

