/**
 * 
 */
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

/**
 * @author code0
 *	图片实体类
 */
@Entity
@Table(name = "t_picture")
public class Picture implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	/** 文件名称 */
	private String name;
	/** 文件格式化后的名称 */
	private String formatName;
	/** 文件存放路径 */
	private String path;
	/** 与房屋的映射 */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="houseid")
	private HouseInfo houseInfo;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the formatName
	 */
	public String getFormatName() {
		return formatName;
	}
	/**
	 * @param formatName the formatName to set
	 */
	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the houseInfo
	 */
	public HouseInfo getHouseInfo() {
		return houseInfo;
	}
	/**
	 * @param houseInfo the houseInfo to set
	 */
	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}
}
