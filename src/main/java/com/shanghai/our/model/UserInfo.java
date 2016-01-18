package com.shanghai.our.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_userinfo", schema = "ours")
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int  id;
	
	/**
	 * 用户名
	 */
	@Column
	private String username;
	/**
	 * 密码
	 */
	@Column
	private String password;
	
	/**
	 * 真是姓名
	 */
	@Column
	private String realname;
	/**
	 * 性别 1:男 2：女
	 */
	@Column
	private Integer gender;
	/**
	 * 生日
	 */
	@Column
	private String birthday;
	/**
	 * 手机号码
	 */
	@Column
	private String telephone;
	/**
	 * 居住地址
	 */
	@Column
	private String address;
	/**
	 * 自我简介
	 */
	@Column
	private String memo;
	
	/**
	 * 收货地址
	 */
	@Column
	private String shaddress;
	/**
	 * 邮箱
	 */
	@Column
	private String email;
	
	/**
	 * 身份验证照片
	 */
	@Column
	private String idcardPath;
	
	@Column
	private String  fileName;
	
	
	@Column
	private String createTime;
	
	/**
	 * 是否验证通过 1：未通过  2：通过
	 */
	@Column
	private Integer status;
	
	/**
	 * 是否删除  1：正常  2：删除
	 */
	@Column
	private Integer delFlag;
	
	@Column
	private String  appMsg;
	
	@Column
	private String  job;
	
	@Column
	private String  school;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getShaddress() {
		return shaddress;
	}

	public void setShaddress(String shaddress) {
		this.shaddress = shaddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcardPath() {
		return idcardPath;
	}

	public void setIdcardPath(String idcardPath) {
		this.idcardPath = idcardPath;
	}

	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAppMsg() {
		return appMsg;
	}

	public void setAppMsg(String appMsg) {
		this.appMsg = appMsg;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	

}
