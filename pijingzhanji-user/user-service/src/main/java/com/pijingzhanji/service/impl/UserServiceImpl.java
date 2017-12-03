package com.pijingzhanji.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pijingzhanji.bean.domain.User;
import com.pijingzhanji.common.PagingRequest;
import com.pijingzhanji.mapper.UserMapper;
import com.pijingzhanji.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 * <p>
 * 这里 {@code @CacheConfig 的 cacheNames = "userService.user"},表示该类下面所有方法在使用Spring Cache注解后
 * 默认的cacheNames,如果不指定则使用@CacheConfig所指定的cacheNames,如果指定了,则使用指定的.
 *
 * @author 披荆斩棘
 * @since 2017-05-11
 */
// @CacheConfig( cacheNames = "userService.user.namespace" )
@Service
public class UserServiceImpl extends ServiceImpl< UserMapper, User > implements UserService {


	/**
	 * SpEL表达式 : T(完整的类名),因为key只能是String类型,下面的key使用SpEL表达式进行了转换
	 * 这里
	 *
	 * @param pagingRequest
	 * @return
	 */
	// @Cacheable( value = CACHE_USER_LIST_PAGE_NAME_PREFIX, key = "#pagingRequest.offset + '.' + #pagingRequest.getLimit()" )
	@Override
	public PageInfo< List< User > > listPage ( PagingRequest pagingRequest ) {
		PageHelper.startPage( pagingRequest.getOffset() , pagingRequest.getLimit() );
		return new PageInfo( super.selectList( null ) );
	}

	@Override
	public User findByUsername ( String username ) {
		return this.selectOne( new Condition().eq( "username" , username ) );
	}


}
