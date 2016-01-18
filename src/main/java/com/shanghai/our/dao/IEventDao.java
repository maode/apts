package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.Event;
import com.shanghai.our.utils.IBaseDao;

public interface IEventDao extends IBaseDao<Event> {
	/**
	 * 获取所有的活动
	 * @param firstResult
	 * @param maxResult
	 * @param houseInfo
	 * @return
	 */
	public List<Event>  findAll(Integer firstResult, Integer maxResult,Event event);
	/**获取所有的活动-条数
	 * @param event
	 * @return
	 */
	public Long  findAllCount(Event event);
	/**活动报名
	 * @param event
	 * @return
	 */
	public void eventEnroll(Event event);

}
