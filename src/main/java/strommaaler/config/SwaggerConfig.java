package strommaaler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
//@Import(SpringDataRestConfiguration.class)
@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket apiDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                // .apis(RequestHandlerSelectors.basePackage("no.ya.topazdocumentstore.restcontroller"))
                .apis((RequestHandlerSelectors.withClassAnnotation(RestController.class)))
                .paths(PathSelectors.any())
                //.paths(PathSelectors.ant("/consentmanager/consents/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Strommåling rest API",
                "Dette API ekponerer tjeneste mot Strommåling.",
                "API Documentstore",
                "",
                new Contact("", "ya.no", "dragerot@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}

