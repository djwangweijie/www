package com.ijuncao.www.api;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijuncao.www.model.Wuser;
import com.ijuncao.www.service.DeviceService;
import com.ijuncao.www.service.UserService;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.crypto.digest.DigestUtil;

/**
 * 归属登录api
 * @author Administrator
 *
 */
@Controller
public class UserApi {
	
	@Autowired
	private  UserService  userService;
	
	@Autowired
	private  DeviceService  deviceService;
	
 
    /**
     * 获取图形验证码
     * @param response  返回图形验证码流
     */
	@RequestMapping("/getImageCode")
	public void  getImageCodeApi(HttpServletResponse  response,HttpSession session) {
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
		session.setAttribute("ImageCode", captcha.getCode());
		OutputStream osOut = null;
		try {
		    osOut = response.getOutputStream();
			captcha.write(osOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 try {
				osOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 登录检验
	 * @param username 用户名
	 * @param password 密码
	 * @param captchaCode 图形验证码
	 * @param session 存放用户信息的session
	 * @return
	 */
	@RequestMapping("/userLogin")
	@ResponseBody
	public Map<String,Object> userLoginApi(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("captcha")String captchaCode,HttpSession session){
		Map<String,Object>  msg = new HashMap<String, Object>();
		if(captchaCode.equals(session.getAttribute("ImageCode"))) {
			msg = userService.verifyUserInfo(username, password, session);
		}else {
			msg.put("code", 0);
			msg.put("info", "验证码错误,请重新刷新");
		}
		return msg;
	}
	
	/**
	 * 获取创建用户信息反馈
	 * @param newuser  新用户名
	 * @param newpwd   密码
	 * @param session  用于存储创建的用户id
	 * @return
	 */
	@RequestMapping("/createUser")
	@ResponseBody
	public Map<String,Object> userCreateApi(@RequestParam("newuser")String newuser,@RequestParam("newpwd")String newpwd,HttpSession session){
		return userService.createUser(newuser, newpwd, session);
		
		
	}
	/**
	 * 配置用户功能
	 * @param ids 更新功能列表
	 * @param session  存在session的用户id
	 * @return
	 */
	@RequestMapping("/updateFunction")
	@ResponseBody
	public Map<String,Object> updateFunctionApi(@RequestParam("ids")Integer[] ids,HttpSession session){
		Wuser u = (Wuser) session.getAttribute("newuser");
		return userService.updateFunction(ids, u.getUid());
	}
	
	/**
	 * 获取用户列表
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/getUserList")
	@ResponseBody
	public Map<String,Object>  getUserListApi(@RequestParam("page")int page,@RequestParam("limit")int limit){
		
		return userService.getAllUserInfo(page, limit);
		
	}
	/**
	 * 获取用户可授权的设备
	 * @param page
	 * @param limit
	 * @param uid
	 * @return
	 */
	@RequestMapping("/getUserDevice")
	@ResponseBody
	public Map<String,Object>  getUserDeviceApi(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("uid") int uid){
		
		return deviceService.getDeviceInfoByUid(page, limit, uid);
		
	}
	/**
	 * 
	 * @param ids
	 * @param session
	 * @return
	 */
	@RequestMapping("/userAuthDevice")
	@ResponseBody
	public Map<String,Object> userAuthDevice(@RequestParam("ids")List<String> sns,@RequestParam("uid")Integer uid){
		
		return userService.userAuthDevice(sns, uid);
	}
	
	
	
	
}
