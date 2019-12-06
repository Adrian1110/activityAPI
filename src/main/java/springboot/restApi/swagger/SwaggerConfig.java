package springboot.restApi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("springboot.restApi"))
                .build()
                .apiInfo(metaInfo());
    }

    Contact contact = new Contact(
            "Adrian Aioanei",
            "https://www.heavensolutions.com/en/", 
            "adrian.aioanei@heavensolutions.com"
    );

    private ApiInfo metaInfo() {
    	  ApiInfo apiInfo = new ApiInfo(
                  "Spring Boot API",
                  "Spring Boot REST API for activites management",
                  "1.0",
                  "Terms of Service",
                  contact,
                  "Apache License Version 2.0",
                  "https://www.apache.org/licesen.html"
          );

        return apiInfo;
    }
}