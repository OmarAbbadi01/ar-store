package com.abbadi.arstore.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "ar-store-config.cloudinary")
@Component
@Getter
@Setter
public class CloudinaryConfigProperties {

    private String cloudName;

    private String apiKey;

    private String apiSecret;

}
