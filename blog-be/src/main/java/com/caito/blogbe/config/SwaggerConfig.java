package com.caito.blogbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Programming blog API")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.caito"))
                .build();
    }

    private ApiInfo apiInfo(){

        return new ApiInfoBuilder().title("Programming Blog")
                .description("Programming Blog API reference for developers \n" +
                "discussion forum on different programming languages")
                .termsOfServiceUrl("www.terms.com")
                .contact(new Contact("Caito Vilas",
                        "https://www.linkedin.com/in/caito-vilas-4179291b2/",
                        "caitocd@gmail.com"))
                .license("Caito licence")
                .licenseUrl("http://licence.com")
                .version("1.0")
                .build();

    }
}
