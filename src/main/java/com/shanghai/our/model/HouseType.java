package com.shanghai.our.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
 * @Title: HouseInfo.java
 * @Package com.shanghai.our.model
 * @Description: 房屋类型实体类
 * @author code0   
 * @date 2016年1月18日 下午9:47:54 
 */
@Entity
@Table(name = "t_house_type")
public class HouseType implements Serializable{
	public HouseType() {}
	public HouseType(int id) {
		this.id = id;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** @Fields id : 主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int  id;
	
	
	/** @Fields name : 房屋类型名称【大套间，中套间，小套间……】 */
	private String name;
	/**
	 * 房间规格【固定写法：几室几厅几厨几卫】
	 */
	private String specification;
	/** @return id */
	public int getId() {
		return id;
	}
	/** @param id 要设置的 id */
	public void setId(int id) {
		this.id = id;
	}
	/** @return name */
	public String getName() {
		return name;
	}
	/** @param name 要设置的 name */
	public void setName(String name) {
		this.name = name;
	}
	/** @return specification */
	public String getSpecification() {
		return specification;
	}
	/** @param specification 要设置的 specification */
	public void setSpecification(String specification) {
		this.specification = specification;
	}

}
