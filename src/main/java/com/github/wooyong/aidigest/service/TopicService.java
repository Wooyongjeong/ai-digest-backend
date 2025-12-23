package com.github.wooyong.aidigest.service;

import com.github.wooyong.aidigest.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TopicService {
    private final TopicRepository topicRepository;
}
