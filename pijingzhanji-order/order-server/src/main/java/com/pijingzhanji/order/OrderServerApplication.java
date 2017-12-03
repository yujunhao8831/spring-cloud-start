package com.pijingzhanji.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : 披荆斩棘
 * @date : 2017/7/3
 */
@EnableDiscoveryClient
@SpringBootApplication( scanBasePackages = "com.pijingzhanji" )
public class OrderServerApplication extends SpringBootServletInitializer {


    public static void main ( String[] args ) {
        SpringApplication.run( OrderServerApplication.class , args );
    }

    /**
     * Application类中被重写的configure方法就是使用嵌入式的Spring上下文注册应用的地方。
     * 在更为正式的场景之中，这个方法可能会用来注册Spring Java配置类，它会定义应用中所有
     * controller和服务的bean。
     *
     * @param application
     * @see <a href="http://www.infoq.com/cn/articles/microframeworks1-spring-boot">info</a>
     */
    @Override
    protected SpringApplicationBuilder configure ( SpringApplicationBuilder application ) {
        return application.sources( OrderServerApplication.class );
    }
}
