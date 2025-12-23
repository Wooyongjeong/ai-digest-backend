package com.github.wooyong.aidigest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AiDigestBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiDigestBackendApplication.class, args);
    }

}
