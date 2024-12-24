package com.mis.mis_web_app_api.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("MIS_ALL_BRANCH.COM SERVER APIS")
                        .description("Post Free App server application")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Team 1")
                                .url("https://misallbranch.com")
                                .email("team1@gmail.com"))
                        .termsOfService("TOC")
                        .license(new License().name("License").url("#"))
                );
    }
}
