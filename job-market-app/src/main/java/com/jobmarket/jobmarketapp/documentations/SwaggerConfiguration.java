package com.jobmarket.jobmarketapp.documentations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenApi openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes
                        ("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("Swift Select")
                        .description("Documentation for Swift Select SpringBoot e-hiring application REST APIs")
                        .version("v1.0").contact(new Contact().name("Swift Select Team")
                                .email("swifitselect12@gmail.com").url("https://github.com/decadevs/SQ17-SwiftSelect-Live-Project-Backend"))
                        .license(new License().name("License of API")
                                .url("API license URL")));
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
