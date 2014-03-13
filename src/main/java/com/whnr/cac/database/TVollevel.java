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
 * TVollevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_vollevel", catalog = "intecomp_display")
public class TVollevel implements java.io.Serializable {

	// Fields

	private Long volLevelId;
	private String volLevel;
	private String remark;
	private Set<BtbSubstation> btbSubstations = new HashSet<BtbSubstation>(0);

	// Constructors

	/** default constructor */
	public TVollevel() {
	}

	/** minimal constructor */
	public TVollevel(String volLevel) {
		this.volLevel = volLevel;
	}

	/** full constructor */
	public TVollevel(String volLevel, String remark,
			Set<BtbSubstation> btbSubstations) {
		this.volLevel = volLevel;
		this.remark = remark;
		this.btbSubstations = btbSubstations;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "VolLevelID", unique = true, nullable = false)
	public Long getVolLevelId() {
		return this.volLevelId;
	}

	public void setVolLevelId(Long volLevelId) {
		this.volLevelId = volLevelId;
	}

	@Column(name = "VolLevel", nullable = false, length = 50)
	public String getVolLevel() {
		return this.volLevel;
	}

	public void setVolLevel(String volLevel) {
		this.volLevel = volLevel;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TVollevel")
	public Set<BtbSubstation> getBtbSubstations() {
		return this.btbSubstations;
	}

	public void setBtbSubstations(Set<BtbSubstation> btbSubstations) {
		this.btbSubstations = btbSubstations;
	}

}