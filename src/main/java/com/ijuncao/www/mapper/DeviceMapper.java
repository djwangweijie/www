package com.ijuncao.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ijuncao.www.model.Device;
/**
 * 处理设备信息的操作层
 * @author Administrator
 *
 */
@Mapper
public interface DeviceMapper {
	/**
	 * 插入设备列表
	 * @param list
	 */
	void insertDeviceInfo(List<Device> list);
	
	/**
	 * 根据用户id 从关联表中查找设备编号
	 * @param uid
	 * @return
	 */
	List<String>  selectSnbyUid(int uid);
	/**
	 * 根据设备编号查找信息
	 * @param list
	 * @return
	 */
	List<Device>  selectDeviceInfo(List<String> list);

}
