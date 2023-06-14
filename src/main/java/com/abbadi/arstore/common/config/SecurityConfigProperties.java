package com.abbadi.arstore.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "ar-store-config.security")
@Component
@Getter
@Setter
public class SecurityConfigProperties {

    private String secretKey;

    private String jwtTokenHeaderName;

    private String jwtTokenHeaderPrefix;

    private int tokenLifeTimeMinutes;
}
