package com.shanghai.our.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.HouseHis;
import com.shanghai.our.service.IHouseHisService;

@ParentPackage("basePackage")
@Namespace("/houseInfo")
public class HouseHisAction extends BaseAction<HouseHis> implements ModelDriven<HouseHis>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG=Logger.getLogger(HouseHisAction.class);
	
	private HouseHis mod=new HouseHis();//参数
	
	@Autowired
	private IHouseHisService houseHisService;
	
	/**
	 * 租房信息列表
	 */
	@Action(value="houseHisList",results = { @Result(name = "success", location = "/houseHis/houseHisList.jsp") })
	public String houseHisList(){
		try{
			this.pager=this.houseHisService.findAll(pager, mod);
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	/**
	 * 跳转到增加租房信息列表
	 * @return
	 */
	@Action(value = "toAddHouseHis", results = { @Result(name = "success", location = "/houseInfo/addHouseHis.jsp") })
	public String  addAdmin(){
		if(this.mod.getId()!=null){
			this.mod=this.houseHisService.getById(this.mod.getId());
			super.pushModToRoot(mod);
		}
		return SUCCESS;
	}
	/**
	 * 删除租房信息
	 */
	@Action(value="delHouseHis")
	public void delAdmin(){
		try{
			this.houseHisService.delByID(this.mod.getId());
			responseStr(responseJson("success","删除成功！"));
		}catch(Exception e){
			e.printStackTrace();
			responseStr(responseJson("error","删除失败！"));
		}
	}
	/**
	 * 添加租房信息
	 */
	@Action(value="addHouseHis")
	public void addHouseHis(){
		try{
			this.mod=this.houseHisService.save(mod);
			super.successResponse("添加成功");
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 跳转到编辑租房信息用户操作
	 * @return
	 */
	@Action(value = "toEditHouseHis", results = { @Result(name = "success", location = "/houseHis/editHouseHis.jsp") })
	public  String  toEditAdmin(){
		this.mod=this.houseHisService.getById(this.mod.getId());
		super.pushModToRoot(mod);
		return SUCCESS;
	}
	
	/**
	 * 执行编辑租房信息信息操作
	 */
	@Action(value="editHouseHis")
	public void editHouseHis(){
		try{
			this.houseHisService.merge(mod);
			responseStr(responseJson("success","修改成功！"));
		}catch(Exception e){
			e.printStackTrace();
			responseStr(responseJson("error","修改失败！"));
		}
	}

	@Override
	public HouseHis getModel() {
		return this.mod;
	}


	
}
