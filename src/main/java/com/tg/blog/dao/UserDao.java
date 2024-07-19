package com.tg.blog.dao;

import java.util.List;
import com.tg.blog.model.User;


import com.tg.blog.until.bean.CommonQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * User数据库操作接口类
 * 
 **/

@Repository
public interface UserDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	User  selectByPrimaryKey ( @Param("userId") Long userId );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("userId") Long userId );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( User record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( User record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<User> list4Page ( User record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	int count ( User record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<User> list ( User record);

	User selectByUsernameForUpdate(String username);
}