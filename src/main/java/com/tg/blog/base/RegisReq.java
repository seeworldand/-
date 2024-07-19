package com.tg.blog.base;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;


import java.io.Serializable;

/**
 * Classname: RegisReq
 * Package: com.bmw.seed.util.bean
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/1/29 12:04
 * @Version 17
 */
@Data
@Accessors(chain = true)
public class RegisReq implements Serializable {
    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;

    @NotNull(message = "邮箱不能为空")
    private String email;


}
