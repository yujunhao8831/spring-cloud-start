package com.pijingzhanji.controller;

import com.pijingzhanji.permission.Pass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : 披荆斩棘
 * @date : 2017/11/8
 */
@RestController
@RequestMapping( "micro-service" )
public class MicroServiceTestController {
	@Autowired
	private RestTemplate restTemplate;

	///////////////////////////////////////////////////////////////////////////
	// 效果都一样,都可以负载均衡
	///////////////////////////////////////////////////////////////////////////
	@Autowired
	private OrderFeignClientService orderFeignClientService;

	/**
	 * 通过网关调用
	 *
	 * @return
	 */
	@Pass
	@GetMapping( "orders" )
	public ResponseEntity order1 () {
		return restTemplate.getForEntity( "http://PIJINGZHANJI-GATEWAY-ZUUL/order/orders" , Object.class );
	}

	/**
	 * 直接调用某个微服务
	 *
	 * @return
	 */
	@Pass
	@GetMapping( "orders-2" )
	public ResponseEntity order2 () {
		return restTemplate.getForEntity( "http://PIJINGZHANJI-ORDER-SERVER/orders" , Object.class );
	}

	/**
	 * Feign 模式,其实内部就是用 Ribbon
	 *
	 * @return
	 */
	@Pass
	@GetMapping( "orders-3" )
	public ResponseEntity order3 () {
		return orderFeignClientService.orders();
	}

	@FeignClient( "PIJINGZHANJI-ORDER-SERVER" )
	interface OrderFeignClientService {

		@GetMapping( "feign/orders" )
		ResponseEntity orders ();

	}

}
