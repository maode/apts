package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.HouseProperty;

public interface IHousePropertyDao {

	
	/**
	 * 获取所有的房屋属性
	 * @return
	 */
	public  List<HouseProperty>  findAll();
	
	
	/**
	 * 根据ID获取房屋属性
	 * @param id
	 * @return
	 */
	public  HouseProperty  getId(Integer id);
	
}
