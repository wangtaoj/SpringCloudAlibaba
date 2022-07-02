package com.wangtao.sentinelexample.feign.fallback;

import com.wangtao.sentinelexample.feign.UserService;
import com.wangtao.sentinelexample.vo.UserVO;

/**
 * @author wangtao
 * Created at 2022/7/2 14:59
 */
public class UserServiceFallback implements UserService {

    @Override
    public UserVO detailUser(Integer userId) {
        return new UserVO(userId, "fallback-user", 20);
    }

    @Override
    public String getServerPort() {
        return null;
    }
}
