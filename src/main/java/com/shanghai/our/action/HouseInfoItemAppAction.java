package com.shanghai.our.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.HouseInfoItem;
import com.shanghai.our.service.IHouseInfoItemService;

@ParentPackage("appPackage")
@Namespace("/houseInfoItem")
public class HouseInfoItemAppAction extends AppBaseAction<HouseInfoItem> implements ModelDriven<HouseInfoItem>{

	private static final Logger LOG=Logger.getLogger(HouseInfoItemAppAction.class);
	
	private HouseInfoItem mod=new HouseInfoItem();//参数
	private int userID;
	
	@Autowired
	private IHouseInfoItemService houseInfoItemService;
	
	/**
	 * 租房历史列表（我的订单）
	 */
	@Action(value="myOrder")
	public void myOrder(){
		try{
			this.pager=this.houseInfoItemService.searchByUserID(pager, userID);
			super.successResponse(pager);
		}catch(Exception e){
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 房屋预订
	 */
	@Action(value="reserveItem")
	public void reserveItem(){
		try{
			this.mod=this.houseInfoItemService.reserveItem(mod);
			super.successResponse(mod);
		}catch(Exception e){
			LOG.error(e.getMessage());
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}

	@Override
	public HouseInfoItem getModel() {
		return this.mod;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


	
}
