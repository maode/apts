package com.shanghai.our.service;

import com.shanghai.our.model.Pager;
import com.shanghai.our.model.Picture;

public interface IPictureService {
	/**获取所有的图片
	 * @param pager
	 * @param mod
	 * @return
	 */
	public Pager<Picture>  findAll(Pager<Picture> pager,Picture mod);
	/**
	 * 根据ID获取图片信息
	 * @param id
	 * @return
	 */
	public Picture  getById(Integer id);
	
	/**
	 * 保存图片
	 * @param mod
	 * @return
	 */
	public  Picture  save(Picture mod);
	
	/**
	 * 编辑图片
	 * @param mod
	 */
	public  void merge(Picture mod);
	
	/**
	 * 删除图片
	 * @param id
	 */
	public void  delByID(Integer id);
	

	
}
