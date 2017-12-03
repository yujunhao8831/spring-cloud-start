package com.pijingzhanji.service.impl;

import com.pijingzhanji.GlobalCacheConstant;
import com.pijingzhanji.bean.domain.User;
import com.pijingzhanji.bean.model.JwtUser;
import com.pijingzhanji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@CacheConfig( cacheNames = GlobalCacheConstant.USER_DETAILS_SERVICE_NAMESPACE )
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Lazy
	@Autowired
	private UserService userService;

	@Override
	@Cacheable( key = "#username" )
	public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
		User user = userService.findByUsername( username );
		if ( user == null ) {
			throw new UsernameNotFoundException( String.format( "该'%s'用户名不存在." , username ) );
		}

		return new JwtUser(
			user.getId() ,
			user.getUsername() ,
			user.getPassword() ,
			user.getNickName() ,
			user.getRealName() ,
			user.getEmail() ,
			user.getPhone() ,
			user.getUserImageUrl() ,
			user.getLastPasswordResetDate() ,
			user.getCreateUserId() ,
			user.getCreateTime() ,
			user.getUpdateTime() ,
			user.getRemark() ,
			user.getEnabled()
		);
	}


}










