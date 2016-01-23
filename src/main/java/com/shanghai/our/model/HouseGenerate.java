package com.shanghai.our.model;

import java.io.Serializable;

/**  
 * @Title: HouseInfo.java
 * @Package com.shanghai.our.model
 * @Description: 房屋批量生成实体类
 * @author code0   
 * @date 2016年1月18日 下午9:47:54 
 */
public class HouseGenerate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** @Fields aptNum : 楼座号 */
	private String aptNum;
	/** @Fields floorTotal : 楼层数 */
	private Integer floorTotal;
	/** @Fields houseTotal : 每层房间数 */
	private Integer houseTotal;
	/** @Fields houseTypeId : 房间默认规格 */
	private Integer houseTypeId;
	
	
	/** @return aptNum 楼座号 */
	public String getAptNum() {
		return aptNum;
	}
	/** @param aptNum 要设置的 aptNum */
	public void setAptNum(String aptNum) {
		this.aptNum = aptNum;
	}
	/** @return floorTotal 楼层数 */
	public Integer getFloorTotal() {
		return floorTotal;
	}
	/** @param floorTotal 要设置的 floorTotal */
	public void setFloorTotal(Integer floorTotal) {
		this.floorTotal = floorTotal;
	}
	/** @return houseTotal 每层房间数 */
	public Integer getHouseTotal() {
		return houseTotal;
	}
	/** @param houseTotal 要设置的 houseTotal */
	public void setHouseTotal(Integer houseTotal) {
		this.houseTotal = houseTotal;
	}
	/** @return houseTypeId */
	public Integer getHouseTypeId() {
		return houseTypeId;
	}
	/** @param houseTypeId 要设置的 houseTypeId */
	public void setHouseTypeId(Integer houseTypeId) {
		this.houseTypeId = houseTypeId;
	}
}
