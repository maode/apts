package com.shanghai.our.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IHouseInfoDao;
import com.shanghai.our.model.HouseInfo;
@Repository("houseInfoDao")
public class HosueInfoDaoImpl extends HibernateEntityDao<HouseInfo> implements IHouseInfoDao{
	
	private Query findAllWhereQuery(String hqlHead,HouseInfo houseInfo,boolean isCount) {
		StringBuffer hql=new StringBuffer(hqlHead);
		
		if(houseInfo!=null){
			if(houseInfo.getBeginTime()!=null){
				hql.append("  and  h.beginTime >= :beginTime");
			}
			if(houseInfo.getEndTime()!=null){
				hql.append("  and  h.endTime <= :endTime");
			}
			if(StringUtils.isNotBlank(houseInfo.getHouseNum())){
				hql.append("  and  h.houseNum = :houseNum");
			}
			
		}
		if(isCount){
			hql.append(")TT");
		}
		Query query=super.getSession().createSQLQuery(hql.toString());
		if(houseInfo!=null){
			if(houseInfo.getBeginTime()!=null){
				query.setParameter("beginTime",houseInfo.getBeginTime());
			}
			if(houseInfo.getEndTime()!=null){
				query.setParameter("endTime",houseInfo.getEndTime());
			}
			if(StringUtils.isNotBlank(houseInfo.getHouseNum())){
				query.setParameter("houseNum",houseInfo.getHouseNum());
			}
		}		
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

	@Override
	public List<HouseInfo> findAllByOverview(HouseInfo houseInfo) {
		String hql="from HouseInfo where aptNum=:aptNum order by aptNum,floorNum,houseNum";
		Query query =super.getSession().createQuery(hql); 
		query.setParameter("aptNum", houseInfo.getAptNum());
		return query.list();
	}


	

}
