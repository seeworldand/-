package com.tg.blog.service;

import com.tg.blog.base.AddMessageReq;
import com.tg.blog.base.BaseResponse;
import com.tg.blog.base.UpdateMesageReq;
import com.tg.blog.model.Message;

import java.util.List;

/**
 * Classname: MessageService
 * Package: com.tg.blog.service
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/17 23:40
 * @Version 17
 */
public interface MessageService {
    BaseResponse addMessage(AddMessageReq req);


    List<Message> getMessage(Long userId, int page, int pageSize, String sortDirection);

    Message getContent(Long messageId);


    BaseResponse updateContent(Long messageId, UpdateMesageReq req);

    BaseResponse deleteContent(Long messageId);
}
