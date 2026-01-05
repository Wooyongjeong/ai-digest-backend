package com.github.wooyong.aidigest.service;

import com.github.wooyong.aidigest.dto.SubscriptionCreateRequest;
import com.github.wooyong.aidigest.dto.SubscriptionResponse;
import com.github.wooyong.aidigest.entity.Keyword;
import com.github.wooyong.aidigest.entity.Subscription;
import com.github.wooyong.aidigest.entity.Topic;
import com.github.wooyong.aidigest.entity.User;
import com.github.wooyong.aidigest.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final TopicService topicService;

    @Transactional
    public Subscription createSubscription(SubscriptionCreateRequest createRequest, User user) {
        String topicName = createRequest.getTopic();
        Topic topic = topicService.createOrGetTopic(topicName);
        List<Keyword> keywords = createRequest.getKeywords().stream()
                .map(word -> Keyword.builder().word(word).build())
                .toList();

        Subscription subscription = Subscription.builder()
                .user(user)
                .topic(topic)
                .deliveryTime(LocalTime.now())
                .build();

        subscription.connectKeywords(keywords);

        return subscriptionRepository.save(subscription);
    }

    @Transactional(readOnly = true)
    public Subscription getSubscription(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("cannot found subscription id = " + id));
    }
}
