package com.tg.blog.service.impl;

import com.tg.blog.base.AddMessageReq;
import com.tg.blog.base.BaseResponse;
import com.tg.blog.base.LoginReq;
import com.tg.blog.base.UpdateMesageReq;
import com.tg.blog.dao.MessageDao;
import com.tg.blog.dao.UserDao;
import com.tg.blog.model.Message;
import com.tg.blog.model.User;
import com.tg.blog.service.MessageService;
import com.tg.blog.until.ErrorMessage;
import com.tg.blog.until.RedisUtil;
import com.tg.blog.until.bean.CommonQueryBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Classname: MessageServiceImpl
 * Package: com.tg.blog.service.impl
 * Description:
 *
 * @Author 王少伟
 * @Create 2024/7/17 23:41
 * @Version 17
 */
@Service("messageService")
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Autowired
    UserDao userDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    RedisUtil redisUtil;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse addMessage(AddMessageReq req) {
       log.info("添加一篇文章");
       String token = redisUtil.get(req.getUsername()).toString();
       if(token == null){
           log.error("用户未登录");
           return BaseResponse.error(ErrorMessage.NO_LOGIN);
       }
        User user = userDao.selectByUsernameForUpdate(req.getUsername());
        Message message = new Message();
        Date date = new Date();
        message.setTitle(req.getTitle());
        message.setContent(req.getContent());
        message.setUserId(user.getUserId());
        message.setCreated(date);
        message.setLastModified(date);
        messageDao.insert(message);
        return BaseResponse.OK;
    }

    @Override
    public List<Message> getMessage(Long userId, int page, int pageSize, String sortDirection) {
        User user = userDao.selectByPrimaryKey(userId);
        if (user == null){
            log.error("用户不存在");
            return null;
        }
        Message message =new Message();
        message.setUserId(userId);
        CommonQueryBean commonQueryBean = new CommonQueryBean();
        commonQueryBean.setStart(page);
        commonQueryBean.setOrder("created");
        commonQueryBean.setSort(sortDirection);
        commonQueryBean.setPageSize(pageSize);

        List<Message> list = messageDao.list4Page(message,commonQueryBean);

        return list;
    }

    @Override
    public Message getContent(Long messageId) {
        log.info("调用查询接口");
        Message message = messageDao.selectByPrimaryKey(messageId);
        if (message == null){
            log.error("文章不存在");
            return null;
        }
        return message;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse updateContent(Long messageId, UpdateMesageReq req) {
        log.info("调用修改接口");
        Message message = messageDao.selectByPrimaryKey(messageId);
        if (message == null){
            log.error("文章不存在");
            return null;
        }
        Message message1 = new Message();
        if (req.getContent() == null && req.getContent() == ""){
            message1.setContent(message.getContent());
        }else{
            message1.setContent(req.getContent());
        }


        if (req.getTitle() == null && req.getTitle() == ""){
            message1.setTitle(message.getTitle());
        }else{
            message1.setContent(req.getTitle());
        }
        Date date = new Date();
        message1.setUserId(message.getUserId());
        message1.setCreated(message.getCreated());
        message1.setLastModified(date);
        message1.setUserId(message.getUserId());
        message1.setPostId(message.getPostId());
        messageDao.updateByPrimaryKeySelective(message1);
        return BaseResponse.OK;
    }

    @Override
    public BaseResponse deleteContent(Long messageId) {
        log.info("删除功能");
        Message message = messageDao.selectByPrimaryKey(messageId);
        if (message == null){
            log.error("文章不存在");
            return BaseResponse.error(ErrorMessage.PARAM_ERROR);
        }
        messageDao.deleteByPrimaryKey(messageId);

        return BaseResponse.OK;
    }


}
