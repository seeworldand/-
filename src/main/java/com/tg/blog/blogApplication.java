package com.tg.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Classname: blogApplication
 * Package: com.tg.blog
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/18 19:42
 * @Version 1.8
 */
@SpringBootApplication
@EnableScheduling
@MapperScan(value = "com.tg.blog.dao")
public class blogApplication {
    public static void main(String[] args) {
        SpringApplication.run(blogApplication.class,args);
    }
}
