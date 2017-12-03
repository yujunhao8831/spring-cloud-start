package com.pijingzhanji.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.pijingzhanji.common.PagingRequest;
import com.pijingzhanji.order.bean.domain.Order;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-08-21
 */
public interface OrderService extends IService< Order > {

    
    PageInfo< Order > listPage ( PagingRequest pagingRequest );


}
