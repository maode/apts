package com.shanghai.our.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanghai.our.dao.IAdminDao;
import com.shanghai.our.model.Admin;
import com.shanghai.our.service.IAdminService;
@Service("adminService")
public class AdminServiceImpl implements IAdminService {

	
	@Autowired
	private  IAdminDao  adminDao;
	@Override
	public List<Admin> findAll(Integer pageIndex, Integer pageSize, Admin admin) {
		// TODO Auto-generated method stub
		return this.adminDao.findAll(pageIndex, pageSize, admin);
	}

	@Override
	public Long findAllCount(Admin admin) {
		// TODO Auto-generated method stub
		return this.adminDao.findAllCount(admin);
	}

	@Override
	public Admin getId(Integer id) {
		// TODO Auto-generated method stub
		return this.adminDao.getId(id);
	}

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.adminDao.saveAdmin(admin);
	}

	@Override
	public void editAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.adminDao.editAdmin(admin);
	}

	@Override
	public void delAdmin(Integer id) {
		// TODO Auto-generated method stub
		this.adminDao.delAdmin(id);
	}

	@Override
	public Admin getByUserName(String userName, String password) {
		// TODO Auto-generated method stub
		return this.adminDao.getByUserName(userName, password);
	}

	@Override
	public Admin getByUserName(String userName) {
		// TODO Auto-generated method stub
		return adminDao.getAdminByUserName(userName);
	}

}
