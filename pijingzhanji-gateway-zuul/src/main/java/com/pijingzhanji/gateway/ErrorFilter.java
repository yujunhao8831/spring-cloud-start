package com.pijingzhanji.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 披荆斩棘
 * @date : 2017/10/17
 */
@Component
public class ErrorFilter extends ZuulFilter {


    @Override
    public String filterType () {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder () {
        return 0;
    }

    @Override
    public boolean shouldFilter () {
        return true;
    }

    @Override
    public Object run () {
        RequestContext      ctx      = RequestContext.getCurrentContext();
        HttpServletRequest  request  = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        response.setHeader( HttpHeaders.CONTENT_TYPE , MediaType.APPLICATION_JSON_UTF8_VALUE );
        // 异常处理        
        return null;
    }


}
