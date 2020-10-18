package com.acme.homehealthy.domain.service;

import com.acme.homehealthy.domain.model.SubscriptionDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SubscriptionDetailsService {
    Page<SubscriptionDetails> getAllSubscriptionDetails(Pageable pageable);
    SubscriptionDetails getSubscriptionDetailsById(Long id);
    SubscriptionDetails createSubscriptionDetails(SubscriptionDetails subscriptionDetails);
    SubscriptionDetails updateSubscriptionDetails(Long id, SubscriptionDetails subscriptionDetails);
    ResponseEntity<?> deleteSubscriptionDetails(Long id);
}
