package com.pijingzhanji.order.common.util;

import com.pijingzhanji.common.util.CollectionPlusUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 披荆斩棘 on 2017/8/1.
 */
public class CollectionPlusUtilsTest {
    @Test
    public void puts () throws Exception {
        final Map< Object, Object > puts = CollectionPlusUtils.puts( new HashMap<>() ,
                                                                     "username" , "admin" ,
                                                                     "password" , "123456"
        );
        System.err.println( "puts = " + puts );
    }

    @Test
    public void hashMapExpectedPuts () throws Exception {
        final Map< Object, Object > puts = CollectionPlusUtils.hashMapExpectedPuts( 2 ,
                                                                                    "username" , "admin" ,
                                                                                    "password" , "123456"
        );
        System.err.println( "puts = " + puts );
    }

    @Test
    public void hashMapPuts () throws Exception {
        final Map< Object, Object > puts = CollectionPlusUtils.hashMapPuts( 2 ,
                                                                            "username" , "admin" ,
                                                                            "password" , "123456"
        );
        System.err.println( "puts = " + puts );
    }

    @Test
    public void linkedHashMapPuts () throws Exception {
        final Map< Object, Object > puts = CollectionPlusUtils.linkedHashMapPuts(
                "username" , "admin" ,
                "password" , "123456"
        );
        System.err.println( "puts = " + puts );
    }

    @Test
    public void linkedHashMapExpectedPuts () throws Exception {
        final Map< Object, Object > puts = CollectionPlusUtils.linkedHashMapExpectedPuts( 2 ,
                                                                                          "username" , "admin" ,
                                                                                          "password" , "123456"
        );
        System.err.println( "puts = " + puts );
    }

}
