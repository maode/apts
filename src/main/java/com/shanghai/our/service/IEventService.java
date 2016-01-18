package com.shanghai.our.service;

import com.shanghai.our.model.Event;
import com.shanghai.our.model.Pager;
import com.shanghai.our.utils.ExecuteResult;

public interface IEventService {
	/**获取所有的活动
	 * @param pager
	 * @param mod
	 * @return
	 */
	public Pager<Event>  findAll(Pager<Event> pager,Event mod);
	
	/**活动报名
	 * @param mod
	 * @return
	 */
	public ExecuteResult<String> eventEnroll(Event mod);

	/**
	 * 根据ID获取活动信息
	 * @param id
	 * @return
	 */
	public Event  getById(Integer id);
	
	/**
	 * 保存活动
	 * @param mod
	 * @return
	 */
	public  Event  save(Event mod);
	
	/**
	 * 编辑活动
	 * @param mod
	 */
	public  void merge(Event mod);
	
	/**
	 * 删除活动
	 * @param id
	 */
	public void  delByID(Integer id);
	

	
}
