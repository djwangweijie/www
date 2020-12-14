package com.ijuncao.www.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ijuncao.www.mapper.DeviceMapper;
import com.ijuncao.www.model.Device;
import com.ijuncao.www.model.Wuser;
import com.ijuncao.www.service.DeviceService;

import cn.hutool.json.JSONUtil;
@Service
public class DeviceServiceImpl implements DeviceService{
	
	@Autowired
	private  DeviceMapper  deviceMapper;

	@Override
	public Map<String, Object> getDeviceInfoByUid(int page,int limit,int uid) {
		// TODO Auto-generated method stub
		List<String> sns = deviceMapper.selectSnbyUid(uid);
		Map<String, Object> msg = new  HashMap<String, Object>();
		PageHelper.startPage(page, limit);
		List<Device> devices = deviceMapper.selectDeviceInfo(sns);
		PageInfo<Device> userspage = new PageInfo<>(devices);
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count", userspage.getTotal());
		msg.put("data", userspage.getList());
		return msg;
	}

}
