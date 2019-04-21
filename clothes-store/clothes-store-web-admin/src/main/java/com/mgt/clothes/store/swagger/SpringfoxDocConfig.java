package com.mgt.clothes.store.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SpringfoxDocConfig
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/16 15:57
 * @Version 1.0
 **/
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "com.mgt.clothes.store.controller" })
public class SpringfoxDocConfig {
    boolean test = true;

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.mgt.clothes.store.controller"))
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false).enable(test);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("我的商城系统接口文档").build();
    }

}
