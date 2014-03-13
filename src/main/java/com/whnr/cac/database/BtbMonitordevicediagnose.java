package com.whnr.cac.database;

import java.sql.Timestamp;
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
 * BtbMonitordevicediagnose entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_monitordevicediagnose", catalog = "intecomp_display")
public class BtbMonitordevicediagnose implements java.io.Serializable {

	// Fields

	private Long monitorDeviceDiagnoseId;
	private BtbMonitordeviceinfo btbMonitordeviceinfo;
	private Timestamp diagnoseTime;
	private String monitorDeviceDiaResult;
	private Set<BtbMonitordevicediagdetail> btbMonitordevicediagdetails = new HashSet<BtbMonitordevicediagdetail>(
			0);
	private Set<BtbMonitordevicediapara> btbMonitordevicediaparas = new HashSet<BtbMonitordevicediapara>(
			0);

	// Constructors

	/** default constructor */
	public BtbMonitordevicediagnose() {
	}

	/** minimal constructor */
	public BtbMonitordevicediagnose(Long monitorDeviceDiagnoseId,
			BtbMonitordeviceinfo btbMonitordeviceinfo) {
		this.monitorDeviceDiagnoseId = monitorDeviceDiagnoseId;
		this.btbMonitordeviceinfo = btbMonitordeviceinfo;
	}

	/** full constructor */
	public BtbMonitordevicediagnose(Long monitorDeviceDiagnoseId,
			BtbMonitordeviceinfo btbMonitordeviceinfo, Timestamp diagnoseTime,
			String monitorDeviceDiaResult,
			Set<BtbMonitordevicediagdetail> btbMonitordevicediagdetails,
			Set<BtbMonitordevicediapara> btbMonitordevicediaparas) {
		this.monitorDeviceDiagnoseId = monitorDeviceDiagnoseId;
		this.btbMonitordeviceinfo = btbMonitordeviceinfo;
		this.diagnoseTime = diagnoseTime;
		this.monitorDeviceDiaResult = monitorDeviceDiaResult;
		this.btbMonitordevicediagdetails = btbMonitordevicediagdetails;
		this.btbMonitordevicediaparas = btbMonitordevicediaparas;
	}

	// Property accessors
	@Id
	@Column(name = "MonitorDeviceDiagnoseID", unique = true, nullable = false)
	public Long getMonitorDeviceDiagnoseId() {
		return this.monitorDeviceDiagnoseId;
	}

	public void setMonitorDeviceDiagnoseId(Long monitorDeviceDiagnoseId) {
		this.monitorDeviceDiagnoseId = monitorDeviceDiagnoseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MonitorDeviceInfoID", nullable = false)
	public BtbMonitordeviceinfo getBtbMonitordeviceinfo() {
		return this.btbMonitordeviceinfo;
	}

	public void setBtbMonitordeviceinfo(
			BtbMonitordeviceinfo btbMonitordeviceinfo) {
		this.btbMonitordeviceinfo = btbMonitordeviceinfo;
	}

	@Column(name = "DiagnoseTime", length = 19)
	public Timestamp getDiagnoseTime() {
		return this.diagnoseTime;
	}

	public void setDiagnoseTime(Timestamp diagnoseTime) {
		this.diagnoseTime = diagnoseTime;
	}

	@Column(name = "MonitorDeviceDiaResult", length = 10)
	public String getMonitorDeviceDiaResult() {
		return this.monitorDeviceDiaResult;
	}

	public void setMonitorDeviceDiaResult(String monitorDeviceDiaResult) {
		this.monitorDeviceDiaResult = monitorDeviceDiaResult;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbMonitordevicediagnose")
	public Set<BtbMonitordevicediagdetail> getBtbMonitordevicediagdetails() {
		return this.btbMonitordevicediagdetails;
	}

	public void setBtbMonitordevicediagdetails(
			Set<BtbMonitordevicediagdetail> btbMonitordevicediagdetails) {
		this.btbMonitordevicediagdetails = btbMonitordevicediagdetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbMonitordevicediagnose")
	public Set<BtbMonitordevicediapara> getBtbMonitordevicediaparas() {
		return this.btbMonitordevicediaparas;
	}

	public void setBtbMonitordevicediaparas(
			Set<BtbMonitordevicediapara> btbMonitordevicediaparas) {
		this.btbMonitordevicediaparas = btbMonitordevicediaparas;
	}

}