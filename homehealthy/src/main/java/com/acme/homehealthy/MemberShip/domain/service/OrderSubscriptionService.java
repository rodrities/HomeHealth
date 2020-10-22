package com.acme.homehealthy.MemberShip.domain.service;

import com.acme.homehealthy.MemberShip.domain.model.OrderSubscription;
import org.springframework.http.ResponseEntity;

public interface OrderSubscriptionService {
    OrderSubscription getOrderSubscriptionById(Long id);
    OrderSubscription createOrderSubscription(Long planId, Long customerId, OrderSubscription subscription);
    OrderSubscription updateOrderSubscription(Long id, Long planId, Long customerId, OrderSubscription subscription);
    ResponseEntity<?> deleteOrderSubscription(Long id);
}
