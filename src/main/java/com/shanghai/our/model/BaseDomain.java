package com.shanghai.our.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;


/**  
 * @Title: BaseDomain.java
 * @Package com.shanghai.our.model
 * @Description: 实体类基类
 * @author code0   
 * @date 2016年1月25日 下午7:00:30 
 */
@MappedSuperclass
public class BaseDomain {

	private String createBy;
	private Date createTime=new Date();
	private Date lastUpdTime;
	
	
	/** @return createBy */
	public String getCreateBy() {
		return createBy;
	}
	/** @param createBy 要设置的 createBy */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/** @return createTime */
	public Date getCreateTime() {
		return createTime;
	}
	/** @param createTime 要设置的 createTime */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/** @return lastUpdTime */
	public Date getLastUpdTime() {
		return lastUpdTime;
	}
	/** @param lastUpdTime 要设置的 lastUpdTime */
	public void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}
}
