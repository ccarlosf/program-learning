package com.ccarlosf.service.center;

import com.ccarlosf.pojo.Users;

public interface CenterUserService {

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    public Users queryUserInfo(String userId);

}
