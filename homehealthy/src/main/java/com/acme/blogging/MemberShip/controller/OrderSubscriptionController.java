package com.acme.blogging.MemberShip.controller;

import com.acme.blogging.MemberShip.domain.model.OrderSubscription;
import com.acme.blogging.MemberShip.domain.repository.OrderSubscriptionRepository;
import com.acme.blogging.MemberShip.domain.service.OrderSubscriptionService;
import com.acme.blogging.MemberShip.resource.OrderSubscriptionResource;
import com.acme.blogging.MemberShip.resource.SaveOrderSubscriptionResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "OrderSubscription", description = "MemberShip")
@RestController
@RequestMapping("api/")
public class OrderSubscriptionController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OrderSubscriptionService subscriptionService;

    //OrderSubscription getOrderSubscriptionById(Long id);
    @GetMapping("/orderSubscription/{orderSubscriptionId}")
    public OrderSubscriptionResource getOrderSubscriptionById(@Valid @PathVariable (name = "orderSubscriptionId") Long id){
        return convertToResource(subscriptionService.getOrderSubscriptionById(id));
    }

    //OrderSubscription createOrderSubscription(OrderSubscription subscription);
    @PostMapping("/orderSubscription/{planId}/{customerId}")
    public OrderSubscriptionResource createOrderSubscription(@Valid @RequestBody SaveOrderSubscriptionResource resource,
                                                             @Valid @PathVariable (value = "planId") Long planId,
                                                             @Valid @PathVariable (value = "customerId") Long customerId){
        OrderSubscription subscription = convertToEntity(resource);
        return convertToResource(subscriptionService.createOrderSubscription(planId,customerId,subscription));
    }

    //OrderSubscription updateOrderSubscription(Long id, OrderSubscription subscription);
    @PutMapping("/orderSubscription/{orderSubscriptionId}/{planId}/{customerId}")
    public OrderSubscriptionResource updateOrderSubscription(@Valid @PathVariable (name = "orderSubscriptionId") Long id,
                                                             @Valid @PathVariable (name = "planId") Long planId,
                                                             @Valid @PathVariable (name = "customerId") Long customerId,
                                                             @Valid @RequestBody SaveOrderSubscriptionResource resource){
        OrderSubscription subscription = convertToEntity(resource);
        return convertToResource(subscriptionService.updateOrderSubscription(id,planId,customerId,subscription));
    }

    //ResponseEntity<?> deleteOrderSubscription(Long id);
    @DeleteMapping("/orderSubscription/{orderSubscriptionId}")
    public ResponseEntity<?> deleteOrderSubscription(@Valid @PathVariable (name = "orderSubscriptionId") Long id){
        subscriptionService.deleteOrderSubscription(id);
        return ResponseEntity.ok().build();
    }

    private OrderSubscription convertToEntity(SaveOrderSubscriptionResource resource){
        return mapper.map(resource,OrderSubscription.class);
    }

    private OrderSubscriptionResource convertToResource(OrderSubscription subscription){
        return mapper.map(subscription, OrderSubscriptionResource.class);
    }
}
