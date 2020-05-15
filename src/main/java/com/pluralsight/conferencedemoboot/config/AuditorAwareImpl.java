package com.pluralsight.conferencedemoboot.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Optional<String> name= Optional.of("Saurabh");
        return name;
    }
}