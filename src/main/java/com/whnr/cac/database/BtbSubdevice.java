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

import org.springframework.core.annotation.Order;

/**
 * BtbSubdevice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_subdevice", catalog = "intecomp_display")
public class BtbSubdevice implements java.io.Serializable {

	// Fields

	private Long subDeviceId;
	private TDevicetype TDevicetype;
	private BtbSubstationdevice btbSubstationdevice;
	private String remark;
	private Set<BtbMonitordeviceinfo> btbMonitordeviceinfos = new HashSet<BtbMonitordeviceinfo>(
			0);

	// Constructors

	/** default constructor */
	public BtbSubdevice() {
	}

	/** minimal constructor */
	public BtbSubdevice(Long subDeviceId, TDevicetype TDevicetype,
			BtbSubstationdevice btbSubstationdevice) {
		this.subDeviceId = subDeviceId;
		this.TDevicetype = TDevicetype;
		this.btbSubstationdevice = btbSubstationdevice;
	}

	/** full constructor */
	public BtbSubdevice(Long subDeviceId, TDevicetype TDevicetype,
			BtbSubstationdevice btbSubstationdevice, String remark,
			Set<BtbMonitordeviceinfo> btbMonitordeviceinfos) {
		this.subDeviceId = subDeviceId;
		this.TDevicetype = TDevicetype;
		this.btbSubstationdevice = btbSubstationdevice;
		this.remark = remark;
		this.btbMonitordeviceinfos = btbMonitordeviceinfos;
	}

	// Property accessors
	@Id
	@Column(name = "SubDeviceID", unique = true, nullable = false)
	public Long getSubDeviceId() {
		return this.subDeviceId;
	}

	public void setSubDeviceId(Long subDeviceId) {
		this.subDeviceId = subDeviceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DeviceTypeID", nullable = false)
	public TDevicetype getTDevicetype() {
		return this.TDevicetype;
	}

	public void setTDevicetype(TDevicetype TDevicetype) {
		this.TDevicetype = TDevicetype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubstationDeviceID", nullable = false)
	public BtbSubstationdevice getBtbSubstationdevice() {
		return this.btbSubstationdevice;
	}

	public void setBtbSubstationdevice(BtbSubstationdevice btbSubstationdevice) {
		this.btbSubstationdevice = btbSubstationdevice;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbSubdevice")
	public Set<BtbMonitordeviceinfo> getBtbMonitordeviceinfos() {
		return this.btbMonitordeviceinfos;
	}

	public void setBtbMonitordeviceinfos(
			Set<BtbMonitordeviceinfo> btbMonitordeviceinfos) {
		this.btbMonitordeviceinfos = btbMonitordeviceinfos;
	}

}