package com.acme.homehealthy.MemberShip.domain.repository;

import com.acme.homehealthy.MemberShip.domain.model.OrderSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderSubscriptionRepository extends JpaRepository<OrderSubscription, Long> {
}
