package com.pijingzhanji;

import com.pijingzhanji.bean.domain.User;
import com.pijingzhanji.bean.model.JwtUser;
import com.pijingzhanji.common.exception.ForbiddenException;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Objects;

/**
 * 上下文
 *
 * @author : 披荆斩棘
 * @date : 2017/6/20
 */
public final class ContextUtils {


	private static final SimpleGrantedAuthority ROLE_ANONYMOUS           = new SimpleGrantedAuthority( "ROLE_ANONYMOUS" );
	private static final String                 ANONYMOUS_USER_PRINCIPAL = "anonymousUser";


	/**
	 * 是否登录
	 * <p>
	 * {@link Authentication#isAuthenticated()}
	 *
	 * @return <code>true</code> , 匿名用户(未登录)返回 <code>false</code>
	 */
	public static boolean isLogin () {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if ( authentication.getAuthorities().contains( ROLE_ANONYMOUS )
			|| ANONYMOUS_USER_PRINCIPAL.equals( authentication.getPrincipal() ) ) {
			return false;
		}
		return authentication.isAuthenticated();
	}

	/**
	 * ! {@link #isLogin()}
	 *
	 * @return
	 */
	public static boolean isNotLogin () {
		return ! isLogin();
	}

	/**
	 * 得到jwt对象
	 *
	 * @return
	 */
	public static JwtUser getJwtUser () {
		return ( JwtUser ) getAuthentication().getPrincipal();
	}


	/**
	 * 得到User对象
	 *
	 * @return
	 */
	public static User getUser () {
		final JwtUser jwtUser = getJwtUser();
		User          user    = new User();
		BeanUtils.copyProperties( jwtUser , user );
		return user;
	}

	/**
	 * 得到用户id
	 *
	 * @return {@link User#id}
	 */
	public static Long getUserId () {
		return getJwtUser().getId();
	}

	/**
	 * 得到用户详细信息
	 *
	 * @return {@link UserDetails}
	 */
	public static UserDetails getUserDetails () {
		return ( UserDetails ) getAuthentication().getPrincipal();
	}


	/**
	 * 得到凭证
	 */
	private static Authentication getAuthentication () {
		final Authentication authentication =
			SecurityContextHolder.getContext().getAuthentication();
		if ( Objects.isNull( authentication ) || isNotLogin() ) {
			throw new AuthenticationCredentialsNotFoundException( "未授权" );
		}
		return authentication;
	}


	public static boolean isNotCurrentUser ( Long userId ) {
		return ! isCurrentUser( userId );
	}


	/**
	 * 未登录
	 *
	 * @throws ForbiddenException
	 */
	public static void assertNotLogin () throws ForbiddenException {
		if ( isNotLogin() ) {
			throw new AuthenticationCredentialsNotFoundException( "未登录" );
		}
	}

	/**
	 * 现在是每个Mapping中进行判断,后续做成在拦截器中进行处理
	 *
	 * @param userId
	 * @throws ForbiddenException
	 */
	public static void assertNotCurrentUser ( Long userId ) throws ForbiddenException {
		if ( isNotCurrentUser( userId ) ) {
			throw new ForbiddenException( "非法越权操作,非当前用户ID" );
		}
	}

	private static boolean isCurrentUser ( Long userId ) {
		return Objects.equals( getUserId() , userId );
	}


}


