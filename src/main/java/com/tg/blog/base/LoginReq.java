package com.tg.blog.base;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Classname: LoginReq
 * Package: com.tg.blog.base
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/18 19:06
 * @Version 17
 */
@Data
@Accessors(chain = true)
public class LoginReq implements Serializable {
    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;
}
