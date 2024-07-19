package com.tg.blog.service.impl;


import com.tg.blog.base.BaseResponse;
import com.tg.blog.base.GetReq;
import com.tg.blog.base.LoginReq;
import com.tg.blog.base.RegisReq;
import com.tg.blog.dao.UserDao;
import com.tg.blog.model.User;
import com.tg.blog.service.UserService;
import com.tg.blog.until.ErrorMessage;
import com.tg.blog.until.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Classname: UserServiceImpl
 * Package: com.tg.blog.service.impl
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/17 23:40
 * @Version 17
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RedisUtil redisUtil;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse regist(RegisReq req) {

        log.info("开始调用注册接口");
        User test = userDao.selectByUsernameForUpdate(req.getUsername());
        if(test != null){
            return BaseResponse.error(ErrorMessage.REGIST_FAILD);
        }
        Date date = new Date();
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(DigestUtils.md5Hex(req.getPassword()));
        user.setEmail(req.getEmail());
        user.setCreated(date);
        user.setLastModified(date);
        userDao.insert(user);
        log.info("====[用户创建成功]====");
        return BaseResponse.OK;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse login(LoginReq req) {
        log.info("开始调用登录接口");

        User user = userDao.selectByUsernameForUpdate(req.getUsername());
        if (user == null){
            log.error("用户不存在");
            return BaseResponse.error(ErrorMessage.USER_NOT_EXISTS);
        }
        if (user.getPassword().equals(DigestUtils.md5Hex(req.getPassword()))){
            String token = UUID.randomUUID().toString().replaceAll("-","");
            redisUtil.set(user.getUsername(),token);
            return BaseResponse.OK;
        }else {
            log.error("密码错误");
            return BaseResponse.error(ErrorMessage.PARAM_ERROR);
        }
    }

    @Override
    public BaseResponse getMe(GetReq req) {

        log.info("获取个人信息");
        User user = userDao.selectByUsernameForUpdate(req.getUsername());
        if (user == null){
            log.error("用户不存在");
            return BaseResponse.error(ErrorMessage.USER_NO_PERMISSION);
        }
        String token = redisUtil.get(req.getUsername()).toString();
        if (token == null){
            log.error("用户未登录不能查看");
            return BaseResponse.error(ErrorMessage.NO_LOGIN);
        }
        System.out.println(user.toString());

        return BaseResponse.ok(user.toString());
    }
}
