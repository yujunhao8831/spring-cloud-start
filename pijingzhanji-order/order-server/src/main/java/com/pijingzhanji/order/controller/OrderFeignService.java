package com.pijingzhanji.order.controller;

import com.pijingzhanji.order.bean.domain.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author : 披荆斩棘
 * @date : 2017/11/9
 */
@RequestMapping( "feign/orders" )
public interface OrderFeignService {

    @GetMapping
    ResponseEntity< List< Order > > orders ();

}
