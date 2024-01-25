package com.timirov.pet.tasktrackerbackend.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Data
@ConfigurationProperties(prefix = "jwt")
public class TokenProperties {

    private String secret;

    private Duration lifetime;
}
