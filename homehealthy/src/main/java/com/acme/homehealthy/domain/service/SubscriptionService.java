package com.acme.homehealthy.domain.service;

import com.acme.homehealthy.domain.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SubscriptionService {
    Page<Subscription> getAllSubscription(Pageable pageable);
    Subscription getSubscriptionByID(Long id);
    Subscription createSubscription(Subscription subscriptionDetails);
    Subscription updateSubscription(Long id, Subscription subscriptionDetails);
    ResponseEntity<?> deleteSubscriptionById(Long id);
}
