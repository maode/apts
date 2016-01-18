package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.HouseInfoItem;

public interface IHouseInfoItemDao {
	
	/**查询用户的租房历史
	 * @param firstResult
	 * @param maxResult
	 * @param userID
	 * @return
	 */
	public List<HouseInfoItem>  searchByUserID(Integer firstResult, Integer maxResult,int userID);
	/**查询用户的租房历史
	 * @param userID
	 * @return
	 */
	public Long  searchByUserIDCount(int userID);
	/**
	 * 根据ID获取订单信息
	 * @param id
	 * @return
	 */
	public HouseInfoItem  getId(Integer id);
	/**
	 * 保存订单
	 * @param houseItem
	 * @return
	 */
	public HouseInfoItem saveHouseItem(HouseInfoItem houseItem);
	/**
	 * 编辑订单
	 * @param houseInfo
	 */
	public  void editHouseItem(HouseInfoItem houseItem);
	
	/**
	 * 删除订单
	 * @param id
	 */
	public void  delHouseInfoItem(Integer id);
	

}
