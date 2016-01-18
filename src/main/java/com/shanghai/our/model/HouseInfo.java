package com.shanghai.our.model;

import java.io.Serializable;

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
import javax.persistence.Transient;
@Entity
@Table(name = "t_house", schema = "ours")
public class HouseInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int  id;
	
	/**
	 * 检索key
	 */
	@Transient
	private String key;
	/**
	 * 预订入住时间
	 */
	@Transient
	private String beginTime;
	
	/**
	 * 预订退房时间
	 */
	@Transient
	private String endTime;
	@Transient
	private Integer[]  houseTypes;
	
	
	/**卧室数 -y*/
	private int roomNum;//有个房间个数[houseNum] ，目前都保留
	/**房屋图片 */
	private String picture;//图片要看看怎么映射
	/**摘要 -y*/
	private String info;
	/**地址-y */
	private String addr;
	/**可选信息-房源-? */
	private String choose1;
	/**可选信息—权限-? */
	private String choose2;
	/**可选信息-互动-? */
	private String choose3;
	/**可选信息-概述-? */
	private String choose4;
	/**可选信息-出行-? */
	private String choose5;
	/**可选信息-其他-? */
	private String choose6;
	/**有无探测器-y */
	private int smokFlag;
	/**
	 * 房客数量-y
	 */
	@Column
	private int peopleNum;
	/**
	 * 房源类型 1：独立房间 2：合住房间 3：整套房子-y
	 */
	@Column
	private int houseType;
	
	/**
	 * 房间类型【rommtype】-y
	 * 
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="propertyid")
	private  HouseProperty  houseProperty;
	/**
	 * 发布人 用户
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name="userid")
	private  UserInfo  userInfo;
	
	/**
	 * 发布人 管理员
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name="adminid")
	private  Admin  admin;
	
	
	
	/**
	 * 所属省份-y
	 * 
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name="provinceid")
	private  Province  province;
	
	/**
	 * 所属城市-y
	 * 
	 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="cityid")
	private  City  city;
	
	/**
	 * 是否即时预订 1：否 2：是-y
	 */
	@Column
	private  int orderFlag;
	
	/**
	 * 价格-y
	 */
	@Column
	private float price;
	
	/**
	 * 长期住宿价格
	 */
	@Column
	private float longPrice;
	
	/**
	 * 房间个数-y
	 */
	@Column
	private int houseNum;
	
	/**
	 * 床位个数-y
	 */
	@Column
	private int bedNum;
	
	/**
	 * 卫生间个数-y
	 */
	@Column
	private int toiletNum;
	
	/**
	 * 有无wifi-y
	 */
	@Column
	private  int wifiFlag;
	
	/**
	 * 有无厨房-y
	 */
	@Column
	private int kitchenFlag;
	
	/**
	 * 有无游泳池-y
	 */
	@Column
	private int swimmingFlag;
	
	/**
	 * 有无空调
	 */
	@Column
	private int airConditioningFlag;
	
	/**
	 * 有无电视
	 */
	@Column
	private int  tvFlag;
	
	/**
	 * 有无有线电视
	 */
	@Column
	private int wiredTvFlag;
	
	/**
	 * 有无网络
	 */
	@Column
	private int netFlag;
	
	/**
	 * 有无障碍物
	 */
	@Column
	private int accessibleFlag;
	
	/**
	 * 有无停车场
	 */
	@Column
	private int carFlag;
	
	/**
	 * 是否有吸烟场所
	 */
	@Column
	private int smokeFlag;
	/**
	 *	有无携带宠物 
	 */
	@Column
	private int dogFlag;
	
	/**
	 * 有无门卫
	 */
	@Column
	private int doorFlag;
	/**
	 * 有无健身房
	 */
	@Column
	private int gymFlag;
	
	/**
	 * 是否提供早餐
	 */
	@Column
	private int breakfastFlag;
	
	/**
	 * 有无电梯
	 */
	@Column
	private int elevatorFlag;
	
	/**
	 * 有无浴缸
	 */
	@Column
	private int crockflag;
	/**
	 *有无壁炉
	 */
	@Column
	private int fireplaceFlag;
	/**
	 * 有无对讲机
	 */
	@Column
	private int intercomFlag;
	/**
	 * 有无暖气
	 */
	@Column
	private int heatingFlag;
	/**
	 * 是否适合家庭入住--y
	 */
	@Column
	private int familyFlag;
	/**
	 * 是否适合举办活动
	 */
	@Column
	private int actFlag;
	/**
	 * 有无洗衣机
	 */
	@Column
	private int washingFlag;
	/**
	 * 有无烘干机
	 */
	@Column
	private int dryerFlag;
	
	/**
	 * 有无探测仪
	 */
	@Column
	private int  carbonFlag;
	/**
	 * 有无一氧化碳探测器
	 */
	@Column
	private int carbonCOFlag;
	/**
	 * 有无急救包
	 */
	@Column
	private int firstAidFlag;
	
	/**
	 * 有无安全卡
	 */
	@Column
	private int safetyFlag;
	/**
	 *有无灭火器
	 */
	@Column
	private int annihilatorFlag;
	
	/**
	 * 有无毛巾等
	 */
	@Column
	private int towelFlag;
	/**
	 * 有无洗发水
	 */
	@Column
	private int shampooFlag;
	
	/**
	 * 房源状态1：可出租 2：不可出租（ngSet;//是否有效）
	 */ 
	@Column
	private int status=1;
	
	/**
	 * 是否审批通过 1：未审批 2：审批通过
	 */
	@Column
	private  int appStatus;
	
	/**
	 * 是否删除 1：正常 2：已删除
	 */
	@Column 
	private int delFlag=1;
	
	/**
	 * 标题-y
	 */
	@Column
	private  String title;
	
	/**
	 * 环境描述-y
	 */
	@Column
	private String  surroundings;
	
	/**
	 * 详情
	 */
	/**
	 * 房源独特之处-y
	 */
	@Column
	private String  houseSpecialMemo;
	
	/**
	 * 访客使用权限-y
	 */
	@Column
	private String   houseAuthMemo;
	
	/**
	 * 与访客互动-y
	 */
	@Column
	private String   chartToCustomMemo;
	/**
	 * 概述-y
	 */
	@Column
	public String  memo;
	/**
	 * 公共交通描述-y
	 */
	@Column
	private String trafficMemo;
	/**
	 * 访客注意事项-y
	 */
	@Column
	private String  customNoticeMemo;
	/**
	 * 对访客举止要求-y
	 */
	@Column
	private String  customAgreeMemo;
	
	/**
	 * 经度-y
	 */
	@Column
	private float longitude ;
	
	/**
	 * 纬度-y
	 */
	@Column
	private float latitude;
	
	@Column
	private String createTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	public int getHouseType() {
		return houseType;
	}
	public void setHouseType(int houseType) {
		this.houseType = houseType;
	}
	public int getOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(int orderFlag) {
		this.orderFlag = orderFlag;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	public int getBedNum() {
		return bedNum;
	}
	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}
	public int getToiletNum() {
		return toiletNum;
	}
	public void setToiletNum(int toiletNum) {
		this.toiletNum = toiletNum;
	}
	public int getWifiFlag() {
		return wifiFlag;
	}
	public void setWifiFlag(int wifiFlag) {
		this.wifiFlag = wifiFlag;
	}
	public int getKitchenFlag() {
		return kitchenFlag;
	}
	public void setKitchenFlag(int kitchenFlag) {
		this.kitchenFlag = kitchenFlag;
	}
	public int getSwimmingFlag() {
		return swimmingFlag;
	}
	public void setSwimmingFlag(int swimmingFlag) {
		this.swimmingFlag = swimmingFlag;
	}
	public int getAirConditioningFlag() {
		return airConditioningFlag;
	}
	public void setAirConditioningFlag(int airConditioningFlag) {
		this.airConditioningFlag = airConditioningFlag;
	}
	public int getTvFlag() {
		return tvFlag;
	}
	public void setTvFlag(int tvFlag) {
		this.tvFlag = tvFlag;
	}
	public int getWiredTvFlag() {
		return wiredTvFlag;
	}
	public void setWiredTvFlag(int wiredTvFlag) {
		this.wiredTvFlag = wiredTvFlag;
	}
	public int getNetFlag() {
		return netFlag;
	}
	public void setNetFlag(int netFlag) {
		this.netFlag = netFlag;
	}
	public int getAccessibleFlag() {
		return accessibleFlag;
	}
	public void setAccessibleFlag(int accessibleFlag) {
		this.accessibleFlag = accessibleFlag;
	}
	public int getCarFlag() {
		return carFlag;
	}
	public void setCarFlag(int carFlag) {
		this.carFlag = carFlag;
	}
	public int getSmokeFlag() {
		return smokeFlag;
	}
	public void setSmokeFlag(int smokeFlag) {
		this.smokeFlag = smokeFlag;
	}
	public int getDogFlag() {
		return dogFlag;
	}
	public void setDogFlag(int dogFlag) {
		this.dogFlag = dogFlag;
	}
	public int getDoorFlag() {
		return doorFlag;
	}
	public void setDoorFlag(int doorFlag) {
		this.doorFlag = doorFlag;
	}
	public int getGymFlag() {
		return gymFlag;
	}
	public void setGymFlag(int gymFlag) {
		this.gymFlag = gymFlag;
	}
	public int getBreakfastFlag() {
		return breakfastFlag;
	}
	public void setBreakfastFlag(int breakfastFlag) {
		this.breakfastFlag = breakfastFlag;
	}
	public int getElevatorFlag() {
		return elevatorFlag;
	}
	public void setElevatorFlag(int elevatorFlag) {
		this.elevatorFlag = elevatorFlag;
	}
	public int getCrockflag() {
		return crockflag;
	}
	public void setCrockflag(int crockflag) {
		this.crockflag = crockflag;
	}
	public int getFireplaceFlag() {
		return fireplaceFlag;
	}
	public void setFireplaceFlag(int fireplaceFlag) {
		this.fireplaceFlag = fireplaceFlag;
	}
	public int getIntercomFlag() {
		return intercomFlag;
	}
	public void setIntercomFlag(int intercomFlag) {
		this.intercomFlag = intercomFlag;
	}
	public int getHeatingFlag() {
		return heatingFlag;
	}
	public void setHeatingFlag(int heatingFlag) {
		this.heatingFlag = heatingFlag;
	}
	public int getFamilyFlag() {
		return familyFlag;
	}
	public void setFamilyFlag(int familyFlag) {
		this.familyFlag = familyFlag;
	}
	public int getActFlag() {
		return actFlag;
	}
	public void setActFlag(int actFlag) {
		this.actFlag = actFlag;
	}
	public int getWashingFlag() {
		return washingFlag;
	}
	public void setWashingFlag(int washingFlag) {
		this.washingFlag = washingFlag;
	}
	public int getDryerFlag() {
		return dryerFlag;
	}
	public void setDryerFlag(int dryerFlag) {
		this.dryerFlag = dryerFlag;
	}
	public int getCarbonFlag() {
		return carbonFlag;
	}
	public void setCarbonFlag(int carbonFlag) {
		this.carbonFlag = carbonFlag;
	}
	public int getCarbonCOFlag() {
		return carbonCOFlag;
	}
	public void setCarbonCOFlag(int carbonCOFlag) {
		this.carbonCOFlag = carbonCOFlag;
	}
	public int getFirstAidFlag() {
		return firstAidFlag;
	}
	public void setFirstAidFlag(int firstAidFlag) {
		this.firstAidFlag = firstAidFlag;
	}
	public int getSafetyFlag() {
		return safetyFlag;
	}
	public void setSafetyFlag(int safetyFlag) {
		this.safetyFlag = safetyFlag;
	}
	public int getAnnihilatorFlag() {
		return annihilatorFlag;
	}
	public void setAnnihilatorFlag(int annihilatorFlag) {
		this.annihilatorFlag = annihilatorFlag;
	}
	public int getTowelFlag() {
		return towelFlag;
	}
	public void setTowelFlag(int towelFlag) {
		this.towelFlag = towelFlag;
	}
	public int getShampooFlag() {
		return shampooFlag;
	}
	public void setShampooFlag(int shampooFlag) {
		this.shampooFlag = shampooFlag;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSurroundings() {
		return surroundings;
	}
	public void setSurroundings(String surroundings) {
		this.surroundings = surroundings;
	}
	public String getHouseSpecialMemo() {
		return houseSpecialMemo;
	}
	public void setHouseSpecialMemo(String houseSpecialMemo) {
		this.houseSpecialMemo = houseSpecialMemo;
	}
	public String getHouseAuthMemo() {
		return houseAuthMemo;
	}
	public void setHouseAuthMemo(String houseAuthMemo) {
		this.houseAuthMemo = houseAuthMemo;
	}
	public String getChartToCustomMemo() {
		return chartToCustomMemo;
	}
	public void setChartToCustomMemo(String chartToCustomMemo) {
		this.chartToCustomMemo = chartToCustomMemo;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTrafficMemo() {
		return trafficMemo;
	}
	public void setTrafficMemo(String trafficMemo) {
		this.trafficMemo = trafficMemo;
	}
	public String getCustomNoticeMemo() {
		return customNoticeMemo;
	}
	public void setCustomNoticeMemo(String customNoticeMemo) {
		this.customNoticeMemo = customNoticeMemo;
	}
	public String getCustomAgreeMemo() {
		return customAgreeMemo;
	}
	public void setCustomAgreeMemo(String customAgreeMemo) {
		this.customAgreeMemo = customAgreeMemo;
	}
	public float getLongPrice() {
		return longPrice;
	}
	public void setLongPrice(float longPrice) {
		this.longPrice = longPrice;
	}
	public int getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(int appStatus) {
		this.appStatus = appStatus;
	}
	public HouseProperty getHouseProperty() {
		return houseProperty;
	}
	public void setHouseProperty(HouseProperty houseProperty) {
		this.houseProperty = houseProperty;
	}
	public Integer[] getHouseTypes() {
		return houseTypes;
	}
	public void setHouseTypes(Integer[] houseTypes) {
		this.houseTypes = houseTypes;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the roomNum
	 */
	public int getRoomNum() {
		return roomNum;
	}
	/**
	 * @param roomNum the roomNum to set
	 */
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * @return the choose1
	 */
	public String getChoose1() {
		return choose1;
	}
	/**
	 * @param choose1 the choose1 to set
	 */
	public void setChoose1(String choose1) {
		this.choose1 = choose1;
	}
	/**
	 * @return the choose2
	 */
	public String getChoose2() {
		return choose2;
	}
	/**
	 * @param choose2 the choose2 to set
	 */
	public void setChoose2(String choose2) {
		this.choose2 = choose2;
	}
	/**
	 * @return the choose3
	 */
	public String getChoose3() {
		return choose3;
	}
	/**
	 * @param choose3 the choose3 to set
	 */
	public void setChoose3(String choose3) {
		this.choose3 = choose3;
	}
	/**
	 * @return the choose4
	 */
	public String getChoose4() {
		return choose4;
	}
	/**
	 * @param choose4 the choose4 to set
	 */
	public void setChoose4(String choose4) {
		this.choose4 = choose4;
	}
	/**
	 * @return the choose5
	 */
	public String getChoose5() {
		return choose5;
	}
	/**
	 * @param choose5 the choose5 to set
	 */
	public void setChoose5(String choose5) {
		this.choose5 = choose5;
	}
	/**
	 * @return the choose6
	 */
	public String getChoose6() {
		return choose6;
	}
	/**
	 * @param choose6 the choose6 to set
	 */
	public void setChoose6(String choose6) {
		this.choose6 = choose6;
	}
	/**
	 * @return the smokFlag
	 */
	public int getSmokFlag() {
		return smokFlag;
	}
	/**
	 * @param smokFlag the smokFlag to set
	 */
	public void setSmokFlag(int smokFlag) {
		this.smokFlag = smokFlag;
	}
	

	
	

	
	
	
	
	
	
	
}
