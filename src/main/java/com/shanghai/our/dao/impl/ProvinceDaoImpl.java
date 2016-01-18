package com.shanghai.our.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IProvinceDao;
import com.shanghai.our.model.Province;
@Repository("provinceDao")
public class ProvinceDaoImpl extends HibernateEntityDao<Province> implements IProvinceDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Province> findAll(Integer pageIndex, Integer pageSize,
			Province province) {
		String hql="From Province  where  1=1";
		if(province!=null){
			if(StringUtils.isNotBlank(province.getPkey())){
				hql=hql+"  and   pkey  ='"+province.getPkey()+"'";
			}
			if(StringUtils.isNotBlank(province.getPname())){
				hql=hql+"  and  pname ='"+province.getPname()+"'";
			}
		}
			Query query=super.getSession().createQuery(hql);
		return query.setFirstResult(pageIndex).setMaxResults(pageSize).list();
	}

	@Override
	public Long findAllCount(Province province) {
		String hql="select count(*) From Province  where  1=1";
		if(province!=null){
			if(StringUtils.isNotBlank(province.getPkey())){
				hql=hql+"  and   pkey  ='"+province.getPkey()+"'";
			}
			if(StringUtils.isNotBlank(province.getPname())){
				hql=hql+"  and  pname ='"+province.getPname()+"'";
			}
		}
			Query query=super.getSession().createQuery(hql);
			
			return (Long)query.uniqueResult();
	}
	@Override
	public Province getId(Integer id) {
		// TODO Auto-generated method stub
		return super.findByID(id);
	}
	@Override
	public Province saveProvince(Province province) {
		// TODO Auto-generated method stub
		return super.save(province);
	}

	@Override
	public void editProvince(Province province) {
		// TODO Auto-generated method stub
		super.mergry(province);
	}

	@Override
	public void delProvince(Integer id) {
		// TODO Auto-generated method stub
		super.deleteByID(id);
	}

	

}
