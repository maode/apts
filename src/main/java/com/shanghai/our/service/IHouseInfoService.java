package com.shanghai.our.service;

import java.util.List;

import com.shanghai.our.model.HouseInfo;
import com.shanghai.our.model.HouseProperty;
import com.shanghai.our.model.Pager;
import com.shanghai.our.utils.ExecuteResult;

public interface IHouseInfoService {
	/**
	 * 获取所有的房源
	 * @param pageIndex
	 * @param pageSize
	 * @param houseInfo
	 * @return
	 */
	public Pager<HouseInfo>  findAll(Pager<HouseInfo> pager,HouseInfo houseInfo);
	/**
	 * 根据key检索房源
	 * @param pageIndex
	 * @param pageSize
	 * @param houseInfo
	 * @return
	 */
	public Pager<HouseInfo>  searchByKey(Pager<HouseInfo> pager,HouseInfo houseInfo);
	
	/**我发布的房源
	 * @param pager
	 * @param houseInfo
	 * @return
	 */
	public Pager<HouseInfo>  myHouse(Pager<HouseInfo> pager,HouseInfo houseInfo);
	/**
	 * 根据区域检索房源
	 * @param pageIndex
	 * @param pageSize
	 * @param houseInfo
	 * @return
	 */
	public Pager<HouseInfo>  searchByArea(Pager<HouseInfo> pager,HouseInfo houseInfo);
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
	public  ExecuteResult<String> editHouse(HouseInfo houseInfo);
	
	/**
	 * 删除房源
	 * @param id
	 */
	public void  delHouseInfo(Integer id);
	
	/**
	 * 获取所有的房屋属性
	 * @return
	 */
	public  List<HouseProperty>  findAllProperty();
	
	
	/**
	 * 根据ID获取房屋属性
	 * @param id
	 * @return
	 */
	public  HouseProperty  getPropertyId(Integer id);
	/**
	 * 根据app接口参数发布房源信息
	 * @param hpb
	 * @return
	 */
	public  ExecuteResult<String> publishHouse(HouseInfo hpb);
	
}
