/**
 * 
 */
package com.shanghai.our.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IEventDao;
import com.shanghai.our.model.Event;

/**
 * @author code0
 *
 */
@Repository("eventDao")
public class EventDaoImpl extends HibernateEntityDao<Event> implements IEventDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAll(Integer firstResult, Integer maxResult,
			Event event) {
		String hqlHead="select ev.* from t_Event ev  " +
				"left join user_event ue on ev.id=ue.event_id " +
				"where 1=1 ";
		Query query=this.findAllWhereQuery(hqlHead, event);
		SQLQuery sq=(SQLQuery)query;
		return sq.addEntity(Event.class).setFirstResult(firstResult).setMaxResults(maxResult).list();
	}

	@Override
	public Long findAllCount(Event event) {
		String hqlHead="select count(*) from t_Event ev  " +
				"left join user_event ue on ev.id=ue.event_id " +
				"where 1=1 ";
		Query query=this.findAllWhereQuery(hqlHead, event);
		BigInteger total=(BigInteger)query.uniqueResult();
		return total.longValue();
	}

	public Query findAllWhereQuery(String hqlHead, Event model) {
		StringBuffer hql=new StringBuffer(hqlHead);
		
		if(model!=null){
			if(StringUtils.isNotBlank(model.getKey())){
				hql.append("  and  ("
						+ "		ev.name  like :key"
						+ " or	ev.addr  like :key"
						+ " or	ev.consideration  like :key"
						+ ")"
						);
			}
			if(model.getId()!=null){
				hql.append(" and ev.id= :id");
			}
			if(model.getUserID()!=null){
				hql.append(" and ue.user_id= :userID");
			}
			if(model.getStatus()!=null){
				hql.append("  and  ev.status = :status");
			}
			if(model.getDelFlag()!=null){
				hql.append("  and  ev.delFlag  = :delFlag");
			}
		}
			Query query=super.getSession().createSQLQuery(hql.toString());
			if(model!=null){
				if(StringUtils.isNotBlank(model.getKey())){
					query.setParameter("key","%"+model.getKey()+"%");
				}
				if(model.getId()!=null){
					query.setParameter("id", model.getId());
				}
				if(model.getUserID()!=null){
					query.setParameter("userID", model.getUserID());
				}
				if(model.getStatus()!=null){
					query.setParameter("status", model.getStatus());
				}
				if(model.getDelFlag()!=null){
					query.setParameter("delFlag", model.getDelFlag());
				}	
			}	
		return query;
	}

	@Override
	public void eventEnroll(Event event) {
		StringBuffer sqlb=new StringBuffer(
				"insert into user_event(user_id,event_id)values(:uid,:eid)"
				);
		SQLQuery query=super.getSession().createSQLQuery(sqlb.toString());
		query.setParameter("uid", event.getUserID())
		.setParameter("eid", event.getId())
		.executeUpdate();
	}
	
}
