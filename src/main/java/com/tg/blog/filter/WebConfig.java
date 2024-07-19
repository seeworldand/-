package com.tg.blog.filter;

/**
 * Classname: WebConfig
 * Package: com.tg.blog.filter
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/19 11:20
 * @Version 1.8
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RedisTokenInterceptor redisTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(redisTokenInterceptor).addPathPatterns("/auth/me");
    }
}
