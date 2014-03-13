package com.whnr.cac.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BtbFaultanalyze entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_faultanalyze", catalog = "intecomp_display")
public class BtbFaultanalyze implements java.io.Serializable {

	// Fields

	private Long faultAnalyzeId;
	private BtbFaultinfo btbFaultinfo;
	private String faultAnalyzeReason;
	private String adviceExperience;

	// Constructors

	/** default constructor */
	public BtbFaultanalyze() {
	}

	/** minimal constructor */
	public BtbFaultanalyze(Long faultAnalyzeId, BtbFaultinfo btbFaultinfo) {
		this.faultAnalyzeId = faultAnalyzeId;
		this.btbFaultinfo = btbFaultinfo;
	}

	/** full constructor */
	public BtbFaultanalyze(Long faultAnalyzeId, BtbFaultinfo btbFaultinfo,
			String faultAnalyzeReason, String adviceExperience) {
		this.faultAnalyzeId = faultAnalyzeId;
		this.btbFaultinfo = btbFaultinfo;
		this.faultAnalyzeReason = faultAnalyzeReason;
		this.adviceExperience = adviceExperience;
	}

	// Property accessors
	@Id
	@Column(name = "FaultAnalyzeID", unique = true, nullable = false)
	public Long getFaultAnalyzeId() {
		return this.faultAnalyzeId;
	}

	public void setFaultAnalyzeId(Long faultAnalyzeId) {
		this.faultAnalyzeId = faultAnalyzeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FaultInfoID", nullable = false)
	public BtbFaultinfo getBtbFaultinfo() {
		return this.btbFaultinfo;
	}

	public void setBtbFaultinfo(BtbFaultinfo btbFaultinfo) {
		this.btbFaultinfo = btbFaultinfo;
	}

	@Column(name = "FaultAnalyzeReason", length = 100)
	public String getFaultAnalyzeReason() {
		return this.faultAnalyzeReason;
	}

	public void setFaultAnalyzeReason(String faultAnalyzeReason) {
		this.faultAnalyzeReason = faultAnalyzeReason;
	}

	@Column(name = "AdviceExperience", length = 80)
	public String getAdviceExperience() {
		return this.adviceExperience;
	}

	public void setAdviceExperience(String adviceExperience) {
		this.adviceExperience = adviceExperience;
	}

}