package com.abbadi.arstore.authentication.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ar-store-config")
@Getter
@Setter
public class ArStoreConfigProperties {

    private int maxPageSize;

    private int defaultPageSize;

    private String logoutPath;

    private Security security;

}
