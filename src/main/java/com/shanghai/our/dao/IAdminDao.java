package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.Admin;

public interface IAdminDao {

	/**
	 * 查询所有的管理员账号
	 * @param pageIndex
	 * @param pageSize
	 * @param admin
	 * @return
	 */
	public  List<Admin>  findAll(Integer pageIndex,Integer pageSize,Admin admin);
	
	
	/**
	 * 获取条数
	 * @param admin
	 * @return
	 */
	public  Long  findAllCount(Admin  admin);
	
	/**
	 * 查询管理员
	 * @param id
	 * @return
	 */
	public  Admin  getId(Integer id);
	
	/**
	 * 查询所有的管理员
	 * @param admin
	 */
	public  void  saveAdmin(Admin admin);
	
	
	/**
	 * 编辑用户
	 * @param admin
	 */
	public  void editAdmin(Admin admin);
	
	/**
	 * 删除管理员
	 * @param id
	 */
	public void  delAdmin(Integer id);
	
	/**
	 * 根据用户名和密码或者管理员
	 * @param userName
	 * @return
	 */
	public Admin getByUserName(String userName,String password);
	
	/**
	 * 根据用户名获取用户对象
	 * @param userName
	 * @return
	 */
	public Admin getAdminByUserName(String userName);
	
	
}
