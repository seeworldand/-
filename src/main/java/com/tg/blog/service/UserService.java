package com.tg.blog.service;

import com.tg.blog.base.BaseResponse;
import com.tg.blog.base.GetReq;
import com.tg.blog.base.LoginReq;
import com.tg.blog.base.RegisReq;

/**
 * Classname: UserService
 * Package: com.tg.blog.service
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/17 23:40
 * @Version 17
 */
public interface UserService {
    BaseResponse regist(RegisReq req);

    BaseResponse login(LoginReq req);

    BaseResponse getMe(GetReq req);
}
