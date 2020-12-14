package com.ijuncao.www.service;

import java.util.Map;

/**
 * 设备服务接口
 * @author Administrator
 *
 */
public interface DeviceService {

	/**
	 * 根据用户的id获取设备信息
	 * @param uid 用户的id
	 * @return
	 */
	public Map<String,Object> getDeviceInfoByUid(int page,int limit,int uid);
}
