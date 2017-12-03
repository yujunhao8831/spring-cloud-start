package com.pijingzhanji.order.controller;

import com.github.pagehelper.PageHelper;
import com.pijingzhanji.common.ResponseEntityPro;
import com.pijingzhanji.order.bean.domain.Order;
import com.pijingzhanji.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 披荆斩棘
 * @date : 2017/11/9
 */
@RestController
public class OrderFeignController implements OrderFeignService {

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity< List< Order > > orders () {
        PageHelper.startPage( 1 , 100 );
        return ResponseEntityPro.ok( orderService.selectList( null ) );
    }
}
