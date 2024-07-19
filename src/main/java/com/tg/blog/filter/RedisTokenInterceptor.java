package com.tg.blog.filter;

/**
 * Classname: RedisTokenInterceptor
 * Package: com.tg.blog.filter
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/19 11:20
 * @Version 1.8
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RedisTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate; // RedisTemplate，假设已经配置好


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求中获取用户名
        String username = request.getParameter("username"); // 假设从请求参数中获取用户名

        // 从 Redis 中获取 token
        String token = redisTemplate.opsForValue().get(username);

        if (token != null) {
            // 如果 token 存在，则继续执行请求
            return true;
        } else {
            // 如果 token 不存在，则返回未授权状态
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}
