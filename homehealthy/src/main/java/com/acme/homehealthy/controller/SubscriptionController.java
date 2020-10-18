package com.acme.homehealthy.controller;

import com.acme.homehealthy.domain.model.Subscription;
import com.acme.homehealthy.domain.service.SubscriptionService;
import com.acme.homehealthy.resource.SaveSubscriptionResource;
import com.acme.homehealthy.resource.SubscriptionResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SubscriptionController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SubscriptionService subscriptionService;


    @GetMapping("/subscriptions")
    public Page<SubscriptionResource> getAllSubscription(Pageable pageable){
        Page<Subscription> subscriptionPage = subscriptionService.getAllSubscription(pageable);
        List<SubscriptionResource> resources = subscriptionPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @GetMapping("/subscriptions/{subscriptionId}")
    public SubscriptionResource getSubscriptionById(@PathVariable (value = "subscriptionId") Long subscriptionId){
        return convertToResource(subscriptionService.getSubscriptionByID(subscriptionId));
    }

    @PostMapping("/subscriptions")
    public SubscriptionResource createSubscription(@Valid @RequestBody SaveSubscriptionResource resource){
        Subscription subscription = convertToEntity(resource);
        return convertToResource(subscriptionService.createSubscription(subscription));
    }

    @PutMapping("/subscriptions/{subscriptionId}")
    public SubscriptionResource updateSubscription(@PathVariable (value = "subscriptionId") Long id ,@Valid @RequestBody SaveSubscriptionResource resource){
        Subscription subscription = convertToEntity(resource);
        return convertToResource(subscriptionService.updateSubscription(id, subscription));
    }

    private Subscription convertToEntity(SaveSubscriptionResource resource){
        return mapper.map(resource, Subscription.class);
    }

    private SubscriptionResource convertToResource(Subscription entity){
        return mapper.map(entity, SubscriptionResource.class);
    }

}
