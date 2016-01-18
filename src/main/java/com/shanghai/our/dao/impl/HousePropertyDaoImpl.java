package com.shanghai.our.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IHousePropertyDao;
import com.shanghai.our.model.HouseProperty;

@Repository("housePropertyDao")
public class HousePropertyDaoImpl extends HibernateEntityDao<HouseProperty> implements IHousePropertyDao {

	@Override
	public List<HouseProperty> findAll() {
		// TODO Auto-generated method stub
		String  hql="From  HouseProperty  where 1=1";
		return super.getSession().createQuery(hql).list();
	}

	@Override
	public HouseProperty getId(Integer id) {
		// TODO Auto-generated method stub
		return super.findByID(id);
	}

}
