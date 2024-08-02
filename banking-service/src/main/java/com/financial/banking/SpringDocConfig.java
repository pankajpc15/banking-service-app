package com.financial.banking;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Banking-Service API")
                        .version("v1")
                        .description("API documentation for Banking Service"));
    }

    @Bean
    public GroupedOpenApi controllerApi() {
        return GroupedOpenApi.builder()
                .group("controller-api")
                .packagesToScan("com.financial.banking.controller") // Specify the package to scan
                .build();
    }
}


//package com.financial.banking;
//
//import org.springdoc.core.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class SpringDocConfig {
//
//  
//    @Bean
//    public GroupedOpenApi controllerApi() {
//        return GroupedOpenApi.builder()
//                .group("controller-api")
//                .packagesToScan("com.financial.banking.controller") // Specify the package to scan
//                .build();
//    }
//
//
//
//}
//@Configuration

//public class SwaggerConfig {
//
//    @Bean
//    public GroupedOpenApi api() {
//        return GroupedOpenApi.builder()
//            .group("v1")
//            .pathsToMatch("/api/**")
//            .build();
//    }
//}

