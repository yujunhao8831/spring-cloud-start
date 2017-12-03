package com.pijingzhanji.bean.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pijingzhanji.common.security.BasicJwtUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * jwt对象
 *
 * @author pijingzhanji
 */
@Data
@Accessors( chain = true )
@AllArgsConstructor
public class JwtUser implements BasicJwtUser {

	private final Long    id;
	private final String  username;
	private final String  password;
	private final String  nickName;
	private final String  realName;
	private final String  email;
	private final String  phone;
	private final String  userImageUrl;
	private final Date    lastPasswordResetDate;
	private final Long    createManagerAdminUserId;
	private final Date    createTime;
	private final Date    updateTime;
	private final String  remark;
	private final boolean enabled;


	@Override
	public String getUsername () {
		return this.username;
	}

	@Override
	public boolean isEnabled () {
		return this.enabled;
	}

	@JsonIgnore
	@Override
	public Collection< ? extends GrantedAuthority > getAuthorities () {
		return Collections.emptyList();
	}

	@Override
	public String getPassword () {
		return this.password;
	}

	@Override
	public boolean isAccountNonExpired () {
		return true;
	}

	@Override
	public boolean isAccountNonLocked () {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired () {
		return true;
	}


}
