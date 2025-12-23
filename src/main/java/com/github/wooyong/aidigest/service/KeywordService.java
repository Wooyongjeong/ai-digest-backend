package com.github.wooyong.aidigest.service;

import com.github.wooyong.aidigest.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KeywordService {
    private final KeywordRepository keywordRepository;
}
