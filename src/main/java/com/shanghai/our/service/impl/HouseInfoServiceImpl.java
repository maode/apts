package com.shanghai.our.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanghai.our.dao.IAdminDao;
import com.shanghai.our.dao.ICityDao;
import com.shanghai.our.dao.IHouseInfoDao;
import com.shanghai.our.dao.IHousePropertyDao;
import com.shanghai.our.dao.IUserInfoDao;
import com.shanghai.our.model.Admin;
import com.shanghai.our.model.City;
import com.shanghai.our.model.HouseInfo;
import com.shanghai.our.model.HouseProperty;
import com.shanghai.our.model.Pager;
import com.shanghai.our.model.UserInfo;
import com.shanghai.our.service.IHouseInfoService;
import com.shanghai.our.utils.DateUtil;
import com.shanghai.our.utils.ExecuteResult;
@Service("houseInfoService")
public class HouseInfoServiceImpl implements IHouseInfoService {

	
	@Autowired
	private IHouseInfoDao houseInfoDao;
	@Autowired
	private ICityDao cityDao;
	@Autowired
	private IAdminDao adminDao;
	@Autowired
	private IUserInfoDao userInfoDao;
	@Autowired
	private IHousePropertyDao housePropertyDao;
	
	@Override
	public Pager<HouseInfo> findAll(Pager<HouseInfo> pager,HouseInfo houseInfo) {
		List<HouseInfo> his= this.houseInfoDao.findAll(pager.getFirstResult(), pager.getMaxResult(), houseInfo);
		Long total=this.houseInfoDao.findAllCount(houseInfo);
		pager.setRecords(his);
		pager.setTotalRecords(total);
		return pager;
	}
	@Override
	public HouseInfo getId(Integer id) {
		// TODO Auto-generated method stub
		return this.houseInfoDao.getId(id);
	}

	@Override
	public HouseInfo saveHouse(HouseInfo houseInfo) {
		// TODO Auto-generated method stub
		return this.houseInfoDao.saveHouse(houseInfo);
	}

	@Override
	public ExecuteResult<String> editHouse(HouseInfo hpb) {
		ExecuteResult<String> result=new ExecuteResult<String>();
		if(hpb!=null){
			//校验房源必填信息
			if(hpb.getCity()!=null&&hpb.getCity().getId()>0&&hpb.getHouseType()!=0&&
					hpb.getHouseProperty()!=null&&hpb.getHouseProperty().getId()>0&&
					hpb.getPeopleNum()>0&&hpb.getRoomNum()>0&&
					hpb.getBedNum()>0&&hpb.getToiletNum()>0
					){
				//校验城市是否存在
				City city=this.cityDao.getId(hpb.getCity().getId());
				if(city==null){
					result.setResult("房源所属城市不存在");
					return result;
				}else{
					hpb.setProvince(city.getProvince());
				}
				//校验房间类型是否存在
				HouseProperty hp=this.housePropertyDao.getId(hpb.getHouseProperty().getId());
				if(hp==null){
					result.setResult("房源所属房间类型不存在");
					return result;
				}
				//校验添加人【admin or userInfo】是否存在
				boolean createByExist=false;
				if(hpb.getAdmin()!=null&&hpb.getAdmin().getId()>0){
					Admin admin=this.adminDao.getId(hpb.getAdmin().getId());
					if(admin!=null){
						createByExist=true;
					}
				}
				if(hpb.getUserInfo()!=null&&hpb.getUserInfo().getId()>0){
					UserInfo ui=this.userInfoDao.getId(hpb.getUserInfo().getId());
					if(ui!=null){
						createByExist=true;
					}
				}
				if(!createByExist){
					result.setResult("房源创建人不存在");
					return result;
				}
				this.houseInfoDao.editHouse(hpb);
				result.setSuccess(true);
			}else{
				result.setResult("房源必填信息不完整");
			}
		}else{
			result.setResult("房源参数为空");
		}
		return result;
	}

	@Override
	public void delHouseInfo(Integer id) {
		// TODO Auto-generated method stub
		this.houseInfoDao.delHouseInfo(id);
	}

	@Override
	public List<HouseProperty> findAllProperty() {
		// TODO Auto-generated method stub
		return this.housePropertyDao.findAll();
	}

	@Override
	public HouseProperty getPropertyId(Integer id) {
		// TODO Auto-generated method stub
		return this.housePropertyDao.getId(id);
	}

	@Override
	public ExecuteResult<String> publishHouse(HouseInfo hpb) {
		ExecuteResult<String> result=new ExecuteResult<String>();
		if(hpb!=null){
			//校验房源必填信息
			if(hpb.getCity()!=null&&hpb.getCity().getId()>0&&hpb.getHouseType()!=0&&
					hpb.getHouseProperty()!=null&&hpb.getHouseProperty().getId()>0&&
					hpb.getPeopleNum()>0&&hpb.getRoomNum()>0&&
					hpb.getBedNum()>0&&hpb.getToiletNum()>0
					){
				//校验城市是否存在
				City city=this.cityDao.getId(hpb.getCity().getId());
				if(city==null){
					result.setResult("房源所属城市不存在");
					return result;
				}else{
					hpb.setProvince(city.getProvince());
				}
				//校验房间类型是否存在
				HouseProperty hp=this.housePropertyDao.getId(hpb.getHouseProperty().getId());
				if(hp==null){
					result.setResult("房源所属房间类型不存在");
					return result;
				}
				//校验添加人【admin or userInfo】是否存在
				boolean createByExist=false;
				if(hpb.getAdmin()!=null&&hpb.getAdmin().getId()>0){
					Admin admin=this.adminDao.getId(hpb.getAdmin().getId());
					if(admin!=null){
						createByExist=true;
					}
				}
				if(hpb.getUserInfo()!=null&&hpb.getUserInfo().getId()>0){
					UserInfo ui=this.userInfoDao.getId(hpb.getUserInfo().getId());
					if(ui!=null){
						createByExist=true;
					}
				}
				if(!createByExist){
					result.setResult("房源创建人不存在");
					return result;
				}
				
				hpb.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
				
				this.houseInfoDao.saveHouse(hpb);
				result.setSuccess(true);
			}else{
				result.setResult("房源必填信息不完整");
			}
		}else{
			result.setResult("房源参数为空");
		}
		return result;
	}

	@Override
	public Pager<HouseInfo> searchByKey(Pager<HouseInfo> pager,
			HouseInfo houseInfo) {
		 List<HouseInfo> his=this.houseInfoDao.searchByKey(pager.getFirstResult(), pager.getMaxResult(), houseInfo);
		 Long total=this.houseInfoDao.searchByKeyCount(houseInfo);
		 pager.setRecords(his);
		 pager.setTotalRecords(total);
		 return pager;
	}
	@Override
	public Pager<HouseInfo> searchByArea(Pager<HouseInfo> pager,
			HouseInfo houseInfo) {
		List<HouseInfo> his=this.houseInfoDao.findAll(pager.getCurrentPage(), pager.getPageSize(), houseInfo);
		Long total=this.houseInfoDao.findAllCount(houseInfo);
		pager.setRecords(his);
		pager.setTotalRecords(total);
		return pager;
	}
	@Override
	public Pager<HouseInfo> myHouse(Pager<HouseInfo> pager, HouseInfo houseInfo) {
		List<HouseInfo> his=this.houseInfoDao.findAll(pager.getCurrentPage(), pager.getPageSize(), houseInfo);
		Long total=this.houseInfoDao.findAllCount(houseInfo);
		pager.setRecords(his);
		pager.setTotalRecords(total);
		return pager;
	}

}
