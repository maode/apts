/**
 * 
 */
package com.shanghai.our.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IHouseInfoItemDao;
import com.shanghai.our.model.HouseInfoItem;

/**
 * @author code0
 *
 */
@Repository("houseItemDao")
public class HouseItemDaoImpl extends HibernateEntityDao<HouseInfoItem> implements
		IHouseInfoItemDao {


	@SuppressWarnings("unchecked")
	@Override
	public List<HouseInfoItem> searchByUserID(Integer firstResult,
			Integer maxResult, int userID) {
		String hql="From HouseInfoItem  where  1=1  ";
		hql=hql+"  and   userInfo.id = '"+userID+"'";
		Query query=super.getSession().createQuery(hql);
			
		return  query.setFirstResult(firstResult).setMaxResults(maxResult).list();
	}

	@Override
	public Long searchByUserIDCount(int userID) {
		String hql="select count(*) From HouseInfoItem  where  1=1  ";
		hql=hql+"  and   userInfo.id = '"+userID+"'";
		Query query=super.getSession().createQuery(hql);

		return (Long) query.uniqueResult();
	}

	@Override
	public HouseInfoItem getId(Integer id) {
		return super.findByID(id);
	}

	@Override
	public HouseInfoItem saveHouseItem(HouseInfoItem houseItem) {
		return super.save(houseItem);
	}

	@Override
	public void editHouseItem(HouseInfoItem houseItem) {
		super.mergry(houseItem);
	}

	@Override
	public void delHouseInfoItem(Integer id) {
		super.deleteByID(id);
	}
	

}
