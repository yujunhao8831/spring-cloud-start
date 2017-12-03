package com.pijingzhanji.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableZuulProxy
@SpringBootApplication
public class GatewayZuulApplication extends SpringBootServletInitializer {

    public static void main ( String[] args ) {
        SpringApplication.run( GatewayZuulApplication.class , args );
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }

    @Override
    protected SpringApplicationBuilder configure ( SpringApplicationBuilder application ) {
        return application.sources( GatewayZuulApplication.class );
    }
}
