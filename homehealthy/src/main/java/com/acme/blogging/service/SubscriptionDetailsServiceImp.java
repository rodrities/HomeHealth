package com.acme.blogging.service;

import com.acme.blogging.domain.model.SubscriptionDetails;
import com.acme.blogging.domain.repository.SubscriptionDetailsRepository;
import com.acme.blogging.domain.repository.SubscriptionRepository;
import com.acme.blogging.domain.service.SubscriptionDetailsService;
import com.acme.blogging.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionDetailsServiceImp implements SubscriptionDetailsService {

    @Autowired
    private SubscriptionDetailsRepository subscriptionDetailsRepository;

    @Override
    public Page<SubscriptionDetails> getAllSubscriptionDetails(Pageable pageable) {
        return subscriptionDetailsRepository.findAll(pageable);
    }

    @Override
    public SubscriptionDetails getSubscriptionDetailsById(Long id) {
        return subscriptionDetailsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("SubscriptionDetail","Id",id));
    }

    @Override
    public SubscriptionDetails createSubscriptionDetails(SubscriptionDetails subscriptionDetails) {
        return subscriptionDetailsRepository.save(subscriptionDetails);
    }

    @Override
    public SubscriptionDetails updateSubscriptionDetails(Long id, SubscriptionDetails subscriptionDetailsRequest) {
        SubscriptionDetails subscriptionDetails =  subscriptionDetailsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("SubscriptionDetail","Id",id));
        return subscriptionDetailsRepository.save(subscriptionDetails.setCost(subscriptionDetailsRequest.getCost())
                .setCostTotal(subscriptionDetailsRequest.getCostTotal())
                .setDiscount(subscriptionDetailsRequest.getDiscount())
                .setDuration(subscriptionDetailsRequest.getDuration())
                .setEndSubscription(subscriptionDetailsRequest.getEndSubscription()));
    }

    @Override
    public ResponseEntity<?> deleteSubscriptionDetails(Long id) {
        SubscriptionDetails subscriptionDetails =  subscriptionDetailsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("SubscriptionDetail","Id",id));
        subscriptionDetailsRepository.delete(subscriptionDetails);
        return ResponseEntity.ok().build();
    }
}
