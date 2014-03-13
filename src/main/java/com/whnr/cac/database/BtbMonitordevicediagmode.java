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
 * BtbMonitordevicediagmode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_monitordevicediagmode", catalog = "intecomp_display")
public class BtbMonitordevicediagmode implements java.io.Serializable {

	// Fields

	private Long monitorDeviceDiagModeId;
	private String monitorDeviceDiagModeName;
	private String monitorDeviceDiagTypeDesc;
	private Set<BtbMonitordevicediagdetail> btbMonitordevicediagdetails = new HashSet<BtbMonitordevicediagdetail>(
			0);

	// Constructors

	/** default constructor */
	public BtbMonitordevicediagmode() {
	}

	/** minimal constructor */
	public BtbMonitordevicediagmode(Long monitorDeviceDiagModeId) {
		this.monitorDeviceDiagModeId = monitorDeviceDiagModeId;
	}

	/** full constructor */
	public BtbMonitordevicediagmode(Long monitorDeviceDiagModeId,
			String monitorDeviceDiagModeName, String monitorDeviceDiagTypeDesc,
			Set<BtbMonitordevicediagdetail> btbMonitordevicediagdetails) {
		this.monitorDeviceDiagModeId = monitorDeviceDiagModeId;
		this.monitorDeviceDiagModeName = monitorDeviceDiagModeName;
		this.monitorDeviceDiagTypeDesc = monitorDeviceDiagTypeDesc;
		this.btbMonitordevicediagdetails = btbMonitordevicediagdetails;
	}

	// Property accessors
	@Id
	@Column(name = "MonitorDeviceDiagModeID", unique = true, nullable = false)
	public Long getMonitorDeviceDiagModeId() {
		return this.monitorDeviceDiagModeId;
	}

	public void setMonitorDeviceDiagModeId(Long monitorDeviceDiagModeId) {
		this.monitorDeviceDiagModeId = monitorDeviceDiagModeId;
	}

	@Column(name = "MonitorDeviceDiagModeName", length = 20)
	public String getMonitorDeviceDiagModeName() {
		return this.monitorDeviceDiagModeName;
	}

	public void setMonitorDeviceDiagModeName(String monitorDeviceDiagModeName) {
		this.monitorDeviceDiagModeName = monitorDeviceDiagModeName;
	}

	@Column(name = "MonitorDeviceDiagTypeDesc", length = 50)
	public String getMonitorDeviceDiagTypeDesc() {
		return this.monitorDeviceDiagTypeDesc;
	}

	public void setMonitorDeviceDiagTypeDesc(String monitorDeviceDiagTypeDesc) {
		this.monitorDeviceDiagTypeDesc = monitorDeviceDiagTypeDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbMonitordevicediagmode")
	public Set<BtbMonitordevicediagdetail> getBtbMonitordevicediagdetails() {
		return this.btbMonitordevicediagdetails;
	}

	public void setBtbMonitordevicediagdetails(
			Set<BtbMonitordevicediagdetail> btbMonitordevicediagdetails) {
		this.btbMonitordevicediagdetails = btbMonitordevicediagdetails;
	}

}