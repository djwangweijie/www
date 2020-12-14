package com.ijuncao.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ijuncao.www.model.Wuser;

/**
 * 用户数据层操作
 * @author wwj
 *
 */
@Mapper
public interface WuserMapper {
    /**
     * 根据用户名和密码查询用户是否存在
     * @param username
     * @param password
     * @return
     */
	Wuser  selectUserInfo(@Param("username")String username,@Param("password")String password);
	/**
	 * 新增用户名和密码立即返回用户的uid
	 * @param newuser
	 * @param newpwd
	 * @return
	 */
	void  insertUserByNameAndPwd(Wuser  newuser);
	
	/**
	 * 检查用户存在或者重名
	 * @return
	 */
	boolean  checkUserByName(@Param("newuser")String newuser);
	
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<Wuser> selectAllUserInfo();
	
	/**
	 * 插入设备编号以及用户id 关联user_device
	 * @param sns
	 * @param uid
	 */
	boolean insertUserUidAndDeviceSn(@Param("sns")List<String> sns,@Param("uid")int uid);
	
	
	
	
	
}
