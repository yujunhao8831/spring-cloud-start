package com.pijingzhanji.common;

import com.pijingzhanji.common.http.OkHttpFactory;
import jodd.http.HttpRequest;
import jodd.util.StringPool;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 小贴士
 *
 * @author : 披荆斩棘
 * @date : 2017/7/19
 * @see <a href="https://github.com/yujunhao8831/tips">tips</a>
 */
final class Tips {

    /**
     * 集合相关工具
     */
    CollectionUtils collectionUtils;
    /**
     * List相关工具
     */
    ListUtils       listUtils;
    /**
     * Set相关工具
     */
    SetUtils        setUtils;
    /**
     * 数组相关工具
     */
    ArrayUtils      arrayUtils;
    ///////////////////////////////////////////////////////////////////////////
    // http工具
    ///////////////////////////////////////////////////////////////////////////
    /**
     * OkHttp
     */
    OkHttpFactory   okHttpFactory;
    /**
     * jodd
     */
    HttpRequest     httpRequest;
    ///////////////////////////////////////////////////////////////////////////
    // 字符串
    ///////////////////////////////////////////////////////////////////////////
    /**
     * jodd 字符串池,包含了很多特殊字符
     * 更多请看 jodd.util
     */
    StringPool      stringPool;
    /**
     * apache 字符串处理工具
     */
    StringUtils     stringUtils;


}
