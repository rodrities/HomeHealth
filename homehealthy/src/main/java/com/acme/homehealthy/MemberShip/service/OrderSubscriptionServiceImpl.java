package com.acme.homehealthy.MemberShip.service;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.MemberShip.domain.model.OrderSubscription;
import com.acme.homehealthy.MemberShip.domain.model.Plan;
import com.acme.homehealthy.MemberShip.domain.repository.OrderSubscriptionRepository;
import com.acme.homehealthy.MemberShip.domain.repository.PlanRepository;
import com.acme.homehealthy.MemberShip.domain.service.OrderSubscriptionService;
import com.acme.homehealthy.MemberShip.domain.service.PlanService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderSubscriptionServiceImpl implements OrderSubscriptionService {

    @Autowired
    private OrderSubscriptionRepository orderSubscriptionRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public OrderSubscription getOrderSubscriptionById(Long id) {
        return orderSubscriptionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("OrderSubscription","Id",id));
    }

    @Override
    public OrderSubscription createOrderSubscription(Long planId, Long customerId, OrderSubscription subscription) {
        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer","Id",customerId));

        Plan existingPlan = planRepository.findById(planId).orElseThrow(()->new ResourceNotFoundException("Plan","Id",planId));

        subscription.setPlan(existingPlan);
        subscription.setCustomer(existingCustomer);
        subscription.setTotalPrice();
        return orderSubscriptionRepository.save(subscription);
    }

    @Override
    public OrderSubscription updateOrderSubscription(Long id, Long planId, Long customerId, OrderSubscription subscription) {
        OrderSubscription orderSubscription = orderSubscriptionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("OrdernSubscription","Id",id));

        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer","Id",customerId));

        Plan existingPlan = planRepository.findById(planId).orElseThrow(()->new ResourceNotFoundException("Plan","Id",planId));

        return orderSubscriptionRepository.save(
                orderSubscription.setCustomer(existingCustomer)
                .setAmounthOfMonth(subscription.getAmounthOfMonth())
                .setPlan(existingPlan)
                .setTotalPrice()
                .setCustomer(existingCustomer)
        );
    }

    @Override
    public ResponseEntity<?> deleteOrderSubscription(Long id) {

        OrderSubscription existingOrderSubscription = orderSubscriptionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("OrderSubscription","Id",id));
        orderSubscriptionRepository.delete(existingOrderSubscription);
        return ResponseEntity.ok().build();
    }
}
