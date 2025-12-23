package com.github.wooyong.aidigest.repository;

import com.github.wooyong.aidigest.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByUserIdAndTopicId(Long userId, Long topicId);
}
