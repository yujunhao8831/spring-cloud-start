package com.pijingzhanji.order.controller;

import com.github.pagehelper.PageHelper;
import com.pijingzhanji.common.PagingRequest;
import com.pijingzhanji.common.ResponseEntityPro;
import com.pijingzhanji.order.bean.domain.Order;
import com.pijingzhanji.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 披荆斩棘
 * @date : 2017/8/22
 */
@RestController
@RequestMapping( "orders" )
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity< List< Order > > list ( PagingRequest pagingRequest ) {
        PageHelper.startPage( pagingRequest.getOffset() , pagingRequest.getLimit() );
        return ResponseEntityPro.ok( orderService.selectList( null ) );
    }


}
