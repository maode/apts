package com.shanghai.our.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IUserInfoDao;
import com.shanghai.our.model.UserInfo;
@Repository("userInfoDao")
public class UserInfoDaoImpl extends HibernateEntityDao<UserInfo> implements IUserInfoDao {

	@Override
	public List<UserInfo> findAll(Integer pageIndex, Integer pageSize,
			UserInfo userInfo) {
		// TODO Auto-generated method stub
		String hql="From  UserInfo  where  1=1 ";
		if(userInfo!=null){
			if(userInfo.getEmail()!=null&&!"".equals(userInfo.getEmail())){
				hql=hql+"   AND  email  like :email";
			}
			if(userInfo.getGender()!=null&&userInfo.getGender()!=0){
				hql=hql+"  AND  gender ="+userInfo.getGender();
			}
			if(userInfo.getRealname()!=null&&!userInfo.getRealname().equals("")){
				hql=hql+"   AND  realname  like :realname";
			}
			if(userInfo.getTelephone()!=null&&!"".equals(userInfo.getTelephone())){
				hql=hql+"  AND   telephone   like  :telephone";
			}
			if(userInfo.getDelFlag()!=null&&userInfo.getDelFlag()!=0){
				hql=hql+"  and  delFlag="+userInfo.getDelFlag();
			}
			if(userInfo.getStatus()!=null&&userInfo.getStatus()!=0){
				hql=hql+"  and  status ="+userInfo.getStatus();
			}
			
		}
		hql=hql+"  order  by  createTime  desc";
		Query query=super.getSession().createQuery(hql);
		if(userInfo!=null){
			if(userInfo.getEmail()!=null&&!"".equals(userInfo.getEmail())){
				query.setParameter("email","%"+userInfo.getEmail()+"%");
			}
			if(userInfo.getRealname()!=null&&!userInfo.getRealname().equals("")){
				query.setParameter("realname","%"+userInfo.getRealname()+"%");
			}
			if(userInfo.getTelephone()!=null&&!"".equals(userInfo.getTelephone())){
				query.setParameter("telephone","%"+userInfo.getTelephone()+"%");
			}
		}
	
		if(pageIndex!=null&&pageSize!=null)
			return query.setFirstResult(pageIndex).setMaxResults(pageSize).list();
		return query.list();
	}

	@Override
	public UserInfo getId(Integer id) {
		// TODO Auto-generated method stub
		return super.findByID(id);
	}

	@Override
	public UserInfo getByEmail(String email) {
		String hql="From  UserInfo  where  delFlag=1  and  email=:email";
		Query query=super.getSession().createQuery(hql).setParameter("email",email);
		Object obj=query.uniqueResult();
		if(obj!=null)
		return (UserInfo)obj;
		return null;
	}

	@Override
	public UserInfo saveUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return super.save(userInfo);
	}

	@Override
	public void editUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		super.mergry(userInfo);
	}

	@Override
	public void delUserInfo(Integer id) {
		// TODO Auto-generated method stub
		UserInfo u=this.findByID(id);
		u.setDelFlag(2);
		super.mergry(u);
	}

	@Override
	public Long findAllCount(UserInfo userInfo) {
		// TODO Auto-generated method stub
				String hql="select  count(*)  From  UserInfo  where  1=1 ";
				if(userInfo!=null){
					if(userInfo.getEmail()!=null&&!"".equals(userInfo.getEmail())){
						hql=hql+"   AND  email  like :email";
					}
					if(userInfo.getGender()!=null&&userInfo.getGender()!=0){
						hql=hql+"  AND  gender ="+userInfo.getGender();
					}
					if(userInfo.getRealname()!=null&&!userInfo.getRealname().equals("")){
						hql=hql+"   AND  realname  like :realname";
					}
					if(userInfo.getTelephone()!=null&&!"".equals(userInfo.getTelephone())){
						hql=hql+"  AND   telephone   like  :telephone";
					}
					if(userInfo.getDelFlag()!=null&&userInfo.getDelFlag()!=0){
						hql=hql+"  and  delFlag="+userInfo.getDelFlag();
					}
					if(userInfo.getStatus()!=null&&userInfo.getStatus()!=0){
						hql=hql+"  and  status ="+userInfo.getStatus();
					}
					
				}
				hql=hql+"  order  by  createTime  desc";
				Query query=super.getSession().createQuery(hql);
				if(userInfo!=null){
					if(userInfo.getEmail()!=null&&!"".equals(userInfo.getEmail())){
						query.setParameter("email","%"+userInfo.getEmail()+"%");
					}
					if(userInfo.getRealname()!=null&&!userInfo.getRealname().equals("")){
						query.setParameter("realname","%"+userInfo.getRealname()+"%");
					}
					if(userInfo.getTelephone()!=null&&!"".equals(userInfo.getTelephone())){
						query.setParameter("telephone","%"+userInfo.getTelephone()+"%");
					}
				}
			
				return (Long)query.uniqueResult();
	}

}
