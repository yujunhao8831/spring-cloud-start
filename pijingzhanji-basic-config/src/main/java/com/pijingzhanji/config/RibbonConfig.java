package com.pijingzhanji.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author : 披荆斩棘
 * @date : 2017/10/9
 */
@Configuration
public class RibbonConfig {

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {
        return new RestTemplate(
                Arrays.asList( new StringHttpMessageConverter( StandardCharsets.UTF_8 ) ,
                               mappingJackson2HttpMessageConverter )
        );
    }
}
