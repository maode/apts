/**
 * 
 */
package com.shanghai.our.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IHouseHisDao;
import com.shanghai.our.model.HouseHis;

/**
 * @author code0
 *
 */
@Repository("houseHisDao")
public class HouseHisDaoImpl extends HibernateEntityDao<HouseHis> implements IHouseHisDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<HouseHis> findAll(Integer firstResult, Integer maxResult,
			HouseHis houseHis) {
		String hqlHead="select ev.* from t_House_His ev  " +
				"left join user_houseHis ue on ev.id=ue.houseHis_id " +
				"where 1=1 ";
		Query query=this.findAllWhereQuery(hqlHead, houseHis);
		SQLQuery sq=(SQLQuery)query;
		return sq.addEntity(HouseHis.class).setFirstResult(firstResult).setMaxResults(maxResult).list();
	}

	@Override
	public Long findAllCount(HouseHis houseHis) {
		String hqlHead="select count(*) from t_house_his ev  " +
				"left join user_houseHis ue on ev.id=ue.houseHis_id " +
				"where 1=1 ";
		Query query=this.findAllWhereQuery(hqlHead, houseHis);
		BigInteger total=(BigInteger)query.uniqueResult();
		return total.longValue();
	}

	public Query findAllWhereQuery(String hqlHead, HouseHis model) {
		StringBuffer hql=new StringBuffer(hqlHead);
		Query query=super.getSession().createSQLQuery(hql.toString());
		return query;
	}


	
}
