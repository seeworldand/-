package com.tg.blog.controller;

import com.tg.blog.base.AddMessageReq;
import com.tg.blog.base.BaseResponse;
import com.tg.blog.base.UpdateMesageReq;
import com.tg.blog.model.Message;
import com.tg.blog.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classname: MessageController
 * Package: com.tg.blog.controller
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/17 23:38
 * @Version 17
 */
@Controller
@RequestMapping({"/api/posts"})
public class MessageController {
    @Autowired
    MessageService messageService;
    @PostMapping
    public BaseResponse addMessage(@Valid @RequestBody AddMessageReq req){
        return messageService.addMessage(req);
    }
    @GetMapping(params = "uid")
    public List<Message> getMessage(@RequestParam("uid") Long userId,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "sort", defaultValue = "desc") String sortDirection){
        return messageService.getMessage(userId,page,pageSize,sortDirection);
    }

    @GetMapping(params = "id")
    public Message getMessage(@RequestParam("id") Long messageId){
        return messageService.getContent(messageId);
    }
    @PutMapping(params = "id")
    public BaseResponse updateMessage(@RequestParam("id") Long messageId, @RequestBody UpdateMesageReq req){
        return messageService.updateContent(messageId,req);
    }

    @DeleteMapping(params = "id")
    public BaseResponse DeleteMessage(@RequestParam("id") Long messageId){
        return messageService.deleteContent(messageId);
    }

}
