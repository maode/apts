package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.UserInfo;

public interface IUserInfoDao {

	
	/**
	 * 查询所有的用户信息 分页 条件查询
	 * @param pageIndex
	 * @param pageSize
	 * @param userInfo
	 * @return
	 */
	public List<UserInfo>  findAll(Integer pageIndex,Integer pageSize,UserInfo userInfo);
	
	/**
	 * 获取用户总个数
	 * @param userInfo
	 * @return
	 */
	public  Long findAllCount(UserInfo userInfo);
	
	/**
	 * 根据用户ID获取改用户信息
	 * @param id
	 * @return
	 */
	public  UserInfo  getId(Integer id);
	
	/**
	 * 根据邮箱获取用户信息
	 * @param email
	 * @return
	 */
	public  UserInfo  getByEmail(String email);
	
	/**
	 * 保存用户信息
	 * @param userInfo
	 */
	public  UserInfo  saveUserInfo(UserInfo userInfo);
	
	/**
	 * 编辑用户信息
	 * @param userInfo
	 */
	public void  editUserInfo(UserInfo  userInfo);
	
	/**
	 * 删除用户信息
	 * @param id
	 */
	public void  delUserInfo(Integer id);
	
	
}
