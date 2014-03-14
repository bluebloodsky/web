package com.whnr.cac.database;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OrderBy;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbCominfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_cominfo", catalog = "intecomp_display")
public class TbCominfo implements java.io.Serializable {

	// Fields

	private Long comInfoId;
	private String companyName;
	private String comInfoName;
	private Set<BtbSubstation> btbSubstations = new HashSet<BtbSubstation>(0);

	// Constructors

	/** default constructor */
	public TbCominfo() {
	}

	/** full constructor */
	public TbCominfo(String companyName, String comInfoName,
			Set<BtbSubstation> btbSubstations) {
		this.companyName = companyName;
		this.comInfoName = comInfoName;
		this.btbSubstations = btbSubstations;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ComInfoID", unique = true, nullable = false)
	public Long getComInfoId() {
		return this.comInfoId;
	}

	public void setComInfoId(Long comInfoId) {
		this.comInfoId = comInfoId;
	}

	@Column(name = "CompanyName", length = 100)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "ComInfoName", length = 100)
	public String getComInfoName() {
		return this.comInfoName;
	}

	public void setComInfoName(String comInfoName) {
		this.comInfoName = comInfoName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbCominfo")
	@OrderBy(value = "substationId asc")
	public Set<BtbSubstation> getBtbSubstations() {
		return this.btbSubstations;
	}

	public void setBtbSubstations(Set<BtbSubstation> btbSubstations) {
		this.btbSubstations = btbSubstations;
	}

}