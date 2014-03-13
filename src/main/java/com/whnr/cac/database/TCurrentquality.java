package com.whnr.cac.database;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TCurrentquality entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_currentquality", catalog = "intecomp_display")
public class TCurrentquality implements java.io.Serializable {

	// Fields

	private Long currentQualityId;
	private String currentName;
	private String remark;
	private Set<BtbSubstation> btbSubstations = new HashSet<BtbSubstation>(0);

	// Constructors

	/** default constructor */
	public TCurrentquality() {
	}

	/** minimal constructor */
	public TCurrentquality(String currentName) {
		this.currentName = currentName;
	}

	/** full constructor */
	public TCurrentquality(String currentName, String remark,
			Set<BtbSubstation> btbSubstations) {
		this.currentName = currentName;
		this.remark = remark;
		this.btbSubstations = btbSubstations;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CurrentQualityID", unique = true, nullable = false)
	public Long getCurrentQualityId() {
		return this.currentQualityId;
	}

	public void setCurrentQualityId(Long currentQualityId) {
		this.currentQualityId = currentQualityId;
	}

	@Column(name = "CurrentName", nullable = false, length = 10)
	public String getCurrentName() {
		return this.currentName;
	}

	public void setCurrentName(String currentName) {
		this.currentName = currentName;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TCurrentquality")
	public Set<BtbSubstation> getBtbSubstations() {
		return this.btbSubstations;
	}

	public void setBtbSubstations(Set<BtbSubstation> btbSubstations) {
		this.btbSubstations = btbSubstations;
	}

}