/**
 * 
 */
package com.shanghai.our.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IPictureDao;
import com.shanghai.our.model.Picture;

/**
 * @author code0
 *
 */
@Repository("pictureDao")
public class PictureDaoImpl extends HibernateEntityDao<Picture> implements IPictureDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Picture> findAll(Integer firstResult, Integer maxResult,
			Picture picture) {
		String hqlHead="From Picture where 1=1 ";
		Query query=this.findAllWhereQuery(hqlHead, picture);
		return query.setFirstResult(firstResult).setMaxResults(maxResult).list();
	}

	@Override
	public Long findAllCount(Picture picture) {
		String hqlHead="select count(*) From Picture where 1=1 ";
		Query query=this.findAllWhereQuery(hqlHead, picture);
		return Long.valueOf(query.uniqueResult().toString());
	}

	public Query findAllWhereQuery(String hqlHead, Picture model) {
		StringBuffer hql=new StringBuffer(hqlHead);
		
		if(model!=null){
			if(model.getHouseInfo()!=null&&model.getHouseInfo().getId()!=0){
				hql.append(" and houseInfo.id= :hid");
			}
			
			
		}
			Query query=super.getSession().createQuery(hql.toString());
			if(model!=null){
				if(model.getHouseInfo()!=null&&model.getHouseInfo().getId()!=0){
					query.setParameter("hid", model.getHouseInfo().getId());
				}
			}	
		return query;
	}


	
}
