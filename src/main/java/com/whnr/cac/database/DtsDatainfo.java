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
 * DtsDatainfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dts_datainfo", catalog = "intecomp_display")
public class DtsDatainfo implements java.io.Serializable {

	// Fields

	private Long dataInfoId;
	private BtMonitorparatype btMonitorparatype;
	private BtbMonitordeviceinfo btbMonitordeviceinfo;
	private Timestamp monitorTime;
	private Double monitorDataValue;
	private String monitorDataState;

	// Constructors

	/** default constructor */
	public DtsDatainfo() {
	}

	/** minimal constructor */
	public DtsDatainfo(BtMonitorparatype btMonitorparatype,
			BtbMonitordeviceinfo btbMonitordeviceinfo) {
		this.btMonitorparatype = btMonitorparatype;
		this.btbMonitordeviceinfo = btbMonitordeviceinfo;
	}

	/** full constructor */
	public DtsDatainfo(BtMonitorparatype btMonitorparatype,
			BtbMonitordeviceinfo btbMonitordeviceinfo, Timestamp monitorTime,
			Double monitorDataValue, String monitorDataState) {
		this.btMonitorparatype = btMonitorparatype;
		this.btbMonitordeviceinfo = btbMonitordeviceinfo;
		this.monitorTime = monitorTime;
		this.monitorDataValue = monitorDataValue;
		this.monitorDataState = monitorDataState;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DataInfoID", unique = true, nullable = false)
	public Long getDataInfoId() {
		return this.dataInfoId;
	}

	public void setDataInfoId(Long dataInfoId) {
		this.dataInfoId = dataInfoId;
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

	@Column(name = "MonitorDataValue", precision = 10, scale = 3)
	public Double getMonitorDataValue() {
		return this.monitorDataValue;
	}

	public void setMonitorDataValue(Double monitorDataValue) {
		this.monitorDataValue = monitorDataValue;
	}

	@Column(name = "MonitorDataState", length = 20)
	public String getMonitorDataState() {
		return this.monitorDataState;
	}

	public void setMonitorDataState(String monitorDataState) {
		this.monitorDataState = monitorDataState;
	}

}