package com.pijingzhanji.controller;

import com.github.pagehelper.PageInfo;
import com.pijingzhanji.bean.domain.User;
import com.pijingzhanji.common.PagingRequest;
import com.pijingzhanji.common.ResponseEntityPro;
import com.pijingzhanji.permission.Pass;
import com.pijingzhanji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 后台管理用户 前端控制器
 * </p>
 *
 * @author 披荆斩棘
 * @since 2017-06-15
 */
@RestController
@RequestMapping( "users" )
public class UserController {

	@Autowired
	private UserService userService;

	@Pass
	@GetMapping
	public ResponseEntity< PageInfo< List< User > > > listPage ( PagingRequest pagingRequest ) {
		return ResponseEntityPro.ok( userService.listPage( pagingRequest ) , "-password" );
	}


}
