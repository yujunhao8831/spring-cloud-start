package com.pijingzhanji.order.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import org.junit.Test;

/**
 * @author : 披荆斩棘
 * @date : 2017/7/10
 */
public class FastjsonFilter {

    @Test
    public void name () throws Exception {
        // 未完成
        JSON.toJSONString( new User() , ( PropertyPreFilter ) ( serializer , object , name ) -> false );

    }
}
