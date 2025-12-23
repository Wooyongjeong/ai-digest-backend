package com.github.wooyong.aidigest.repository;

import com.github.wooyong.aidigest.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    boolean existsBySubscriptionIdAndWord(Long subscriptionId, String word);
    Optional<Keyword> findBySubscriptionIdAndWord(Long subscriptionId, String word);
}
