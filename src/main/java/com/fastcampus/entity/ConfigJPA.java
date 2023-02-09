package com.fastcampus.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
// JPA Auditing
// 자동으로 셋팅될 수 있도록 셋팅
@EnableJpaAuditing      // JPA Auditing 활성화
@Configuration
public class ConfigJPA {
    // 사람 정보 넣는 Config Options
    @Bean
    public AuditorAware<String> auditorAware() {
        // TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때 수행하기
        return () -> Optional.of("uno");
    }
}
