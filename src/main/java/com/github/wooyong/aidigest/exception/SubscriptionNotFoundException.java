package com.github.wooyong.aidigest.exception;

public class SubscriptionNotFoundException extends BusinessException {
    public SubscriptionNotFoundException() {
        super(ErrorCode.SUBSCRIPTION_NOT_FOUND);
    }
}
