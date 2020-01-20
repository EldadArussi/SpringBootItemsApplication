package springBoot;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class ItemSwagger {
	
	
	// Make documentation for our entire api available through Swagger
	@Bean
	public Docket ProductApi() {
		 return new Docket(DocumentationType.SWAGGER_2)
				 .select()  // returns an instance which provides a way to control the endpoints exposed by swagger
				 .apis(RequestHandlerSelectors.basePackage("springBoot"))
				 .paths(PathSelectors.any())
				 .build();
			 	 					 	
	}
	
	

}
