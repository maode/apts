package com.shanghai.our.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IHouseInfoDao;
import com.shanghai.our.model.HouseInfo;
@Repository("houseInfoDao")
public class HouseInfoDaoImpl extends HibernateEntityDao<HouseInfo> implements IHouseInfoDao{
	
	private Query findAllWhereQuery(String hqlHead,HouseInfo houseInfo,boolean isCount) {
		StringBuffer hql=new StringBuffer(hqlHead);
		
		Query query=super.getSession().createSQLQuery(hql.toString());
		return query;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HouseInfo> findAll(Integer firstResult, Integer maxResult,
			HouseInfo houseInfo) {
		String hqlHead="select  h.* From  t_House h " +
				" where  1=1 ";
		SQLQuery query=(SQLQuery)this.findAllWhereQuery(hqlHead, houseInfo,false);
		return query.addEntity(HouseInfo.class).setFirstResult(firstResult).setMaxResults(maxResult).list();
	}

	@Override
	public Long findAllCount(HouseInfo houseInfo) {
		String hqlHead="select count(*) from ("+
				"select DISTINCT h.* From  t_House h " +
				" left join t_houseitem hi on h.id=hi.houseid " +
				" where  1=1 ";
		Query query=this.findAllWhereQuery(hqlHead, houseInfo,true);
		return Long.valueOf(query.uniqueResult().toString());
	}
	@Override
	public HouseInfo getId(Integer id) {
		// TODO Auto-generated method stub
		return super.findByID(id);
	}
	@Override
	public HouseInfo saveHouse(HouseInfo houseInfo) {
		// TODO Auto-generated method stub
		return super.save(houseInfo);
	}

	@Override
	public void editHouse(HouseInfo houseInfo) {
		// TODO Auto-generated method stub
		super.mergry(houseInfo);
	}

	@Override
	public void delHouseInfo(Integer id) {
		// TODO Auto-generated method stub
		super.deleteByID(id);
	}

	@Override
	public List<HouseInfo> searchByKey(Integer firstResult, Integer maxResult,
			HouseInfo houseInfo) {
		String hql="From HouseInfo  where  1=1  and delFlag=1";
		if(houseInfo!=null){}
			Query query=super.getSession().createQuery(hql);
			if(houseInfo!=null){}
		return query.setFirstResult(firstResult).setMaxResults(maxResult).list();
	}
	@Override
	public Long searchByKeyCount(HouseInfo houseInfo) {
		String hql="select count(*) From HouseInfo  where  1=1  and delFlag=1";
		if(houseInfo!=null){}
			Query query=super.getSession().createQuery(hql);
			if(houseInfo!=null){}
		return (Long)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HouseInfo> findAllByOverview(HouseInfo houseInfo) {
		String hql="SELECT h.id,h.aptNum,h.floorNum,h.houseNum,h.status,hh.beginTime,hh.endTime,hh.id AS hisId FROM t_house h "
				+ " LEFT JOIN V_house_his_last hh"
				+ " ON h.id=hh.houseid"
				+ " where h.aptNum=:aptNum"
				+ " ORDER BY  h.aptNum,h.floorNum,h.houseNum";
		SQLQuery query =super.getSession().createSQLQuery(hql); 
		query.setParameter("aptNum", houseInfo.getAptNum());
		return query.setResultTransformer(Transformers.aliasToBean(HouseInfo.class)).list();
	}


	

}
