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
			if(StringUtils.isNotBlank(houseInfo.getTitle())){
				hql.append("  and   h.title  like :title");
			}
			if(StringUtils.isNotBlank(houseInfo.getSurroundings())){
				hql.append("  and   h.surroundings  like :surroundings");
			}
			if(StringUtils.isNotBlank(houseInfo.getHouseSpecialMemo())){
				hql.append("  and   h.houseSpecialMemo  like :houseSpecialMemo");
			}
			if(StringUtils.isNotBlank(houseInfo.getMemo())){
				hql.append("  and   h.memo  like :memo");
			}
			if(houseInfo.getProvince()!=null&&houseInfo.getProvince().getId()!=0){
				hql.append("  and  h.provinceid ="+houseInfo.getProvince().getId());
			}
			if(houseInfo.getCity()!=null&&houseInfo.getCity().getId()!=0){
				hql.append("  and  h.cityid ="+houseInfo.getCity().getId());
			}
			if(houseInfo.getUserInfo()!=null&&houseInfo.getUserInfo().getId()!=0){
				hql.append("  and  h.userid ="+houseInfo.getUserInfo().getId());
			}
			if(houseInfo.getStatus()!=0){
				hql.append("  and  h.status ="+houseInfo.getStatus());
			}
			if(houseInfo.getHouseTypes()!=null&&houseInfo.getHouseTypes().length>0){
				hql.append("  and  h.houseType  in :houseTypes");
			}
		}
		if(isCount){
			hql.append(")TT");
		}
		Query query=super.getSession().createSQLQuery(hql.toString());
		if(houseInfo!=null){
			if(StringUtils.isNotBlank(houseInfo.getTitle())){
				query.setParameter("title",houseInfo.getTitle());
			}
			if(StringUtils.isNotBlank(houseInfo.getSurroundings())){
				query.setParameter("surroundings",houseInfo.getSurroundings());
			}
			if(StringUtils.isNotBlank(houseInfo.getHouseSpecialMemo())){
				query.setParameter("houseSpecialMemo",houseInfo.getHouseSpecialMemo());
			}
			if(StringUtils.isNotBlank(houseInfo.getMemo())){
				query.setParameter("memo",houseInfo.getMemo());
			}
		
			if(houseInfo.getHouseTypes()!=null&&houseInfo.getHouseTypes().length>0){
				query.setParameterList("houseTypes", houseInfo.getHouseTypes());
			}
		}		
		return query;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HouseInfo> findAll(Integer firstResult, Integer maxResult,
			HouseInfo houseInfo) {
		String hqlHead="select DISTINCT h.* From  t_House h " +
				" left join t_houseitem hi on h.id=hi.houseid " +
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
		if(houseInfo!=null){
			if(StringUtils.isNotBlank(houseInfo.getKey())){
				hql=hql+"  and  ("
						+ "		title  like :key"
						+ " or	surroundings  like :key"
						+ " or	houseSpecialMemo  like :key"
						+ " or	memo  like :key"
						+ ")";
			}
			if(houseInfo.getStatus()!=0){
				hql=hql+"  and  status ="+houseInfo.getStatus();
			}
			if(houseInfo.getHouseTypes()!=null&&houseInfo.getHouseTypes().length>0){
				hql=hql+"  and  houseType  in :houseTypes";
			}
		}
			Query query=super.getSession().createQuery(hql);
			if(houseInfo!=null){
				if(StringUtils.isNotBlank(houseInfo.getKey())){
					query.setParameter("key","%"+houseInfo.getKey()+"%");
				}
				if(houseInfo.getHouseTypes()!=null&&houseInfo.getHouseTypes().length>0){
					query.setParameterList("houseTypes", houseInfo.getHouseTypes());
				}
			}
		return query.setFirstResult(firstResult).setMaxResults(maxResult).list();
	}
	@Override
	public Long searchByKeyCount(HouseInfo houseInfo) {
		String hql="select count(*) From HouseInfo  where  1=1  and delFlag=1";
		if(houseInfo!=null){
			if(StringUtils.isNotBlank(houseInfo.getKey())){
				hql=hql+"  and  ("
						+ "		title  like :key"
						+ " or	surroundings  like :key"
						+ " or	houseSpecialMemo  like :key"
						+ " or	memo  like :key"
						+ ")";
			}
			if(houseInfo.getStatus()!=0){
				hql=hql+"  and  status ="+houseInfo.getStatus();
			}
			if(houseInfo.getHouseTypes()!=null&&houseInfo.getHouseTypes().length>0){
				hql=hql+"  and  houseType  in :houseTypes";
			}
		}
			Query query=super.getSession().createQuery(hql);
			if(houseInfo!=null){
				if(StringUtils.isNotBlank(houseInfo.getKey())){
					query.setParameter("key","%"+houseInfo.getKey()+"%");
				}
				if(houseInfo.getHouseTypes()!=null&&houseInfo.getHouseTypes().length>0){
					query.setParameterList("houseTypes", houseInfo.getHouseTypes());
				}
			}
		return (Long)query.uniqueResult();
	}


	

}
