package com.shanghai.our.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanghai.our.dao.IHouseInfoItemDao;
import com.shanghai.our.model.HouseInfoItem;
import com.shanghai.our.model.Pager;
import com.shanghai.our.service.IHouseInfoItemService;
@Service("houseInfoItemService")
public class HouseInfoItemServiceImpl implements IHouseInfoItemService {

	@Autowired
	private IHouseInfoItemDao houseInfoItemDao;
	
	@Override
	public Pager<HouseInfoItem> searchByUserID(Pager<HouseInfoItem> pager,
			int userID) {
		List<HouseInfoItem> records=this.houseInfoItemDao.searchByUserID(pager.getFirstResult(), pager.getMaxResult(), userID);
		Long total=this.houseInfoItemDao.searchByUserIDCount(userID);
		pager.setPager(records, total);
		return pager;
	}

	@Override
	public HouseInfoItem reserveItem(HouseInfoItem houseItem) {
		return this.houseInfoItemDao.saveHouseItem(houseItem);
	}
	
}
