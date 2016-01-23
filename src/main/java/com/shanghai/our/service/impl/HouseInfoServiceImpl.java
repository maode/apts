package com.shanghai.our.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanghai.our.dao.IHouseInfoDao;
import com.shanghai.our.dao.IUserInfoDao;
import com.shanghai.our.model.HouseGenerate;
import com.shanghai.our.model.HouseInfo;
import com.shanghai.our.model.HouseType;
import com.shanghai.our.model.Pager;
import com.shanghai.our.service.IHouseInfoService;
import com.shanghai.our.utils.ExecuteResult;
@Service("houseInfoService")
public class HouseInfoServiceImpl implements IHouseInfoService {

	
	@Autowired
	private IHouseInfoDao houseInfoDao;
	@Autowired
	private IUserInfoDao userInfoDao;
	
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
	
		this.houseInfoDao.editHouse(hpb);
		result.setSuccess(true);
	
		return result;
	}

	@Override
	public void delHouseInfo(Integer id) {
		// TODO Auto-generated method stub
		this.houseInfoDao.delHouseInfo(id);
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
	
	/**
	 * 批量生成房屋
	 * @param hg
	 * @return
	 * @see com.shanghai.our.service.IHouseInfoService#generateHouse(com.shanghai.our.model.HouseGenerate)
	 */
	@Override
	public ExecuteResult<String> generateHouse(HouseGenerate hg) {
		ExecuteResult<String> result=new ExecuteResult<String>();
		String aptNum=hg.getAptNum();
		Integer floorTotal=hg.getFloorTotal();
		Integer houseTotal=hg.getHouseTotal();
		Integer houseTypeId=hg.getHouseTypeId();
		for(int f=1;f<=floorTotal;f++){
			for( int h=1;h<=houseTotal;h++){
				String hNum=String.format("%02d", h);//不带楼层的房间号
				String houseNum=f+hNum;//完整房间号
				HouseInfo houseInfo=new HouseInfo();
				houseInfo.setAptNum(aptNum);
				houseInfo.setFloorNum(f);
				houseInfo.setHouseNum(houseNum);
				houseInfo.setHouseType(new HouseType(houseTypeId));
				this.houseInfoDao.saveHouse(houseInfo);
			}
		}
		result.setSuccess(true);
		return result;
	}
	@Override
	public List<HouseInfo> loadHouseOverview(HouseInfo houseInfo) {
		List<HouseInfo> results=this.houseInfoDao.findAllByOverview(houseInfo);
		return results;
	}

}
