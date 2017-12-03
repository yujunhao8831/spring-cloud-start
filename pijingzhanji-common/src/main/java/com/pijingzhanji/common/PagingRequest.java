package com.pijingzhanji.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 分页信息接收实体
 *
 * @author : 披荆斩棘
 * @date : 2017/7/13
 */
@Data
@Accessors( chain = true )
public class PagingRequest implements Serializable {

    @Deprecated
    public static final  String OFFSET_FIELD_METHOD_NAME = "setOffset";
    @Deprecated
    public static final  String LIMIT_FIELD_METHOD_NAME  = "setLimit";
    private static final long   serialVersionUID         = 1L;
    private int offset;
    private int limit;


    public PagingRequest () {
        this( GlobalConstant.DEFAULT_PAGE_NUM , GlobalConstant.DEFAULT_PAGE_SIZE );
    }

    public PagingRequest ( int offset , int limit ) {
        this.offset = offset;
        this.limit = limit;
    }


}
