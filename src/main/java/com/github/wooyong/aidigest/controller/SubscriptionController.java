package com.github.wooyong.aidigest.controller;

import com.github.wooyong.aidigest.config.LoginUser;
import com.github.wooyong.aidigest.dto.SubscriptionCreateRequest;
import com.github.wooyong.aidigest.dto.SubscriptionResponse;
import com.github.wooyong.aidigest.dto.common.CommonResponse;
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
    public ResponseEntity<CommonResponse<SubscriptionResponse>> subscribe(@RequestBody SubscriptionCreateRequest createRequest, @LoginUser User user) {
        log.info("Subscription request received for user: {}, request: {}", user.getEmail(), createRequest);

        SubscriptionResponse subscriptionResponse = subscriptionService.createSubscription(createRequest, user);
        return ResponseEntity.ok(CommonResponse.success(subscriptionResponse));
    }

    @GetMapping("/{subscriptionId}")
    public ResponseEntity<CommonResponse<SubscriptionResponse>> getSubscription(@PathVariable Long subscriptionId, @LoginUser User user) {
        log.info("Get subscription request received for user: {}, subscriptionId: {}", user.getEmail(), subscriptionId);

        SubscriptionResponse subscriptionResponse = subscriptionService.getSubscription(subscriptionId);
        return ResponseEntity.ok(CommonResponse.success(subscriptionResponse));
    }
}
