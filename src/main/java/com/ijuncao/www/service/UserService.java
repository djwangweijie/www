package com.ijuncao.www.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
/**
 * 用户服务
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * 检验用户   
	 * @param username  名字
	 * @param password  密码
	 * @param seesion  用作保留用户基本信息
	 * @return
	 */
	Map<String,Object> verifyUserInfo(String username,String password,HttpSession seesion);
	
	
	/**
	 * 根据用户id获取功能列表
	 * @param uid
	 * @return
	 */
	public Map<String,Object> getFunctionByUid(int uid);
	
	/**
	 * 获取所有功能
	 * @return
	 */
	public Map<String,Object> getFunction();
	
	/**
	 * 创建新用户
	 * @param newuser  用户名
	 * @param newpwd	密码
	 * @param session  用于存储新用户的uid
	 * @return
	 */
	public Map<String,Object> createUser(String newuser,String newpwd,HttpSession session);
	
	/**
	 * 批量更新某个用户的功能列表
	 * @param ids
	 * @param userid
	 * @return
	 */
	public Map<String,Object> updateFunction(Integer[] ids,int userid);
	
	/**
	 * 获取所有的用户信息
	 * @return
	 */
	public Map<String,Object> getAllUserInfo(int page,int limit);
	
	/**
	 * 授权用户设备
	 * @param sns 
	 * @param uid
	 * @return
	 */
	public Map<String,Object>  userAuthDevice(List<String> sns,int uid);
	
}
