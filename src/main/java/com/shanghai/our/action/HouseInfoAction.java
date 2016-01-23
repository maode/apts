package com.shanghai.our.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.HouseGenerate;
import com.shanghai.our.model.HouseInfo;
import com.shanghai.our.service.IHouseInfoService;
import com.shanghai.our.utils.ExecuteResult;

@ParentPackage("basePackage")
@Namespace("/houseInfo")
public class HouseInfoAction extends BaseAction<HouseInfo> implements ModelDriven<HouseInfo>{

	
	private static final long serialVersionUID = 1L;

	private static final Logger LOG=Logger.getLogger(HouseInfoAction.class);
	
	private HouseInfo mod=new HouseInfo();
	private HouseGenerate houseGenerate;
	private List<HouseInfo> houseList;
	
	
	@Autowired
	private IHouseInfoService houseInfoService;
	
	
	@Action(value="overviewContent", results = { @Result(name = "overviewContent", location = "/houseInfo/overview-content.jsp") })
	public String overviewContent(){
		this.houseList=this.houseInfoService.loadHouseOverview(mod);
		return "overviewContent";
	}
	/**
	 * 房屋概览
	 */
	@Action(value="overview", results = { @Result(name = "overview", location = "/houseInfo/overview.jsp") })
	public String overview(){
		return "overview";
	}
	/**
	 * 房屋管理界面
	 * @return
	 */
	@Action(value="houseList", results = { @Result(name = "houseList", location = "/houseInfo/houseList.jsp") })
	public String  houseList(){
		this.pager=this.houseInfoService.findAll(pager, this.mod);
		return "houseList";
	}
	
	
	/**
	 * 跳转到生成房屋信息界面
	 * @return
	 */
	@Action(value="generateHouse", results = { @Result(name = "generateHouse", location = "/houseInfo/generateHouse.jsp") })
	public String   generateHouse(){
		return "generateHouse";
	}
	
	/**
	 * 生成房屋信息
	 */
	@Action(value="generateHouseDo")
	public void  generateHouseDo(){
		try{
			 ExecuteResult<String> result=this.houseInfoService.generateHouse(houseGenerate);
			 if(result.isSuccess()){
					super.successResponse("");
				}else{
					super.faileResponse(result.getResult());
				}
		}catch(Exception e){
			e.printStackTrace();
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 跳转到添加房屋信息界面
	 * @return
	 */
	@Action(value="addHouse", results = { @Result(name = "addHouse", location = "/houseInfo/addHouse.jsp") })
	public String   addHouse(){
		return "addHouse";
	}
	
	/**
	 * 添加房屋信息
	 */
	@Action(value="addHouseDo")
	public void  addHouseDo(){
		try{
//			ExecuteResult<String> result=this.houseInfoService.publishHouse(this.mod);
//			if(result.isSuccess()){
//				super.successResponse("");
//			}else{
//				super.faileResponse(result.getResult());
//			}
		}catch(Exception e){
			e.printStackTrace();
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 保存编辑后的房屋
	 */
	@Action(value="editHouseDo")
	public void  editHouseDo(){
		try{
			ExecuteResult<String> result=this.houseInfoService.editHouse(this.mod);
			if(result.isSuccess()){
				super.successResponse("");
			}else{
				super.faileResponse(result.getResult());
			}
		}catch(Exception e){
			e.printStackTrace();
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	
	/**
	 * 跳转到房屋编辑界面
	 * @return
	 */
	@Action(value="editHouse", results = { @Result(name = "editHouse", location = "/houseInfo/editHouse.jsp") })
	public String  editHouse(){
		this.mod=this.houseInfoService.getId(this.mod.getId());
		super.pushModToRoot(this.mod);
		return "editHouse";
	}	
	/**
	 * 删除房屋
	 */
	@Action(value="delHouse")
	public void delHouse(){
		
		
	}

	@Override
	public HouseInfo getModel() {
		return this.mod;
	}
	/** @return houseGenerate */
	public HouseGenerate getHouseGenerate() {
		return houseGenerate;
	}
	/** @param houseGenerate 要设置的 houseGenerate */
	public void setHouseGenerate(HouseGenerate houseGenerate) {
		this.houseGenerate = houseGenerate;
	}
	/** @return houseList */
	public List<HouseInfo> getHouseList() {
		return houseList;
	}
	/** @param houseList 要设置的 houseList */
	public void setHouseList(List<HouseInfo> houseList) {
		this.houseList = houseList;
	}




	
}
