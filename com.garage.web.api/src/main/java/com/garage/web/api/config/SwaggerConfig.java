package com.garage.web.api.config;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);

    private static Set<String> producesAndConsumes = new HashSet<>(Arrays.asList("application/json"));

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("X-TOKEN-AUTH", authorizationScopes));
    }

    private SecurityContext securityContext() {
        return SecurityContext
                .builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/api/.*"))
                .build();
    }

    @Bean
    public Docket api() {

        LOGGER.debug("Starting Swagger");

        return new Docket(DocumentationType.SWAGGER_2)
                .produces(producesAndConsumes)
                .consumes(producesAndConsumes)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.garage.web.api"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))//
                .securityContexts(Collections.singletonList(securityContext()))
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "LearningCMS REST API",
                "List API of project LearningCMS (Android & iOS).",
                "1.0",
                "http://learning-cms.com",
                new Contact("LearningCMS", "http://learning-cms.com", "learning.support@gmail.com"),
                "License of API", "http://learning-cms.com", Collections.<VendorExtension>emptyList());
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs").setKeepQueryParams(true);
//        registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
//        registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
//        registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/api/**").addResourceLocations("classpath:/META-INF/resources/");
//    }
}
