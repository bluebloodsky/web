package com.whnr.cac.database;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TDevicetype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_devicetype", catalog = "intecomp_display")
public class TDevicetype implements java.io.Serializable {

	// Fields

	private Long deviceTypeId;
	private String deviceTypeName;
	private String deviceTypeDesc;
	private Long fatherId;
	private Long stateParaNum;
	private Boolean borS;
	private String remark;
	private Set<BtbSubstationdevice> btbSubstationdevices = new HashSet<BtbSubstationdevice>(
			0);
	private Set<BtbSubdevice> btbSubdevices = new HashSet<BtbSubdevice>(0);

	// Constructors

	/** default constructor */
	public TDevicetype() {
	}

	/** full constructor */
	public TDevicetype(String deviceTypeName, String deviceTypeDesc,
			Long fatherId, Long stateParaNum, Boolean borS, String remark,
			Set<BtbSubstationdevice> btbSubstationdevices,
			Set<BtbSubdevice> btbSubdevices) {
		this.deviceTypeName = deviceTypeName;
		this.deviceTypeDesc = deviceTypeDesc;
		this.fatherId = fatherId;
		this.stateParaNum = stateParaNum;
		this.borS = borS;
		this.remark = remark;
		this.btbSubstationdevices = btbSubstationdevices;
		this.btbSubdevices = btbSubdevices;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DeviceTypeID", unique = true, nullable = false)
	public Long getDeviceTypeId() {
		return this.deviceTypeId;
	}

	public void setDeviceTypeId(Long deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	@Column(name = "DeviceTypeName", length = 50)
	public String getDeviceTypeName() {
		return this.deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}

	@Column(name = "DeviceTypeDesc", length = 50)
	public String getDeviceTypeDesc() {
		return this.deviceTypeDesc;
	}

	public void setDeviceTypeDesc(String deviceTypeDesc) {
		this.deviceTypeDesc = deviceTypeDesc;
	}

	@Column(name = "FatherID")
	public Long getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

	@Column(name = "StateParaNum")
	public Long getStateParaNum() {
		return this.stateParaNum;
	}

	public void setStateParaNum(Long stateParaNum) {
		this.stateParaNum = stateParaNum;
	}

	@Column(name = "BorS", precision = 1, scale = 0)
	public Boolean getBorS() {
		return this.borS;
	}

	public void setBorS(Boolean borS) {
		this.borS = borS;
	}

	@Column(name = "Remark", length = 225)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDevicetype")
	public Set<BtbSubstationdevice> getBtbSubstationdevices() {
		return this.btbSubstationdevices;
	}

	public void setBtbSubstationdevices(
			Set<BtbSubstationdevice> btbSubstationdevices) {
		this.btbSubstationdevices = btbSubstationdevices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDevicetype")
	public Set<BtbSubdevice> getBtbSubdevices() {
		return this.btbSubdevices;
	}

	public void setBtbSubdevices(Set<BtbSubdevice> btbSubdevices) {
		this.btbSubdevices = btbSubdevices;
	}

}