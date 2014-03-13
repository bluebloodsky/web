package com.whnr.cac.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BtbMonitordevicediagdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_monitordevicediagdetail", catalog = "intecomp_display")
public class BtbMonitordevicediagdetail implements java.io.Serializable {

	// Fields

	private String monitorDeviceDiagDetailId;
	private BtbMonitordevicediagnose btbMonitordevicediagnose;
	private BtbMonitordevicediagmode btbMonitordevicediagmode;
	private String monitorDeviceDiagResult;

	// Constructors

	/** default constructor */
	public BtbMonitordevicediagdetail() {
	}

	/** minimal constructor */
	public BtbMonitordevicediagdetail(String monitorDeviceDiagDetailId,
			BtbMonitordevicediagnose btbMonitordevicediagnose,
			BtbMonitordevicediagmode btbMonitordevicediagmode) {
		this.monitorDeviceDiagDetailId = monitorDeviceDiagDetailId;
		this.btbMonitordevicediagnose = btbMonitordevicediagnose;
		this.btbMonitordevicediagmode = btbMonitordevicediagmode;
	}

	/** full constructor */
	public BtbMonitordevicediagdetail(String monitorDeviceDiagDetailId,
			BtbMonitordevicediagnose btbMonitordevicediagnose,
			BtbMonitordevicediagmode btbMonitordevicediagmode,
			String monitorDeviceDiagResult) {
		this.monitorDeviceDiagDetailId = monitorDeviceDiagDetailId;
		this.btbMonitordevicediagnose = btbMonitordevicediagnose;
		this.btbMonitordevicediagmode = btbMonitordevicediagmode;
		this.monitorDeviceDiagResult = monitorDeviceDiagResult;
	}

	// Property accessors
	@Id
	@Column(name = "MonitorDeviceDiagDetailID", unique = true, nullable = false)
	public String getMonitorDeviceDiagDetailId() {
		return this.monitorDeviceDiagDetailId;
	}

	public void setMonitorDeviceDiagDetailId(String monitorDeviceDiagDetailId) {
		this.monitorDeviceDiagDetailId = monitorDeviceDiagDetailId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MonitorDeviceDiagnoseID", nullable = false)
	public BtbMonitordevicediagnose getBtbMonitordevicediagnose() {
		return this.btbMonitordevicediagnose;
	}

	public void setBtbMonitordevicediagnose(
			BtbMonitordevicediagnose btbMonitordevicediagnose) {
		this.btbMonitordevicediagnose = btbMonitordevicediagnose;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MonitorDeviceDiagModeID", nullable = false)
	public BtbMonitordevicediagmode getBtbMonitordevicediagmode() {
		return this.btbMonitordevicediagmode;
	}

	public void setBtbMonitordevicediagmode(
			BtbMonitordevicediagmode btbMonitordevicediagmode) {
		this.btbMonitordevicediagmode = btbMonitordevicediagmode;
	}

	@Column(name = "MonitorDeviceDiagResult", length = 50)
	public String getMonitorDeviceDiagResult() {
		return this.monitorDeviceDiagResult;
	}

	public void setMonitorDeviceDiagResult(String monitorDeviceDiagResult) {
		this.monitorDeviceDiagResult = monitorDeviceDiagResult;
	}

}