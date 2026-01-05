package com.github.wooyong.aidigest.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Keyword extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "keyword_seq_generator")
    @SequenceGenerator(name = "keyword_seq_generator", sequenceName = "keyword_seq", allocationSize = 50)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @Column(nullable = false)
    private String word;

    @Builder
    private Keyword(String word) {
        this.word = word;
    }

    public void connectSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
