package com.shanghai.our.service;

import java.util.List;

import com.shanghai.our.model.HouseGenerate;
import com.shanghai.our.model.HouseInfo;
import com.shanghai.our.model.Pager;
import com.shanghai.our.utils.ExecuteResult;

public interface IHouseInfoService {
	
	/**
	 * 加载房屋概览数据
	 * @return
	 */
	public List<HouseInfo> loadHouseOverview(HouseInfo houseInfo);
	/**
	 * 获取所有的房屋
	 * @param pageIndex
	 * @param pageSize
	 * @param houseInfo
	 * @return
	 */
	public Pager<HouseInfo>  findAll(Pager<HouseInfo> pager,HouseInfo houseInfo);
	/**
	 * 根据key检索房屋
	 * @param pageIndex
	 * @param pageSize
	 * @param houseInfo
	 * @return
	 */
	public Pager<HouseInfo>  searchByKey(Pager<HouseInfo> pager,HouseInfo houseInfo);
	
	/**我发布的房屋
	 * @param pager
	 * @param houseInfo
	 * @return
	 */
	public Pager<HouseInfo>  myHouse(Pager<HouseInfo> pager,HouseInfo houseInfo);
	/**
	 * 根据区域检索房屋
	 * @param pageIndex
	 * @param pageSize
	 * @param houseInfo
	 * @return
	 */
	public Pager<HouseInfo>  searchByArea(Pager<HouseInfo> pager,HouseInfo houseInfo);
	/**
	 * 根据ID获取房屋信息
	 * @param id
	 * @return
	 */
	public HouseInfo  getId(Integer id);
	
	/**
	 * 保存房屋
	 * @param houseInfo
	 * @return
	 */
	public  HouseInfo  saveHouse(HouseInfo houseInfo);
	
	/**
	 * 更新房屋
	 * @param houseInfo
	 */
	public  ExecuteResult<String> editHouse(HouseInfo houseInfo);
	/**
	 * 批量生成房屋
	 * @param houseInfo
	 */
	public  ExecuteResult<String> generateHouse(HouseGenerate hg);
	
	/**
	 * 删除房屋
	 * @param id
	 */
	public void  delHouseInfo(Integer id);
	

	
}
