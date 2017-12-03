package com.pijingzhanji.order.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pijingzhanji.common.PagingRequest;
import com.pijingzhanji.order.bean.domain.Order;
import com.pijingzhanji.order.mapper.OrderMapper;
import com.pijingzhanji.order.service.OrderService;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-08-21
 */
@Service
public class OrderServiceImpl extends ServiceImpl< OrderMapper, Order > implements OrderService {


    @Override
    public PageInfo< Order > listPage ( PagingRequest pagingRequest ) {
        PageHelper.startPage( pagingRequest.getOffset() , pagingRequest.getLimit() );
        return new PageInfo<>( super.selectList( null ) );
    }


}
