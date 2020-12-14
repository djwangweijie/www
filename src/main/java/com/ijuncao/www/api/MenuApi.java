package com.ijuncao.www.api;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijuncao.www.model.Wuser;
import com.ijuncao.www.service.UserService;
/**
 * 功能列表api
 * @author wwj
 *
 */
@RestController
public class MenuApi {
	@Autowired
	private UserService  userService;
	/**
	 * 初始化用户功能菜单
	 * @param session  从seesion获取用户的id
	 * @return
	 */
	@RequestMapping("initMenu")
	public Map<String,Object> getMenusApi(HttpSession session){
		Wuser  cuser = (Wuser) session.getAttribute("user"); 
		return userService.getFunctionByUid(cuser.getUid());
	}
	/**
	 * 获取功能菜单(树结构方式呈现)
	 * @return
	 */
	@RequestMapping("getMenuTree")
	public Map<String,Object> getMenusTreeApi(){
		return  userService.getFunction();
	}

}
