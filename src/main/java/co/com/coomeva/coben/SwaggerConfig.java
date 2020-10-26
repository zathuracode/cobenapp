package co.com.coomeva.coben;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	private static final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);

	@Bean
	public Docket createRestApi() {
		log.info("createRestApi");

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		log.info("apiInfo");

		return new ApiInfoBuilder().title("Spring Boot Use Swagger2 structure RESTful APIs")
				.description("Test Use Swagger2 generate API File").termsOfServiceUrl("https://***.com/").version("1.0")
				.build();
	}
}
