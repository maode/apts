package com.shanghai.our.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.HouseInfo;
import com.shanghai.our.service.IHouseInfoService;
import com.shanghai.our.utils.ExecuteResult;

@ParentPackage("appPackage")
@Namespace("/houseInfo")
public class HouseInfoAppAction extends AppBaseAction<HouseInfo> implements ModelDriven<HouseInfo>{

	private static final Logger LOG=Logger.getLogger(HouseInfoAppAction.class);
	
	private HouseInfo mod=new HouseInfo();//房源发布参数
	
	
	
	
	
	
	@Autowired
	private IHouseInfoService houseInfoService;
	
	/**
	 * 房源列表
	 */
	@Action(value="searchByKey")
	public void searchByKey(){
		try{
			this.pager=this.houseInfoService.searchByKey(pager, this.mod);
			super.successResponse(pager);
		}catch(Exception e){
			LOG.error(e.getMessage());
			 super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 房屋列表详细
	 */
	@Action(value="houseList")
	public void houseList(){
		try{
			this.pager=this.houseInfoService.findAll(pager, mod);
			super.successResponse(pager);
		}catch(Exception e){
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 我发布的房源
	 */
	@Action(value="myHouse")
	public void myHouse(){
		try{
			this.pager=this.houseInfoService.myHouse(pager, this.mod);
			super.successResponse(pager);
		}catch(Exception e){
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 房源地图定位列表
	 */
	@Action(value="searchByArea")
	public void searchByArea(){
		try{
			this.pager=this.houseInfoService.findAll(pager, this.mod);
			super.successResponse(pager);
		}catch(Exception e){
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}

	/**
	 * 房屋详细
	 */
	@Action(value="houseDetail")
	public void houseDetail(){
		try{
			HouseInfo houseInfo=this.houseInfoService.getId(this.mod.getId());
			if(houseInfo!=null){
				super.successResponse(houseInfo);
			}else{
				super.faileResponse("房屋信息不存在");
			}
			
		}catch(Exception e){
			 super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 发布房源
	 */
	@Action(value="publishHouse")
	public void publishHouse(){
		try{
			ExecuteResult<String> result=this.houseInfoService.publishHouse(mod);
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
	


	@Override
	public HouseInfo getModel() {
		return this.mod;
	}




	
}
