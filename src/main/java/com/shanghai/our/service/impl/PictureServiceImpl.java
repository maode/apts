package com.shanghai.our.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanghai.our.dao.IPictureDao;
import com.shanghai.our.model.Pager;
import com.shanghai.our.model.Picture;
import com.shanghai.our.service.IPictureService;
@Service("pictureService")
public class PictureServiceImpl implements IPictureService {

	@Autowired
	IPictureDao pictureDao;
	@Override
	public Pager<Picture> findAll(Pager<Picture> pager, Picture mod) {
		List<Picture> result= this.pictureDao.findAll(pager.getFirstResult(), pager.getMaxResult(), mod);
		Long total=this.pictureDao.findAllCount(mod);
		pager.setRecords(result);
		pager.setTotalRecords(total);
		return pager;
	}

	@Override
	public Picture getById(Integer id) {
		return this.pictureDao.findByID(id);
	}

	@Override
	public Picture save(Picture mod) {
		return this.pictureDao.save(mod);
	}

	@Override
	public void merge(Picture mod) {
		this.pictureDao.mergry(mod);
	}

	@Override
	public void delByID(Integer id) {
		this.pictureDao.deleteByID(id);
	}

}
