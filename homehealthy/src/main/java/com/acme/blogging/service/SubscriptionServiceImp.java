package com.acme.blogging.service;

import com.acme.blogging.domain.model.Subscription;
import com.acme.blogging.domain.repository.SubscriptionRepository;
import com.acme.blogging.domain.service.SubscriptionService;
import com.acme.blogging.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImp implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Page<Subscription> getAllSubscription(Pageable pageable) {
        return subscriptionRepository.findAll(pageable);
    }

    @Override
    public Subscription getSubscriptionByID(Long id) {
        return subscriptionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subscription","Id",id));
    }

    @Override
    public Subscription createSubscription(Subscription subscriptionDetails) {
        return subscriptionRepository.save(subscriptionDetails);
    }

    @Override
    public Subscription updateSubscription(Long id, Subscription subscriptionDetails) {
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subscription","Id",id));
        return subscriptionRepository.save(subscription.setName(subscriptionDetails.getName())
        .setCost(subscriptionDetails.getCost()));
    }

    @Override
    public ResponseEntity<?> deleteSubscriptionById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subscription","Id",id));
        subscriptionRepository.delete(subscription);
        return ResponseEntity.ok().build();
    }
}
