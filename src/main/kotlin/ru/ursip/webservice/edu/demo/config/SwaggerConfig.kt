package ru.ursip.webservice.edu.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    open fun apiDocket(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo())
            .useDefaultResponseMessages(false)
    }


    private fun getApiInfo(): ApiInfo =
        ApiInfo(
            "user",
            "Сервис Пользователей",
            "0.0.1",
            "",
            Contact("An-C", "", "what_is_it@inbox.ru"),
            "",
            "", ArrayList()
        )
}
