package com.ijuncao.www.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ijuncao.www.mapper.UserFunctionMapper;
import com.ijuncao.www.mapper.WuserMapper;
import com.ijuncao.www.model.Wuser;
import com.ijuncao.www.service.UserService;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;


@Service
public class UserServiceImpl implements UserService{
	
	 	@Autowired
	    private  WuserMapper  wuserMapper;
		@Autowired
		private  UserFunctionMapper  userFunctionMapper;
		@Override
		public Map<String, Object> verifyUserInfo(String username, String password,HttpSession  seesion) {
			/**
			 * 对用户密码进行加密
			 */
			Map<String, Object> msg = new  HashMap<String, Object>();
			Digester md5 = new Digester(DigestAlgorithm.MD5);
			String passwordMD5 = md5.digestHex(password);
			Wuser user = wuserMapper.selectUserInfo(username, passwordMD5);
			if(user==null) {
				msg.put("code", 0);
				msg.put("info", "用户名或密码错误,请重新登录");
			}else {
				seesion.setAttribute("user", user);
				msg.put("code", 1);
				msg.put("info", "登录成功");
			}
			return msg;
		}
		
		
		

		@Override
		public Map<String, Object> getFunctionByUid(int uid) {
			// TODO Auto-generated method stub
			Map<String, Object> menus = new HashMap<String, Object>();
			Map<String, String> homeInfo = new HashMap<String, String>();
			Map<String, String> logoInfo = new HashMap<String, String>();
			homeInfo.put("title", "首页");
			homeInfo.put("href", "index/welcome");
			logoInfo.put("title", "菌草管理系统");
			logoInfo.put("image", "/static/images/logo.png");
			logoInfo.put("href", "page/welcome-3");
			menus.put("homeInfo", homeInfo);
			menus.put("logoInfo", logoInfo);
			menus.put("menuInfo", userFunctionMapper.selectFuctionByUid(-1, uid));
			return menus;
		}




		@Override
		@Transactional
		public Map<String, Object> createUser(String newuser, String newpwd, HttpSession session) {
			//1.密码加密
			Map<String, Object> msg = new  HashMap<String, Object>();
			Digester md5 = new Digester(DigestAlgorithm.MD5);
			String passwordMD5 = md5.digestHex(newpwd);
			if(!wuserMapper.checkUserByName(newuser)) {
				//2.创建新用户,立即返回uid
				Wuser  user = new Wuser(newuser,passwordMD5);
			    wuserMapper.insertUserByNameAndPwd(user);
			    //3.用户新增成功.同时为用户设置所有功能,默认为关闭
			    if(user.getUid()>0) {
			    	List<Integer> fids = userFunctionMapper.selectAllFunctionOfId();
			    	userFunctionMapper.insertFunctionWithUid(user.getUid(), fids);
			    	session.setAttribute("newuser", user);
			    	msg.put("code", 1);
			    	msg.put("info","创建用户成功");
			    }else {
			    	msg.put("code", 0);
			    	msg.put("info","创建用户失败");
			    }
			}else {
				msg.put("code", 0);
		    	msg.put("info","用户已经存在或重复");
			}
	
			return msg;
		}




		@Override
		public Map<String, Object> getFunction() {
			// TODO Auto-generated method stub
			Map<String, Object> msg = new  HashMap<String, Object>();
			msg.put("code", 0);
			msg.put("msg", "");
			msg.put("data", userFunctionMapper.selectAllFunction());
			return msg;
		}




		@Override
		@Transactional
		public Map<String, Object> updateFunction(Integer[] ids, int userid) {
			Map<String, Object> msg = new  HashMap<String, Object>();
			int rs = userFunctionMapper.updateUserFunction(userid, ids);
			if(rs==1) {
				msg.put("code", 1);
				msg.put("info", "配置成功");
			}else {
				msg.put("code", 0);
				msg.put("info", "配置失败");
			}
			return msg;
		}




		@Override
		public Map<String, Object> getAllUserInfo(int page,int limit) {
			Map<String, Object> msg = new  HashMap<String, Object>();
			PageHelper.startPage(page, limit);
			List<Wuser> users = wuserMapper.selectAllUserInfo();
			PageInfo<Wuser> userspage = new PageInfo<>(users);
			msg.put("code", 0);
			msg.put("msg", "");
			msg.put("count", userspage.getTotal());
			msg.put("data", userspage.getList());
			return msg;
		}




		@Override
		@Transactional
		public Map<String, Object> userAuthDevice(List<String> sns, int uid) {
			Map<String, Object> msg = new  HashMap<String, Object>();
			boolean  flag = wuserMapper.insertUserUidAndDeviceSn(sns, uid);
			if(flag) {
				msg.put("code", 1);
				msg.put("info", "设备授权成功");
			}else {
				msg.put("code", 0);
				msg.put("info", "设备授权失败");
			}
			return msg;
		}


}
