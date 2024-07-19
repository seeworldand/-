package com.tg.blog.controller;

import com.tg.blog.base.BaseResponse;
import com.tg.blog.base.GetReq;
import com.tg.blog.base.LoginReq;
import com.tg.blog.base.RegisReq;
import com.tg.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classname: UserController
 * Package: com.tg.blog.controller
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/17 23:37
 * @Version 17
 */
@Controller
@RequestMapping({"/api"})
public class UserController {
    @Autowired
    UserService userService;

    /**
     *
     * @param req
     * @return
     */

    @GetMapping("/auth/register")
    public BaseResponse register(@Valid @RequestBody RegisReq req){
        return userService.regist(req);
    }
    @PostMapping("/auth/login")
    public BaseResponse login(@Valid @RequestBody LoginReq req){
        return userService.login(req);
    }
    @GetMapping("/auth/me")
    public BaseResponse getMe(@Valid @RequestBody GetReq req){
        return userService.getMe(req);
    }



}
