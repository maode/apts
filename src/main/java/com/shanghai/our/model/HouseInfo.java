package com.shanghai.our.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**  
 * @Title: HouseInfo.java
 * @Package com.shanghai.our.model
 * @Description: 房屋实体类
 * @author code0   
 * @date 2016年1月18日 下午9:47:54 
 */
@Entity
@Table(name = "t_house")
public class HouseInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** @Fields id : 主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int  id;
	
	
	
	/** @Fields beginTime : 入住时间 */
	private Date beginTime;
	/** @Fields endTime : 到期时间 */
	private Date endTime;
	/** 与房屋类型【大套间，中套间，小套间……】的映射 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="house_Type_id")
	private HouseType houseType;
	/** @Fields price : 月租金 */
	private float price;
	/** @Fields aptNum : 所属楼座 */
	private String aptNum;
	/** @Fields floorNum : 所属楼层 */
	private Integer floorNum;
	/** @Fields houseNum : 房间号 */
	private String houseNum;
	/** @Fields status : 房屋状态 0闲置，1已租*/
	private String status="0";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	/** @return houseType */
	public HouseType getHouseType() {
		return houseType;
	}
	/** @param houseType 要设置的 houseType */
	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}
	/** @return floorNum */
	public Integer getFloorNum() {
		return floorNum;
	}
	/** @param floorNum 要设置的 floorNum */
	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}
	/** @return aptNum */
	public String getAptNum() {
		return aptNum;
	}
	/** @param aptNum 要设置的 aptNum */
	public void setAptNum(String aptNum) {
		this.aptNum = aptNum;
	}
	/** @return status */
	public String getStatus() {
		return status;
	}
	/** @param status 要设置的 status */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
