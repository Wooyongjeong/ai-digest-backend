package com.github.wooyong.aidigest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(redisNamespace = "ai-digest:session")
public class SessionConfig {
    
}

