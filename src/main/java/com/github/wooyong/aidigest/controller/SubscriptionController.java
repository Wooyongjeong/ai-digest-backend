package com.github.wooyong.aidigest.controller;

import com.github.wooyong.aidigest.config.LoginUser;
import com.github.wooyong.aidigest.dto.SubscriptionCreateRequest;
import com.github.wooyong.aidigest.dto.SubscriptionResponse;
import com.github.wooyong.aidigest.entity.Subscription;
import com.github.wooyong.aidigest.entity.User;
import com.github.wooyong.aidigest.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/subscriptions")
@RestController
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<?> subscribe(@RequestBody SubscriptionCreateRequest createRequest, @LoginUser User user) {
        if (null == user) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        Subscription subscription = subscriptionService.createSubscription(createRequest, user);
        return ResponseEntity.ok(SubscriptionResponse.of(subscription));
    }

    @GetMapping("/{subscriptionId}")
    public ResponseEntity<?> getSubscription(@PathVariable Long subscriptionId, @LoginUser User user) {
        if (null == user) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        Subscription subscription = subscriptionService.getSubscription(subscriptionId);
        return ResponseEntity.ok(SubscriptionResponse.of(subscription));
    }
}
