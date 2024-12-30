package com.example.zomato.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.cloud_apikey}")
    private String apikey;

    @Value("${cloudinary.cloud_api_secret}")
    private String apiSecret;

    @Bean
    Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apikey,
                "api_secret", apiSecret
        ));

    }
}
