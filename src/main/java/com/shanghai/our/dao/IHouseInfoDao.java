package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.HouseInfo;

public interface IHouseInfoDao {
	
	/**
	 * 获取所有的房源
	 * @param firstResult
	 * @param maxResult
	 * @param houseInfo
	 * @return
	 */
	public List<HouseInfo>  findAll(Integer firstResult, Integer maxResult,HouseInfo houseInfo);
	/**
	 * 根据key检索房源
	 * @param firstResult
	 * @param maxResult
	 * @param houseInfo
	 * @return
	 */
	public List<HouseInfo>  searchByKey(Integer firstResult, Integer maxResult,HouseInfo houseInfo);
	/**根据key检索房源-条数
	 * @param houseInfo
	 * @return
	 */
	public Long searchByKeyCount(HouseInfo houseInfo);
	/**
	 * 获取所有房源的信息
	 * @param houseInfo
	 * @return
	 */
	public Long  findAllCount(HouseInfo houseInfo);
	
	/**
	 * 根据ID获取房源信息
	 * @param id
	 * @return
	 */
	public HouseInfo  getId(Integer id);
	
	/**
	 * 保存房源
	 * @param houseInfo
	 * @return
	 */
	public  HouseInfo  saveHouse(HouseInfo houseInfo);
	
	/**
	 * 编辑房源
	 * @param houseInfo
	 */
	public  void editHouse(HouseInfo houseInfo);
	
	/**
	 * 删除房源
	 * @param id
	 */
	public void  delHouseInfo(Integer id);
	
	
	
}
