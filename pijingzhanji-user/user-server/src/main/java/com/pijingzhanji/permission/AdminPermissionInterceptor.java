package com.pijingzhanji.permission;

import com.pijingzhanji.ContextUtils;
import com.pijingzhanji.common.util.LogUtils;
import com.pijingzhanji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 权限拦截器
 * <p>
 * {@link Pass} 直接放行 {@link NotNeedPermission} 不需要权限
 *
 * @author : 披荆斩棘
 * @date : 2017/6/14
 */
public class AdminPermissionInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private AntPathMatcher        antPathMatcher;
	@Autowired
	private List< Set< String > > requestMappingUris;
	@Autowired
	private UserService           userService;


	@Override
	public boolean preHandle ( HttpServletRequest request , HttpServletResponse response ,
							   Object handler ) throws Exception {
		if ( ! ( handler instanceof HandlerMethod ) ) {
			return false;
		}
		HandlerMethod handlerMethod = ( HandlerMethod ) handler;


		// 不需要登录,也不需要权限
		final Pass pass = this.getHandlerAnnotation( handlerMethod , Pass.class );

		LogUtils.getLogger().debug( "handler '@Pass' annotation  : {} " , pass );


		if ( Objects.nonNull( pass ) ) {
			LogUtils.getLogger().debug( "当前请求直接放行" );

			return true;
		}

		// 如果未登录
		ContextUtils.assertNotLogin();

		final NotNeedPermission notNeedPermission =
			this.getHandlerAnnotation( handlerMethod , NotNeedPermission.class );

		LogUtils.getLogger().debug(
			"handler '@NotNeedPermission' annotation  : {} " ,
			notNeedPermission
		);

		// 不需要权限
		if ( Objects.nonNull( notNeedPermission ) ) {
			return true;
		}

		// 仅做演示

		return true;
	}


	private < T extends Annotation > T getHandlerAnnotation ( HandlerMethod handlerMethod ,
															  Class< T > clazz ) {
		T annotation = handlerMethod.getMethodAnnotation( clazz );
		if ( Objects.nonNull( annotation ) ) {
			return annotation;
		}
		return handlerMethod.getBean().getClass().getAnnotation( clazz );
	}


}


