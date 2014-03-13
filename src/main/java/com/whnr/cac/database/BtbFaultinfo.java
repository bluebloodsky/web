package com.whnr.cac.database;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BtbFaultinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_faultinfo", catalog = "intecomp_display")
public class BtbFaultinfo implements java.io.Serializable {

	// Fields

	private Long faultInfoId;
	private BtbSubstationdevice btbSubstationdevice;
	private String faultInResult;
	private String analyzeTime;
	private Set<BtbFaultanalyze> btbFaultanalyzes = new HashSet<BtbFaultanalyze>(
			0);

	// Constructors

	/** default constructor */
	public BtbFaultinfo() {
	}

	/** minimal constructor */
	public BtbFaultinfo(Long faultInfoId,
			BtbSubstationdevice btbSubstationdevice) {
		this.faultInfoId = faultInfoId;
		this.btbSubstationdevice = btbSubstationdevice;
	}

	/** full constructor */
	public BtbFaultinfo(Long faultInfoId,
			BtbSubstationdevice btbSubstationdevice, String faultInResult,
			String analyzeTime, Set<BtbFaultanalyze> btbFaultanalyzes) {
		this.faultInfoId = faultInfoId;
		this.btbSubstationdevice = btbSubstationdevice;
		this.faultInResult = faultInResult;
		this.analyzeTime = analyzeTime;
		this.btbFaultanalyzes = btbFaultanalyzes;
	}

	// Property accessors
	@Id
	@Column(name = "FaultInfoID", unique = true, nullable = false)
	public Long getFaultInfoId() {
		return this.faultInfoId;
	}

	public void setFaultInfoId(Long faultInfoId) {
		this.faultInfoId = faultInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubstationDeviceID", nullable = false)
	public BtbSubstationdevice getBtbSubstationdevice() {
		return this.btbSubstationdevice;
	}

	public void setBtbSubstationdevice(BtbSubstationdevice btbSubstationdevice) {
		this.btbSubstationdevice = btbSubstationdevice;
	}

	@Column(name = "FaultInResult", length = 50)
	public String getFaultInResult() {
		return this.faultInResult;
	}

	public void setFaultInResult(String faultInResult) {
		this.faultInResult = faultInResult;
	}

	@Column(name = "AnalyzeTime", length = 10)
	public String getAnalyzeTime() {
		return this.analyzeTime;
	}

	public void setAnalyzeTime(String analyzeTime) {
		this.analyzeTime = analyzeTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbFaultinfo")
	public Set<BtbFaultanalyze> getBtbFaultanalyzes() {
		return this.btbFaultanalyzes;
	}

	public void setBtbFaultanalyzes(Set<BtbFaultanalyze> btbFaultanalyzes) {
		this.btbFaultanalyzes = btbFaultanalyzes;
	}

}