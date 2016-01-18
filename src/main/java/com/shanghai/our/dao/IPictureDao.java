package com.shanghai.our.dao;

import java.util.List;

import com.shanghai.our.model.Picture;
import com.shanghai.our.utils.IBaseDao;

public interface IPictureDao extends IBaseDao<Picture> {
	/**
	 * 获取所有的图片
	 * @param firstResult
	 * @param maxResult
	 * @param houseInfo
	 * @return
	 */
	public List<Picture>  findAll(Integer firstResult, Integer maxResult,Picture picture);
	/**获取所有的图片-条数
	 * @param picture
	 * @return
	 */
	public Long  findAllCount(Picture picture);
	

}
