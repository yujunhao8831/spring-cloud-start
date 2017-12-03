package com.pijingzhanji.controller;

import com.pijingzhanji.common.ResponseEntityPro;
import com.pijingzhanji.common.util.GenerationCode;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author : 披荆斩棘
 * @date : 2017/11/9
 */
@RestController
@RequestMapping( "distributed-lock" )
public class DistributedLockTestController {

	@Autowired
	private RedissonClient redissonClient;


	@GetMapping
	public ResponseEntity< String > lock () {

		// 得到一个公平锁(分布式的),内部基于redis实现
		final RLock lock = redissonClient.getFairLock( "lock-test" );

		try {
			// 获取锁,超时时间为3分钟
			if ( ! lock.tryLock( 3 , TimeUnit.MINUTES ) ) {
				return ResponseEntityPro.badRequest( "获取锁超时" );
			}
		} catch ( InterruptedException e ) {
			return ResponseEntityPro.badRequest( "获取锁超时" );
		}


		try {
			// 业务 ... ...
			// 睡眠3秒
			TimeUnit.SECONDS.sleep( 3 );
		} catch ( Exception ignored ) {

		} finally {
			// 释放锁
			lock.unlock();
		}

		return ResponseEntityPro.ok( GenerationCode.globalUniqueId() );
	}
}
