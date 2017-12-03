package com.pijingzhanji.config;

import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 解决Feign文件上传问题
 * {@link org.springframework.cloud.netflix.feign.FeignClientsConfiguration}
 *
 * @author : 披荆斩棘
 * @date : 2017/8/2
 */
@Configuration
public class FeignMultipartSupportConfig {


	@Bean
	public SpringFormEncoder springFormEncoder ( ObjectFactory< HttpMessageConverters > messageConverters ) {
		return new SpringFormEncoder( new SpringEncoder( messageConverters ) );
	}

}
