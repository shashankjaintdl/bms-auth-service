package com.bms.authserver.config;

import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditAwareImpl implements AuditorAware<String>{

    @Override
    public Optional<String> getCurrentAuditor() {
        if(SecurityContextHolder.getContext().getAuthentication()==null){
            return Optional.of("LOCAL");
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if(Objects.isNull(username)){
            return Optional.of("ANONYMOUS_USER");
        }
        if(username.isEmpty()){
            return Optional.of("ANONYMOUS_USER");
        }
        return Optional.of(username);
    }
}
