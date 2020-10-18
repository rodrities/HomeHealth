package com.acme.homehealthy.domain.repository;

import com.acme.homehealthy.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
}