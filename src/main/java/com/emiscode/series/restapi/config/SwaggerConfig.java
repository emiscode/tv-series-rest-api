package com.emiscode.series.restapi.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket seriesApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.emiscode.series.restapi"))
				.paths(PathSelectors.regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
				"TV Series REST API",
				"A very simple CRUD REST API with Spring Boot for a TV Series DEMO App",
				"0.0.1",
				"Terms of Service",
				new Contact("Emilio Scodeler", "https://www.linkedin.com/in/emilio-scodeler/", 
						"scodeler.emilio@gmail.com"),
				"MIT License",
				"https://opensource.org/licenses/MIT", new ArrayList<VendorExtension>()
				);
		
		return apiInfo;
	}
}
