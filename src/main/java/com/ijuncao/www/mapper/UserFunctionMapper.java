package com.ijuncao.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ijuncao.www.model.Function;
import com.ijuncao.www.model.FunctionVo;

@Mapper
public interface UserFunctionMapper {
	/**
	 * 根据用户id查找功能
	 * @param pid  -1 根节点开始寻找
	 * @param uid  用户id
	 * @return
	 */
	List<Function> selectFuctionByUid(@Param("pid")int pid,@Param("uid")int uid);
	/**
	 * 查询所有功能id
	 * @return
	 */
	List<Integer> selectAllFunctionOfId();
	/**
	 * 插入功能给对应的用户
	 * @param uid 用户id
	 * @param list  功能id列表
	 */
	void  insertFunctionWithUid(@Param("uid")int uid, @Param("fids")List<Integer> fids);
	
	/**
	 * 获取功能列表详细信息
	 * @return
	 */
	List<FunctionVo> selectAllFunction();
	
	/**
	 * 对用户功能进行更新
	 * @param uid	更新用户的id
	 * @param fids  需要更新的列表
	 * @return  更新的条数
	 */
	int  updateUserFunction(@Param("uid")int uid, @Param("fids")Integer[] fids);

}
