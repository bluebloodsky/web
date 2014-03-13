package com.whnr.cac.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BtbMonitordevicediapara entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_monitordevicediapara", catalog = "intecomp_display")
public class BtbMonitordevicediapara implements java.io.Serializable {

	// Fields

	private Long monitorDeviceDiaParaId;
	private BtbMonitordevicediaparatype btbMonitordevicediaparatype;
	private BtbMonitordevicediagnose btbMonitordevicediagnose;
	private Double monitorDeviceDiaParaValue;
	private String monitorDeviceDiaParaStatus;

	// Constructors

	/** default constructor */
	public BtbMonitordevicediapara() {
	}

	/** minimal constructor */
	public BtbMonitordevicediapara(Long monitorDeviceDiaParaId,
			BtbMonitordevicediaparatype btbMonitordevicediaparatype,
			BtbMonitordevicediagnose btbMonitordevicediagnose) {
		this.monitorDeviceDiaParaId = monitorDeviceDiaParaId;
		this.btbMonitordevicediaparatype = btbMonitordevicediaparatype;
		this.btbMonitordevicediagnose = btbMonitordevicediagnose;
	}

	/** full constructor */
	public BtbMonitordevicediapara(Long monitorDeviceDiaParaId,
			BtbMonitordevicediaparatype btbMonitordevicediaparatype,
			BtbMonitordevicediagnose btbMonitordevicediagnose,
			Double monitorDeviceDiaParaValue, String monitorDeviceDiaParaStatus) {
		this.monitorDeviceDiaParaId = monitorDeviceDiaParaId;
		this.btbMonitordevicediaparatype = btbMonitordevicediaparatype;
		this.btbMonitordevicediagnose = btbMonitordevicediagnose;
		this.monitorDeviceDiaParaValue = monitorDeviceDiaParaValue;
		this.monitorDeviceDiaParaStatus = monitorDeviceDiaParaStatus;
	}

	// Property accessors
	@Id
	@Column(name = "MonitorDeviceDiaParaID", unique = true, nullable = false)
	public Long getMonitorDeviceDiaParaId() {
		return this.monitorDeviceDiaParaId;
	}

	public void setMonitorDeviceDiaParaId(Long monitorDeviceDiaParaId) {
		this.monitorDeviceDiaParaId = monitorDeviceDiaParaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MonitorDeviceDiaParaTypeID", nullable = false)
	public BtbMonitordevicediaparatype getBtbMonitordevicediaparatype() {
		return this.btbMonitordevicediaparatype;
	}

	public void setBtbMonitordevicediaparatype(
			BtbMonitordevicediaparatype btbMonitordevicediaparatype) {
		this.btbMonitordevicediaparatype = btbMonitordevicediaparatype;
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

	@Column(name = "MonitorDeviceDiaParaValue", precision = 10)
	public Double getMonitorDeviceDiaParaValue() {
		return this.monitorDeviceDiaParaValue;
	}

	public void setMonitorDeviceDiaParaValue(Double monitorDeviceDiaParaValue) {
		this.monitorDeviceDiaParaValue = monitorDeviceDiaParaValue;
	}

	@Column(name = "MonitorDeviceDiaParaStatus", length = 10)
	public String getMonitorDeviceDiaParaStatus() {
		return this.monitorDeviceDiaParaStatus;
	}

	public void setMonitorDeviceDiaParaStatus(String monitorDeviceDiaParaStatus) {
		this.monitorDeviceDiaParaStatus = monitorDeviceDiaParaStatus;
	}

}