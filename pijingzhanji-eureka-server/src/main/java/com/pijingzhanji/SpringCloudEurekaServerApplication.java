package com.pijingzhanji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author pijingzhanji
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaServerApplication extends SpringBootServletInitializer {

    public static void main ( String[] args ) {
        SpringApplication.run( SpringCloudEurekaServerApplication.class , args );
    }

    @Override
    protected SpringApplicationBuilder configure ( SpringApplicationBuilder application ) {
        return application.sources( SpringCloudEurekaServerApplication.class );
    }
}
