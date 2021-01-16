package com.ccarlosf.service;

import com.ccarlosf.pojo.Users;

public interface UserService {

	/**
	 * @Description: 查询用户信息
	 */
	public Users queryUserInfo(String userId, String pwd);

}

