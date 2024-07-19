package com.tg.blog.base;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Classname: UpdateMesageReq
 * Package: com.tg.blog.base
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/19 10:40
 * @Version 1.8
 */
@Data
@Accessors(chain = true)
public class UpdateMesageReq implements Serializable {

    private String title;


    private String content;



}
