package com.shanghai.our.service;

import com.shanghai.our.model.HouseHis;
import com.shanghai.our.model.Pager;


/**  
 * @Title: IHouseHisService.java
 * @Package com.shanghai.our.service
 * @Description: 房屋租住信息service
 * @author code0   
 * @date 2016年1月25日 下午4:40:14 
 */
public interface IHouseHisService {
	/**获取所有的房屋租住信息
	 * @param pager
	 * @param mod
	 * @return
	 */
	public Pager<HouseHis>  findAll(Pager<HouseHis> pager,HouseHis mod);
	
	/**
	 * 根据ID获取房屋租住信息信息
	 * @param id
	 * @return
	 */
	public HouseHis  getById(Integer id);
	
	/**
	 * 保存房屋租住信息
	 * @param mod
	 * @return
	 */
	public  HouseHis  save(HouseHis mod);
	
	/**
	 * 编辑房屋租住信息
	 * @param mod
	 */
	public  void merge(HouseHis mod);
	
	/**
	 * 删除房屋租住信息
	 * @param id
	 */
	public void  delByID(Integer id);
	

	
}
