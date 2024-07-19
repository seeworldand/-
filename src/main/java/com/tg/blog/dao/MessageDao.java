package com.tg.blog.dao;

import java.util.List;
import com.tg.blog.model.Message;


import com.tg.blog.until.bean.CommonQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * Message数据库操作接口类
 * 
 **/

@Repository
public interface MessageDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Message  selectByPrimaryKey ( @Param("postId") Long postId );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("postId") Long postId );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( Message record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Message record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Message> list4Page ( Message record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	int count ( Message record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Message> list ( Message record);

}