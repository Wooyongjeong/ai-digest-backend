package com.github.wooyong.aidigest.repository;

import com.github.wooyong.aidigest.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByName(String name);
    Optional<Topic> findByName(String name);
}
