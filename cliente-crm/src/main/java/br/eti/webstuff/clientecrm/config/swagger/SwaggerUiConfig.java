package br.eti.webstuff.clientecrm.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerUiConfig {

	private ApiInfoBuilder apiInfoBuilder;


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.eti.webstuff.clientecrm.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {

		apiInfoBuilder = new ApiInfoBuilder();

		return apiInfoBuilder.title("CRM")
				.description("Documentação da Api Rest com Spring Boot e Spring Date JPA - Consumindo"
						+ "um cliente SOPA e disponibilizando um Serviços REST")
				.version("1.0.0S").build();
	}

}
