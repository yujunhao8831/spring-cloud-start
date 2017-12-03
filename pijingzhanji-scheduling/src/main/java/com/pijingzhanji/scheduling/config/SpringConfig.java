package com.pijingzhanji.scheduling.config;

import com.pijingzhanji.common.filter.RequestLoggingFilter;
import com.pijingzhanji.common.util.JsonUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author : 披荆斩棘
 * @date : 2017/5/10
 */
@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {

    public RequestLoggingFilter requestLoggingFilter () {
        return new RequestLoggingFilter();
    }

    /**
     * 添加过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean () {
        // 过滤器注册
        FilterRegistrationBean  registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter encodingFilter   = new CharacterEncodingFilter();
        encodingFilter.setEncoding( StandardCharsets.UTF_8.displayName() );
        encodingFilter.setForceEncoding( true );
        // 字符过滤器 
        registrationBean.setFilter( encodingFilter );
        // 日志处理过滤器
        registrationBean.setFilter( requestLoggingFilter() );
        return registrationBean;
    }


    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter () {
        return new MappingJackson2HttpMessageConverter( JsonUtils.getCustomizationMapper() );
    }

    /**
     * 消息转换
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters ( List< HttpMessageConverter< ? > > converters ) {
        // 默认转换器注册后, 插入自定义的请求响应转换器
        converters.add( new StringHttpMessageConverter( StandardCharsets.UTF_8 ) );
        converters.add( this.mappingJackson2HttpMessageConverter() );
    }


}
