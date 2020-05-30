package com.storage;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestAttribute;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
public class StorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageApplication.class, args);
	}
    
    @Bean
    public Docket api() {
        Parameter globalParam =
                new ParameterBuilder().name("Authorization").description("Authorization token")
                        .modelRef(new ModelRef("string")).parameterType("header").required(false).build();

        return new Docket(DocumentationType.SWAGGER_2).ignoredParameterTypes(RequestAttribute.class)
                .globalOperationParameters(Arrays.asList(globalParam)).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

}
