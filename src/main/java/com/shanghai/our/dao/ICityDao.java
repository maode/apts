package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.City;

public interface ICityDao {
	
	/**
	 * 获取所有的城市
	 * @param pageIndex
	 * @param pageSize
	 * @param city
	 * @return
	 */
	public List<City>  findAll(Integer pageIndex,Integer pageSize,City city);
	/**
	 * 获取所有城市的信息
	 * @param city
	 * @return
	 */
	public Long  findAllCount(City city);
	
	/**
	 * 根据ID获取城市信息
	 * @param id
	 * @return
	 */
	public City  getId(Integer id);
	
	/**
	 * 保存城市
	 * @param city
	 * @return
	 */
	public  City  saveCity(City city);
	
	/**
	 * 编辑城市
	 * @param city
	 */
	public  void editCity(City city);
	
	/**
	 * 删除城市
	 * @param id
	 */
	public void  delCity(Integer id);
	
	
	
}
