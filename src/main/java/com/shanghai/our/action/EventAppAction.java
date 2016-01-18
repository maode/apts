package com.shanghai.our.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.Event;
import com.shanghai.our.service.IEventService;
import com.shanghai.our.utils.ExecuteResult;

@ParentPackage("appPackage")
@Namespace("/event")
public class EventAppAction extends AppBaseAction<Event> implements ModelDriven<Event>{

	private static final Logger LOG=Logger.getLogger(EventAppAction.class);
	
	private Event mod=new Event();//参数
	
	@Autowired
	private IEventService eventService;
	
	/**
	 * 活动列表
	 */
	@Action(value="eventList")
	public void eventList(){
		try{
			this.pager=this.eventService.findAll(pager, mod);
			super.successResponse(pager);
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 活动报名
	 */
	@Action(value="eventEnroll")
	public void eventEnroll(){
		try{
			ExecuteResult<String>  result=this.eventService.eventEnroll(mod);
			if(result.isSuccess()){
				super.successResponse("");
			}else{
				super.faileResponse(result.getResult());
			}
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 添加活动
	 */
	@Action(value="addEvent")
	public void addEvent(){
		try{
			this.mod=this.eventService.save(mod);
			super.successResponse(this.mod);
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}

	@Override
	public Event getModel() {
		return this.mod;
	}


	
}
