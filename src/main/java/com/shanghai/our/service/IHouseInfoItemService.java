package com.shanghai.our.service;

import com.shanghai.our.model.HouseInfoItem;
import com.shanghai.our.model.Pager;

/**
 * @author code0
 *
 */
public interface IHouseInfoItemService {
	
	/**查询用户的租房历史
	 * @param pager
	 * @param userID
	 * @return
	 */
	public Pager<HouseInfoItem>  searchByUserID(Pager<HouseInfoItem> pager,int userID);

	/**房屋预订
	 * @param houseItem
	 * @return
	 */
	public HouseInfoItem  reserveItem(HouseInfoItem houseItem);

	
}
