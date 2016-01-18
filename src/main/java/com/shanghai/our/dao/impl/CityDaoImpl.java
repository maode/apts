package com.shanghai.our.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.ICityDao;
import com.shanghai.our.model.City;
@Repository("cityDao")
public class CityDaoImpl extends HibernateEntityDao<City> implements ICityDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<City> findAll(Integer pageIndex, Integer pageSize,
			City city) {
		String hql="From City  where  1=1";
		if(city!=null){
			if(StringUtils.isNotBlank(city.getCkey())){
				hql=hql+"  and   ckey  ='"+city.getCkey()+"'";
			}
			if(StringUtils.isNotBlank(city.getCname())){
				hql=hql+"  and  cname ='"+city.getCname()+"'";
			}
			if(city.getProvince()!=null&&city.getProvince().getId()!=0){
				hql=hql+"  and  provinceid ='"+city.getProvince().getId()+"'";
			}
		}
			Query query=super.getSession().createQuery(hql);
		return query.setFirstResult(pageIndex).setMaxResults(pageSize).list();
	}

	@Override
	public Long findAllCount(City city) {
		String hql="select count(*) From City  where  1=1 ";
		if(city!=null){
			if(StringUtils.isNotBlank(city.getCkey())){
				hql=hql+"  and   ckey  ='"+city.getCkey()+"'";
			}
			if(StringUtils.isNotBlank(city.getCname())){
				hql=hql+"  and  cname ='"+city.getCname()+"'";
			}
			if(city.getProvince()!=null&&city.getProvince().getId()!=0){
				hql=hql+"  and  provinceid ='"+city.getProvince().getId()+"'";
			}
		}
			Query query=super.getSession().createQuery(hql);
			
			return (Long)query.uniqueResult();
	}
	@Override
	public City getId(Integer id) {
		// TODO Auto-generated method stub
		return super.findByID(id);
	}
	@Override
	public City saveCity(City city) {
		// TODO Auto-generated method stub
		return super.save(city);
	}

	@Override
	public void editCity(City city) {
		// TODO Auto-generated method stub
		super.mergry(city);
	}

	@Override
	public void delCity(Integer id) {
		// TODO Auto-generated method stub
		super.deleteByID(id);
	}

	

}
