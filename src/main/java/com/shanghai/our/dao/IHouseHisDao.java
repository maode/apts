package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.HouseHis;
import com.shanghai.our.utils.IBaseDao;

public interface IHouseHisDao extends IBaseDao<HouseHis> {
	/**
	 * 获取所有的租房信息
	 * @param firstResult
	 * @param maxResult
	 * @param houseInfo
	 * @return
	 */
	public List<HouseHis>  findAll(Integer firstResult, Integer maxResult,HouseHis houseHis);
	/**获取所有的租房信息-条数
	 * @param houseHis
	 * @return
	 */
	public Long  findAllCount(HouseHis houseHis);

}
