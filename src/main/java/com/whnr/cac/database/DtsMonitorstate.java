package com.whnr.cac.database;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DtsMonitorstate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dts_monitorstate", catalog = "intecomp_display")
public class DtsMonitorstate implements java.io.Serializable {

	// Fields

	private Long monitorStateId;
	private BtMonitorparatype btMonitorparatype;
	private BtbMonitordeviceinfo btbMonitordeviceinfo;
	private Timestamp monitorTime;
	private String monitorStateValue;

	// Constructors

	/** default constructor */
	public DtsMonitorstate() {
	}

	/** minimal constructor */
	public DtsMonitorstate(BtMonitorparatype btMonitorparatype,
			BtbMonitordeviceinfo btbMonitordeviceinfo) {
		this.btMonitorparatype = btMonitorparatype;
		this.btbMonitordeviceinfo = btbMonitordeviceinfo;
	}

	/** full constructor */
	public DtsMonitorstate(BtMonitorparatype btMonitorparatype,
			BtbMonitordeviceinfo btbMonitordeviceinfo, Timestamp monitorTime,
			String monitorStateValue) {
		this.btMonitorparatype = btMonitorparatype;
		this.btbMonitordeviceinfo = btbMonitordeviceinfo;
		this.monitorTime = monitorTime;
		this.monitorStateValue = monitorStateValue;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MonitorStateID", unique = true, nullable = false)
	public Long getMonitorStateId() {
		return this.monitorStateId;
	}

	public void setMonitorStateId(Long monitorStateId) {
		this.monitorStateId = monitorStateId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MonitorParaTypeID", nullable = false)
	public BtMonitorparatype getBtMonitorparatype() {
		return this.btMonitorparatype;
	}

	public void setBtMonitorparatype(BtMonitorparatype btMonitorparatype) {
		this.btMonitorparatype = btMonitorparatype;
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

	@Column(name = "MonitorTime", length = 19)
	public Timestamp getMonitorTime() {
		return this.monitorTime;
	}

	public void setMonitorTime(Timestamp monitorTime) {
		this.monitorTime = monitorTime;
	}

	@Column(name = "MonitorStateValue", length = 20)
	public String getMonitorStateValue() {
		return this.monitorStateValue;
	}

	public void setMonitorStateValue(String monitorStateValue) {
		this.monitorStateValue = monitorStateValue;
	}

}