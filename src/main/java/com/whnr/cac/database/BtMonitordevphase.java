package com.whnr.cac.database;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BtMonitordevphase entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bt_monitordevphase", catalog = "intecomp_display")
public class BtMonitordevphase implements java.io.Serializable {

	// Fields

	private Long monitorDevPhaseId;
	private String phaseName;
	private String remark;
	private Set<BtbMonitordeviceinfo> btbMonitordeviceinfos = new HashSet<BtbMonitordeviceinfo>(
			0);

	// Constructors

	/** default constructor */
	public BtMonitordevphase() {
	}

	/** minimal constructor */
	public BtMonitordevphase(Long monitorDevPhaseId) {
		this.monitorDevPhaseId = monitorDevPhaseId;
	}

	/** full constructor */
	public BtMonitordevphase(Long monitorDevPhaseId, String phaseName,
			String remark, Set<BtbMonitordeviceinfo> btbMonitordeviceinfos) {
		this.monitorDevPhaseId = monitorDevPhaseId;
		this.phaseName = phaseName;
		this.remark = remark;
		this.btbMonitordeviceinfos = btbMonitordeviceinfos;
	}

	// Property accessors
	@Id
	@Column(name = "MonitorDevPhaseID", unique = true, nullable = false)
	public Long getMonitorDevPhaseId() {
		return this.monitorDevPhaseId;
	}

	public void setMonitorDevPhaseId(Long monitorDevPhaseId) {
		this.monitorDevPhaseId = monitorDevPhaseId;
	}

	@Column(name = "PhaseName", length = 30)
	public String getPhaseName() {
		return this.phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	@Column(name = "Remark", length = 225)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btMonitordevphase")
	public Set<BtbMonitordeviceinfo> getBtbMonitordeviceinfos() {
		return this.btbMonitordeviceinfos;
	}

	public void setBtbMonitordeviceinfos(
			Set<BtbMonitordeviceinfo> btbMonitordeviceinfos) {
		this.btbMonitordeviceinfos = btbMonitordeviceinfos;
	}

}