package com.cmdfootball.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI cmdFootballOpenAPI() {
        // 1. Define Server Information (e.g., local and production)
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Development Server URL");

        Server prodServer = new Server();
        prodServer.setUrl("https://api.cmdfootball.com");
        prodServer.setDescription("Production Server URL");

        // 2. Define Security Scheme (JWT Bearer Token)
        Components components = new Components().addSecuritySchemes(
            "JWT Bearer Authentication", new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .description("Enter JWT Bearer token **_without_** 'Bearer ' prefix")
        );
        
        // 3. Define the Info block
        Info info = new Info()
            .title("CMD Football API")
            .description("Federation-grade endpoints for coaches, players, and admins")
            .version("1.0.0");


        // 4. Combine everything into the OpenAPI object
        return new OpenAPI()
            .info(info)
            .servers(List.of(localServer, prodServer)) // Add the server URLs
            .components(components);                     // Add the security scheme
    }
}