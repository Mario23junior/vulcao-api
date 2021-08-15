package com.project.vulcao.Config;

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

	private final String PACKAGE_BUILD = "com.project.vulcao";
	private final String TITLE_API = "Api vulcoes";
	private final String DESCRIPTION = "api de consulta de informações de vulcoes";
	private final String NAME_AUTHOR = "Mário Junior";
	private final String VERSION = "1.0.0";
	private final String ENDERECO_API = "https://github.com/Mario23junior/vulcao-api";
	private final String EMAIL = "mariojunior3251@gmail.com";

	@Bean
	public Docket configuration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(PACKAGE_BUILD))
				.build()
				.apiInfo(informacaoApi());

	}

	private ApiInfo informacaoApi() {
		return new ApiInfoBuilder()
				.title(TITLE_API)
				.description(DESCRIPTION)
				.version(VERSION)
				.contact(new Contact(NAME_AUTHOR, ENDERECO_API,EMAIL)).build();
	}

}
