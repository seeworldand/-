package com.tg.blog.base;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Classname: GetReq
 * Package: com.tg.blog.base
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/18 23:59
 * @Version 1.8
 */
@Data
@Accessors(chain = true)
public class GetReq implements Serializable {
    @NotNull(message = "用户名不能为空")
    private String username;


}
