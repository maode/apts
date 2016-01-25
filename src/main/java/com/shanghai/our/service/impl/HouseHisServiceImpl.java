/**
 * 
 */
package com.shanghai.our.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanghai.our.dao.IHouseHisDao;
import com.shanghai.our.dao.IHouseInfoDao;
import com.shanghai.our.model.HouseHis;
import com.shanghai.our.model.HouseInfo;
import com.shanghai.our.model.Pager;
import com.shanghai.our.service.IHouseHisService;

/**
 * @author code0
 *
 */
@Service("houseHisService")
public class HouseHisServiceImpl implements IHouseHisService {
	@Autowired
	private IHouseHisDao houseHisDao;
	@Autowired
	private IHouseInfoDao houseInfoDao;

	@Override
	public Pager<HouseHis> findAll(Pager<HouseHis> pager, HouseHis mod) {
		List<HouseHis> his= this.houseHisDao.findAll(pager.getFirstResult(), pager.getMaxResult(), mod);
		Long total=this.houseHisDao.findAllCount(mod);
		pager.setRecords(his);
		pager.setTotalRecords(total);
		return pager;
	}

	@Override
	public HouseHis getById(Integer id) {
		return this.houseHisDao.findByID(id);
	}

	@Override
	public HouseHis save(HouseHis mod) {
		HouseHis hh=this.houseHisDao.save(mod);
		//将该房屋置为已出租状态
		HouseInfo hi=this.houseInfoDao.getId(mod.getHouseInfo().getId());
		hi.setStatus("1");
		this.houseInfoDao.editHouse(hi);
		return hh;
	}

	@Override
	public void merge(HouseHis mod) {
		this.houseHisDao.mergry(mod);
		
	}

	@Override
	public void delByID(Integer id) {
		this.houseHisDao.deleteByID(id);
	}

	
}
