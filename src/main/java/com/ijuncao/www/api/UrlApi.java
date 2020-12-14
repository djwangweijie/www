package com.ijuncao.www.api;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hutool.cron.CronUtil;
import cn.hutool.cron.pattern.CronPattern;
import cn.hutool.cron.task.Task;

/**
 * 处理url访问跳转
 * 
 * @author Administrator
 *
 */
@Controller
public class UrlApi {
	/**
	 * 处理路径请求   比如 /login
	 * @param url
	 * @return
	 */
	@RequestMapping("{url}")
	public String urlMappimng(@PathVariable("url")String url,HttpSession session) {
		if(session.getAttribute("user")!=null) {
			return url;
		}else {
			if(url.endsWith(".html")) {
				return "login";
			}
		  return  "login";
		}
	}
	/**
	 * 处理二级目录请求
	 */
	@RequestMapping("{url}/{addr}")
	public String urlMappimng(@PathVariable("url")String url,@PathVariable("addr")String addr,HttpSession session) {
		if(session.getAttribute("user")!=null) {
			return url+"/"+addr;
		}else {
			if(url.endsWith(".html")) {
				return "login";
			}
		  return  "login";
		}
	}
	
	

}
