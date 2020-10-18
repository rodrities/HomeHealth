package com.acme.homehealthy.domain.repository;

import com.acme.homehealthy.domain.model.SubscriptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionDetailsRepository extends JpaRepository<SubscriptionDetails,Long> {
}
