package com.github.wooyong.aidigest.service;

import com.github.wooyong.aidigest.entity.Topic;
import com.github.wooyong.aidigest.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TopicService {
    private final TopicRepository topicRepository;

    @Transactional
    public Topic createOrGetTopic(String name) {
        log.info("create topic {}", name);

        if (topicRepository.existsByName(name)) {
            return topicRepository.findByName(name).orElse(null);
        }

        Topic topic = Topic.builder()
                .name(name)
                .build();
        return topicRepository.save(topic);
    }
}
