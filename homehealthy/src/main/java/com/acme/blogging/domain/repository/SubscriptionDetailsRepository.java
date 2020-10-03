package com.acme.blogging.domain.repository;

import com.acme.blogging.domain.model.SubscriptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionDetailsRepository extends JpaRepository<SubscriptionDetails,Long> {
}
