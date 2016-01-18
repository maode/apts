package com.shanghai.our.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanghai.our.dao.IUserInfoDao;
import com.shanghai.our.model.UserInfo;
import com.shanghai.our.service.IUserInfoService;
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private IUserInfoDao userInfoDao;
	@Override
	public List<UserInfo> findAll(Integer pageIndex, Integer pageSize,
			UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.findAll(pageIndex, pageSize, userInfo);
	}

	@Override
	public Long findAllCount(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.findAllCount(userInfo);
	}

	@Override
	public UserInfo getId(Integer id) {
		// TODO Auto-generated method stub
		return userInfoDao.getId(id);
	}

	@Override
	public UserInfo getByEmail(String email) {
		// TODO Auto-generated method stub
		return userInfoDao.getByEmail(email);
	}

	@Override
	public UserInfo saveUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
	return 	this.userInfoDao.saveUserInfo(userInfo);
	}

	@Override
	public void editUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		this.userInfoDao.editUserInfo(userInfo);
	}

	@Override
	public void delUserInfo(Integer id) {
		// TODO Auto-generated method stub
		this.userInfoDao.delUserInfo(id);
	}

}
