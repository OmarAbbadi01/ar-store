package com.abbadi.arstore.common.config;

import com.cloudinary.Cloudinary;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@OpenAPIDefinition(
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        },
        servers = @Server(url = "/")
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
@Configuration
@RequiredArgsConstructor
public class ArStoreConfig {

    private final CloudinaryConfigProperties cloudinaryConfigProperties;

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudinaryConfigProperties.getCloudName());
        config.put("api_key", cloudinaryConfigProperties.getApiKey());
        config.put("api_secret", cloudinaryConfigProperties.getApiSecret());
        return new Cloudinary(config);
    }

}