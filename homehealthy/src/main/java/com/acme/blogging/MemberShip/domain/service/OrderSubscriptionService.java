package com.acme.blogging.MemberShip.domain.service;

import com.acme.blogging.MemberShip.domain.model.OrderSubscription;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;

public interface OrderSubscriptionService {
    OrderSubscription getOrderSubscriptionById(Long id);
    OrderSubscription createOrderSubscription(Long planId, Long customerId, OrderSubscription subscription);
    OrderSubscription updateOrderSubscription(Long id, Long planId, Long customerId, OrderSubscription subscription);
    ResponseEntity<?> deleteOrderSubscription(Long id);
}
