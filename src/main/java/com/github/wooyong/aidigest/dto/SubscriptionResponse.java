package com.github.wooyong.aidigest.dto;

import com.github.wooyong.aidigest.entity.Keyword;
import com.github.wooyong.aidigest.entity.Subscription;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SubscriptionResponse {
    private Long id;
    private String topic;
    private List<String> keywords;

    public static SubscriptionResponse fromEntity(Subscription subscription) {
        return new SubscriptionResponse(
                subscription.getId(),
                subscription.getTopic().getName(),
                subscription.getKeywords().stream().map(Keyword::getWord).toList()
        );
    }
}
