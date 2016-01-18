package com.shanghai.our.model;

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

@Entity
@Table(name = "t_houseitem", schema = "ours")
public class HouseInfoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int  id;
	/**
	 * 预订人
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="userid")
	private UserInfo userInfo;
	
	
	/**
	 * 房源信息
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="houseid")
	private HouseInfo houseInfo;
	
	
	/**
	 * 开始时间
	 */
	@Column
	private String beginTime;
	
	/**
	 * 结束时间
	 */
	@Column
	private String endTime;
	
	
	/**
	 * 订单状态 1:待付款 2：已付款  3：完成    4：取消
	 */
	@Column
	private int  status=1;
	
	@Column
	private String  memo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public HouseInfo getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
