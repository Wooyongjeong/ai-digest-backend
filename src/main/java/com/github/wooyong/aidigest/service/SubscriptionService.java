package com.github.wooyong.aidigest.service;

import com.github.wooyong.aidigest.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
}
