package com.tg.blog.base;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Classname: AddMessageReq
 * Package: com.tg.blog.base
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/19 0:30
 * @Version 1.8
 */
@Data
@Accessors(chain = true)
public class AddMessageReq implements Serializable {
    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "title不能为空")
    private String title;

    @NotNull(message = "content不能为空")
    private String content;
}
