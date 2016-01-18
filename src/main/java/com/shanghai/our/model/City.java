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


@Entity
@Table(name = "city", schema = "ours")
public class City implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int  id;
	
	@Column
	private String cname;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="provinceid")
	private Province province;
	
	@Column
	private String  ckey;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getCkey() {
		return ckey;
	}

	public void setCkey(String ckey) {
		this.ckey = ckey;
	}
	
	
	

	
}
