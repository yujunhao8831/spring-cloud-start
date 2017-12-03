package com.pijingzhanji.order.ant;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;

import java.util.Map;

/**
 * @author : 披荆斩棘
 * @date : 2017/7/8
 */
public class AntPathMatcherTest {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Test
    public void extractUriTemplateVariables () throws Exception {
        final Map< String, String > variables =
                antPathMatcher.extractUriTemplateVariables( "/users/{id}/{roleId}" , "/users/1001/8008" );

        System.err.println( "variables = " + variables );
    }
    // /roles/{userId}/{roleId}


    @Test
    public void match () throws Exception {

        System.err.println( antPathMatcher.match( "/roles/{userId}/{roleId}" , "userId" ) );
        System.err.println( antPathMatcher.matchStart( "/roles/{userId}/{roleId}" , "userId" ) );
    }


}
