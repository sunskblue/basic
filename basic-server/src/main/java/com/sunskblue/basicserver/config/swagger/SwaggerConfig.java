package com.sunskblue.basicserver.config.swagger;

import com.sunskblue.basicserver.core.ResultCode;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author sunshaokang
 * @date Created in 2020/11/4 3:57 下午
 * Description：Swagger配置类
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerInfo.class)
//@Profile({"dev"})
public class SwaggerConfig {

    @Resource
    private SwaggerInfo swaggerInfo;

    /**
     * 设置api信息
     *
     * @return 返回ApiInfo
     */
    private ApiInfo apiInfo() {
        StringVendorExtension vendorExtension = new StringVendorExtension("", "");
        Collection<VendorExtension> vendorExtensions = new ArrayList<>();
        vendorExtensions.add(vendorExtension);
        Contact contact = new Contact("", "", "");
        return new ApiInfo(
                swaggerInfo.getTitle(),
                swaggerInfo.getDescription(),
                swaggerInfo.getVersion(),
                "", contact, "", "",
                vendorExtensions);
    }

    @Bean
    public Docket createRestApi() {

//        //添加全局响应状态码
//        List<ResponseMessage> responseMessageList = new ArrayList<>();
//        Arrays.stream(ResultCode.values()).forEach(errorEnums -> {
//            responseMessageList.add(
//                    new ResponseMessageBuilder().code(errorEnums.code()).message(errorEnums.name()).responseModel(
//                            new ModelRef(errorEnums.name())).build()
//            );
//        });

        return new Docket(DocumentationType.SWAGGER_2)
//                .globalResponseMessage(RequestMethod.GET, responseMessageList)
//                .globalResponseMessage(RequestMethod.POST, responseMessageList)
//                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
//                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .groupName(swaggerInfo.getGroupName())
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(false)
                .forCodeGeneration(true)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }
}
