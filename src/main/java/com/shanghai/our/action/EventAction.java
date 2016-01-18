package com.shanghai.our.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.Event;
import com.shanghai.our.service.IEventService;
import com.shanghai.our.utils.ExecuteResult;

@ParentPackage("basePackage")
@Namespace("/")
public class EventAction extends BaseAction<Event> implements ModelDriven<Event>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG=Logger.getLogger(EventAction.class);
	
	private Event mod=new Event();//参数
	
	@Autowired
	private IEventService eventService;
	
	/**
	 * 活动列表
	 */
	@Action(value="eventList",results = { @Result(name = "success", location = "/event/eventList.jsp") })
	public String eventList(){
		try{
			this.pager=this.eventService.findAll(pager, mod);
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return SUCCESS;
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
	 * 跳转到增加活动列表
	 * @return
	 */
	@Action(value = "toAddEvent", results = { @Result(name = "success", location = "/event/addEvent.jsp") })
	public String  addAdmin(){
		return SUCCESS;
	}
	/**
	 * 删除活动
	 */
	@Action(value="delEvent")
	public void delAdmin(){
		try{
			this.eventService.delByID(this.mod.getId());
			responseStr(responseJson("success","删除成功！"));
		}catch(Exception e){
			e.printStackTrace();
			responseStr(responseJson("error","删除失败！"));
		}
	}
	/**
	 * 添加活动
	 */
	@Action(value="addEvent")
	public void addEvent(){
		try{
			this.mod=this.eventService.save(mod);
			super.successResponse("添加成功");
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 跳转到编辑活动用户操作
	 * @return
	 */
	@Action(value = "toEditEvent", results = { @Result(name = "success", location = "/event/editEvent.jsp") })
	public  String  toEditAdmin(){
		this.mod=this.eventService.getById(this.mod.getId());
		super.pushModToRoot(mod);
		return SUCCESS;
	}
	
	/**
	 * 执行编辑活动信息操作
	 */
	@Action(value="editEvent")
	public void editEvent(){
		try{
			this.eventService.merge(mod);
			responseStr(responseJson("success","修改成功！"));
		}catch(Exception e){
			e.printStackTrace();
			responseStr(responseJson("error","修改失败！"));
		}
	}

	@Override
	public Event getModel() {
		return this.mod;
	}


	
}
