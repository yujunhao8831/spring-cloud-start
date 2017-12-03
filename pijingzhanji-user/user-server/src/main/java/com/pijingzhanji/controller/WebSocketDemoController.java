package com.pijingzhanji.controller;

import com.pijingzhanji.common.ResponseEntityPro;
import com.pijingzhanji.common.annotation.PassInjectionAttackIntercept;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 披荆斩棘
 * @date : 2017/8/26
 */
@RestController
public class WebSocketDemoController {

	@MessageMapping( "/hello" )   // 接收客户端
	@SendTo( "/topic/greetings" ) // 广播消息
	public ResponseEntity< String > greeting ( String message ) {
		return ResponseEntityPro.ok( "Hello, " + message + "!" );
	}

	@RequestMapping( "demo" )
	@PassInjectionAttackIntercept( { "update" , "exec" } )
	public ResponseEntity< String > demo () {
		return ResponseEntityPro.ok();
	}


}
