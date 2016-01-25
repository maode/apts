package com.shanghai.our.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**  
 * @Title: HouseHis.java
 * @Package com.shanghai.our.model
 * @Description: 房屋租住历史
 * @author code0   
 * @date 2016年1月21日 上午11:13:52 
 */
@Entity
@Table(name = "t_house_his")
public class HouseHis extends BaseDomain implements Serializable {

	/** @Fields serialVersionUID*/
	
	private static final long serialVersionUID = 1L;
	
	/** 主键*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/** 与房屋的映射 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="houseid")
	private HouseInfo houseInfo;
	/** @Fields renterName : 租户姓名 */
	private String renterName;
	/** @Fields telephone : 电话 */
	private String telephone;
	/** @Fields beginTime : 入住时间 */
	private Date beginTime;
	/** @Fields endTime : 到期时间 */
	private Date endTime;
	/** @Fields idCard : 身份证号 */
	private String idCard;
	/** @Fields memo : 备注 */
	private String memo;
	
	
	/** @return id */
	public Integer getId() {
		return id;
	}
	/** @param id 要设置的 id */
	public void setId(Integer id) {
		this.id = id;
	}
	/** @return houseInfo */
	public HouseInfo getHouseInfo() {
		return houseInfo;
	}
	/** @param houseInfo 要设置的 houseInfo */
	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}
	/** @return beginTime */
	public Date getBeginTime() {
		return beginTime;
	}
	/** @param beginTime 要设置的 beginTime */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	/** @return endTime */
	public Date getEndTime() {
		return endTime;
	}
	/** @param endTime 要设置的 endTime */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/** @return renterName */
	public String getRenterName() {
		return renterName;
	}
	/** @param renterName 要设置的 renterName */
	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}
	/** @return telephone */
	public String getTelephone() {
		return telephone;
	}
	/** @param telephone 要设置的 telephone */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/** @return idCard */
	public String getIdCard() {
		return idCard;
	}
	/** @param idCard 要设置的 idCard */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/** @return memo */
	public String getMemo() {
		return memo;
	}
	/** @param memo 要设置的 memo */
	public void setMemo(String memo) {
		this.memo = memo;
	}


}
