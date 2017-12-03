package com.pijingzhanji.gateway;

import com.google.common.collect.Sets;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.pijingzhanji.common.ResponseEntityPro;
import com.pijingzhanji.common.util.CollectionPlusUtils;
import com.pijingzhanji.common.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @author : 披荆斩棘
 * @date : 2017/10/17
 */
@Component
public class RouteFilter extends ZuulFilter {

    private final static String                              AUTH_SERVER_ID                    = "pijingzhanji-user-server";
    private final static Map< Set< String >, Set< String > > AUTH_SERVER_PASS_REQUEST_MAPPINGS =
            CollectionPlusUtils.hashMapExpectedPuts( 2 ,
                                                     Sets.newHashSet( "/authentication" ) ,
                                                     Sets.newHashSet( HttpMethod.POST.name() , HttpMethod.PUT.name() ) ,
                                                     Sets.newHashSet( "/validation" ) ,
                                                     Sets.newHashSet( Collections.singletonList( HttpMethod.POST.name() ) )
            );


    @Autowired
    private RestTemplate restTemplate;
    @Value( "${jwt.header:Authorization}" )
    private String       tokenHeaderKey;

    @Override
    public String filterType () {
        return FilterConstants.ROUTE_TYPE;
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

        final String serviceId = ( String ) ctx.get( FilterConstants.SERVICE_ID_KEY );
        final String uri       = ( String ) ctx.get( FilterConstants.REQUEST_URI_KEY );
        if ( AUTH_SERVER_ID.equals( serviceId ) ) {
            for ( Map.Entry< Set< String >, Set< String > > entry : AUTH_SERVER_PASS_REQUEST_MAPPINGS.entrySet() ) {
                final Set< String > uris    = entry.getKey();
                final Set< String > methods = entry.getValue();
                if ( uris.contains( uri ) && methods.contains( request.getMethod() ) ) {
                    return null;
                }
            }
        }

        final String authToken = this.extractAuthTokenFromRequest( request , tokenHeaderKey );

        // 权限认证,这里只是demo,具体业务具体实现
        final ResponseEntity result = auth( authToken );

        if ( ResponseEntityPro.isNotOk( result ) ) {
            unauthorized( ctx , response );
            return null;
        }

        return null;
    }


    /**
     * 进行认证,具体算法按照自己的业务进行实现
     *
     * @param authToken
     * @return
     */
    private ResponseEntity auth ( String authToken ) {
        // 通过网关,或者直接调认证服务,都可
        final String url = "http://PIJINGZHANJI-USER-SERVER/validation";
        return restTemplate.postForEntity( url , new HttpEntity<>( authToken ) , String.class );
    }


    private void unauthorized ( RequestContext ctx , HttpServletResponse response ) {
        ctx.setSendZuulResponse( false );
        ctx.setResponseStatusCode( 401 );
        ctx.setResponseBody( JsonUtils.toJson( ResponseEntityPro.unauthorized( "身份验证失败" ) ) );
        ctx.setResponse( response );
    }

    private String extractAuthTokenFromRequest ( HttpServletRequest httpRequest , String tokenHeader ) {
        /* Get token from header */
        String authToken = httpRequest.getHeader( tokenHeader );
        /* 如果请求头没有找到,那么从请求参数中获取 */
        if ( StringUtils.isEmpty( authToken ) ) {
            authToken = httpRequest.getParameter( tokenHeader );
        }
        return authToken;
    }

}
