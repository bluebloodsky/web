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
 * BtbMonitordevicediaparatype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_monitordevicediaparatype", catalog = "intecomp_display")
public class BtbMonitordevicediaparatype implements java.io.Serializable {

	// Fields

	private String monitorDeviceDiaParaTypeId;
	private String monitorDeviceDiaParaName;
	private String monitorDeviceDiaParaTypeDesc;
	private Set<BtbMonitordevicediapara> btbMonitordevicediaparas = new HashSet<BtbMonitordevicediapara>(
			0);

	// Constructors

	/** default constructor */
	public BtbMonitordevicediaparatype() {
	}

	/** minimal constructor */
	public BtbMonitordevicediaparatype(String monitorDeviceDiaParaTypeId) {
		this.monitorDeviceDiaParaTypeId = monitorDeviceDiaParaTypeId;
	}

	/** full constructor */
	public BtbMonitordevicediaparatype(String monitorDeviceDiaParaTypeId,
			String monitorDeviceDiaParaName,
			String monitorDeviceDiaParaTypeDesc,
			Set<BtbMonitordevicediapara> btbMonitordevicediaparas) {
		this.monitorDeviceDiaParaTypeId = monitorDeviceDiaParaTypeId;
		this.monitorDeviceDiaParaName = monitorDeviceDiaParaName;
		this.monitorDeviceDiaParaTypeDesc = monitorDeviceDiaParaTypeDesc;
		this.btbMonitordevicediaparas = btbMonitordevicediaparas;
	}

	// Property accessors
	@Id
	@Column(name = "MonitorDeviceDiaParaTypeID", unique = true, nullable = false, length = 10)
	public String getMonitorDeviceDiaParaTypeId() {
		return this.monitorDeviceDiaParaTypeId;
	}

	public void setMonitorDeviceDiaParaTypeId(String monitorDeviceDiaParaTypeId) {
		this.monitorDeviceDiaParaTypeId = monitorDeviceDiaParaTypeId;
	}

	@Column(name = "MonitorDeviceDiaParaName", length = 20)
	public String getMonitorDeviceDiaParaName() {
		return this.monitorDeviceDiaParaName;
	}

	public void setMonitorDeviceDiaParaName(String monitorDeviceDiaParaName) {
		this.monitorDeviceDiaParaName = monitorDeviceDiaParaName;
	}

	@Column(name = "MonitorDeviceDiaParaTypeDesc", length = 50)
	public String getMonitorDeviceDiaParaTypeDesc() {
		return this.monitorDeviceDiaParaTypeDesc;
	}

	public void setMonitorDeviceDiaParaTypeDesc(
			String monitorDeviceDiaParaTypeDesc) {
		this.monitorDeviceDiaParaTypeDesc = monitorDeviceDiaParaTypeDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbMonitordevicediaparatype")
	public Set<BtbMonitordevicediapara> getBtbMonitordevicediaparas() {
		return this.btbMonitordevicediaparas;
	}

	public void setBtbMonitordevicediaparas(
			Set<BtbMonitordevicediapara> btbMonitordevicediaparas) {
		this.btbMonitordevicediaparas = btbMonitordevicediaparas;
	}

}