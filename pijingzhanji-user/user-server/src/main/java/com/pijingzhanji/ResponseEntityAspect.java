package com.pijingzhanji;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.pijingzhanji.common.util.JsonUtils.jsonToType;
import static com.pijingzhanji.common.util.JsonUtils.toFilterJson;

/**
 * @author : 披荆斩棘
 * @date : 2017/11/14
 */
@Aspect
@Component
public class ResponseEntityAspect {


	@Around( "execution(org.springframework.http.ResponseEntity com.pijingzhanji.controller.*Controller.*(..)) )" )
	public Object responseEntityAspect ( ProceedingJoinPoint joinPoint ) throws Throwable {

		Object returnValue = joinPoint.proceed();

		ResponseEntity responseEntity = ( ResponseEntity ) returnValue;

		// 用户权限或者用户自定义处理,自己可以设置
		final String resourceApiUriShowFields = "*";
		final String filterAfterJsonBody      = toFilterJson( responseEntity.getBody() , resourceApiUriShowFields );
		final Object filterAfterBody          = jsonToType( filterAfterJsonBody , responseEntity.getBody().getClass() );
		return new ResponseEntity<>( filterAfterBody , responseEntity.getHeaders() , responseEntity.getStatusCode() );


	}


}
