package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.Province;

public interface IProvinceDao {
	
	/**
	 * 获取所有的省份
	 * @param pageIndex
	 * @param pageSize
	 * @param province
	 * @return
	 */
	public List<Province>  findAll(Integer pageIndex,Integer pageSize,Province province);
	/**
	 * 获取所有省份的信息
	 * @param province
	 * @return
	 */
	public Long  findAllCount(Province province);
	
	/**
	 * 根据ID获取省份信息
	 * @param id
	 * @return
	 */
	public Province  getId(Integer id);
	
	/**
	 * 保存省份
	 * @param province
	 * @return
	 */
	public  Province  saveProvince(Province province);
	
	/**
	 * 编辑省份
	 * @param province
	 */
	public  void editProvince(Province province);
	
	/**
	 * 删除省份
	 * @param id
	 */
	public void  delProvince(Integer id);
	
	
	
}
