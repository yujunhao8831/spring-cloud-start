package com.pijingzhanji.gateway;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author : 披荆斩棘
 * @date : 2017/10/17
 */
@Component
public class PreFilter extends ZuulFilter {


    /**
     * 执行顺序看源码
     * {@link com.netflix.zuul.http.ZuulServlet#service(ServletRequest , ServletResponse)}
     *
     * @return
     */
    @Override
    public String filterType () {
        return FilterConstants.PRE_TYPE;
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
        // 请求之前调用
        return null;
    }


}
