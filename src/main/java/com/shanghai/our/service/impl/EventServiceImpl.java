/**
 * 
 */
package com.shanghai.our.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanghai.our.dao.IEventDao;
import com.shanghai.our.model.Event;
import com.shanghai.our.model.Pager;
import com.shanghai.our.service.IEventService;
import com.shanghai.our.utils.ExecuteResult;

/**
 * @author code0
 *
 */
@Service("eventService")
public class EventServiceImpl implements IEventService {
	@Autowired
	private IEventDao eventDao;

	@Override
	public Pager<Event> findAll(Pager<Event> pager, Event mod) {
		List<Event> his= this.eventDao.findAll(pager.getFirstResult(), pager.getMaxResult(), mod);
		Long total=this.eventDao.findAllCount(mod);
		pager.setRecords(his);
		pager.setTotalRecords(total);
		return pager;
	}

	@Override
	public Event getById(Integer id) {
		return this.eventDao.findByID(id);
	}

	@Override
	public Event save(Event mod) {
		return this.eventDao.save(mod);
	}

	@Override
	public void merge(Event mod) {
		this.eventDao.mergry(mod);
		
	}

	@Override
	public void delByID(Integer id) {
		this.eventDao.deleteByID(id);
	}

	@Override
	public ExecuteResult<String> eventEnroll(Event mod) {
		ExecuteResult<String> result=new ExecuteResult<String>();
		//检查是否重复报名
		Long num=this.eventDao.findAllCount(mod);
		if(num>0){
			result.setResult("你已经报名过，不能重复报名");
		}else{
			if(mod.getUserID()!=null&&mod.getId()!=null){
				this.eventDao.eventEnroll(mod);
				result.setSuccess(true);
			}else{
				result.setResult("用户id或活动id为空");
			}
		}
		return result;
	}}
