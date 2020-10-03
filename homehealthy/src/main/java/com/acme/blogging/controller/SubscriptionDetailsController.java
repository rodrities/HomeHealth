package com.acme.blogging.controller;

import com.acme.blogging.domain.model.Subscription;
import com.acme.blogging.domain.model.SubscriptionDetails;
import com.acme.blogging.domain.service.SubscriptionDetailsService;
import com.acme.blogging.resource.SaveSubscriptionDetailsResource;
import com.acme.blogging.resource.SaveSubscriptionResource;
import com.acme.blogging.resource.SubscriptionDetailsResource;
import com.acme.blogging.resource.SubscriptionResource;
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
public class SubscriptionDetailsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SubscriptionDetailsService subscriptionDetailsService;

    @GetMapping("/subscriptionDetails")
    public Page<SubscriptionDetailsResource> getAllSubscriptionDetails(Pageable pageable){
        Page<SubscriptionDetails> subscriptionDetails = subscriptionDetailsService.getAllSubscriptionDetails(pageable);
        List<SubscriptionDetailsResource> resources = subscriptionDetails.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @GetMapping("/subscriptionDetails/{subscriptionDetailsId}")
    public SubscriptionDetailsResource getSubscriptionDetailsById(@PathVariable (value = "subscriptionDetailsId") Long subscriptionDetailsId)
    {
        return convertToResource(subscriptionDetailsService.getSubscriptionDetailsById(subscriptionDetailsId));
    }

    @PostMapping("/subscriptionDetails")
    public SubscriptionDetailsResource createSubscriptionDetails(@Valid @RequestBody SaveSubscriptionDetailsResource resource){
        SubscriptionDetails subscriptionDetails = convertToEntity(resource);
        return convertToResource(subscriptionDetailsService.createSubscriptionDetails(subscriptionDetails));
    }


    private SubscriptionDetails convertToEntity(SaveSubscriptionDetailsResource resource){
        return mapper.map(resource, SubscriptionDetails.class);
    }

    private SubscriptionDetailsResource convertToResource(SubscriptionDetails entity){
        return mapper.map(entity, SubscriptionDetailsResource.class);
    }
}
