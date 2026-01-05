package com.github.wooyong.aidigest.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubscriptionCreateRequest {
    private String topic;
    private List<String> keywords;
}
