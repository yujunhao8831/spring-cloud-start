package com.pijingzhanji.gateway;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author : 披荆斩棘
 * @date : 2017/10/17
 */
@Component
public class PostFilter extends ZuulFilter {


    @Override
    public String filterType () {
        return FilterConstants.POST_TYPE;
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
        // 路由服务后,在响应之前.  可以对这些响应数据进行处理
        return null;
    }


}
