package com.shanghai.our.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shanghai.our.dao.HibernateEntityDao;
import com.shanghai.our.dao.IAdminDao;
import com.shanghai.our.model.Admin;
import com.shanghai.our.utils.MD5Util;
@Repository("adminDao")
public class AdminDaoImpl extends HibernateEntityDao<Admin> implements IAdminDao {

	@Override
	public List<Admin> findAll(Integer pageIndex, Integer pageSize, Admin admin) {
		String hql="From  Admin where  1=1  and  delFlag=1 ";
		if(admin!=null){
			if(admin.getUsername()!=null&&!"".equals(admin.getUsername())){
				hql=hql+"   and   username  like  :username";
			}
			if(admin.getTel()!=null&&!"".equals(admin.getTel())){
				hql=hql+"   and  tel  like  :tel";
			}
			if(admin.getRealname()!=null&&!"".equals(admin.getRealname())){
				
				hql=hql+"  and realname  like  realname";
			}
			
		}
		hql=hql+"  order  by  createTime desc";
		Query query=super.getSession().createQuery(hql);
		if(admin!=null){
			if(admin.getUsername()!=null&&!"".equals(admin.getUsername())){
				query.setParameter("username","%"+admin.getUsername()+"%");
			}
			if(admin.getTel()!=null&&!"".equals(admin.getTel())){
				query.setParameter("tel","%"+admin.getTel()+"%");
			}
			if(admin.getRealname()!=null&&!"".equals(admin.getRealname())){
				
				query.setParameter("realname","%"+admin.getRealname()+"%");
			}
		}
		if(pageIndex!=null&&pageSize!=null)
			return query.setFirstResult(pageIndex).setMaxResults(pageSize).list();
		return query.list();
	}
	@Override
	public Long findAllCount(Admin admin) {
		String hql="select  count(*)  From  Admin where  1=1  and delFlag =1 ";
		if(admin!=null){
			if(admin.getUsername()!=null&&!"".equals(admin.getUsername())){
				hql=hql+"   and   username  like  :username";
			}
			if(admin.getTel()!=null&&!"".equals(admin.getTel())){
				hql=hql+"   and  tel  like  :tel";
			}
			if(admin.getRealname()!=null&&!"".equals(admin.getRealname())){
				
				hql=hql+"  and realname  like  realname";
			}
			
		}
		hql=hql+"  order  by  createTime desc";
		Query query=super.getSession().createQuery(hql);
		if(admin!=null){
			if(admin.getUsername()!=null&&!"".equals(admin.getUsername())){
				query.setParameter("username","%"+admin.getUsername()+"%");
			}
			if(admin.getTel()!=null&&!"".equals(admin.getTel())){
				query.setParameter("tel","%"+admin.getTel()+"%");
			}
			if(admin.getRealname()!=null&&!"".equals(admin.getRealname())){
				
				query.setParameter("realname","%"+admin.getRealname()+"%");
			}
		}
		return (Long)query.uniqueResult();
	}
	@Override
	public Admin getId(Integer id) {
		// TODO Auto-generated method stub
		return super.findByID(id);
	}

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		super.save(admin);
	}

	@Override
	public void editAdmin(Admin admin) {
		// TODO Auto-generated method stub
		super.mergry(admin);
	}

	@Override
	public void delAdmin(Integer id) {
		// TODO Auto-generated method stub
		Admin  admin=this.findByID(id);
		admin.setDelFlag(2);
		super.mergry(admin);
	}

	@Override
	public Admin getByUserName(String userName, String password) {
		String hql="From  Admin  where  userName = :userName  and  password = :password   and delFlag=1";
		Query query=super.getSession().createQuery(hql);
		query.setParameter("userName",userName);
		query.setParameter("password",MD5Util.getPassByMD5(password));
		Object obj=query.uniqueResult();
		if(obj!=null)
		return (Admin)query.uniqueResult();
		return null;
	}
	@Override
	public Admin getAdminByUserName(String userName) {
		String hql="From  Admin  where  userName = :userName   and delFlag=1";
		Query query=super.getSession().createQuery(hql);
		query.setParameter("userName",userName);
		Object obj=query.uniqueResult();
		if(obj!=null)
		return (Admin)query.uniqueResult();
		return null;
	}

	

}
