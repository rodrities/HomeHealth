package com.acme.blogging.domain.repository;

import com.acme.blogging.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
}
