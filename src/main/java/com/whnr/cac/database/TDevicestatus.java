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
 * TDevicestatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_devicestatus", catalog = "intecomp_display")
public class TDevicestatus implements java.io.Serializable {

	// Fields

	private Long deviceStatusId;
	private String deviceStatusName;
	private String deviceStatusDesc;
	private String remark;
	private Set<BtzStateeval> btzStateevals = new HashSet<BtzStateeval>(0);

	// Constructors

	/** default constructor */
	public TDevicestatus() {
	}

	/** minimal constructor */
	public TDevicestatus(Long deviceStatusId) {
		this.deviceStatusId = deviceStatusId;
	}

	/** full constructor */
	public TDevicestatus(Long deviceStatusId, String deviceStatusName,
			String deviceStatusDesc, String remark,
			Set<BtzStateeval> btzStateevals) {
		this.deviceStatusId = deviceStatusId;
		this.deviceStatusName = deviceStatusName;
		this.deviceStatusDesc = deviceStatusDesc;
		this.remark = remark;
		this.btzStateevals = btzStateevals;
	}

	// Property accessors
	@Id
	@Column(name = "DeviceStatusID", unique = true, nullable = false)
	public Long getDeviceStatusId() {
		return this.deviceStatusId;
	}

	public void setDeviceStatusId(Long deviceStatusId) {
		this.deviceStatusId = deviceStatusId;
	}

	@Column(name = "DeviceStatusName", length = 20)
	public String getDeviceStatusName() {
		return this.deviceStatusName;
	}

	public void setDeviceStatusName(String deviceStatusName) {
		this.deviceStatusName = deviceStatusName;
	}

	@Column(name = "DeviceStatusDesc", length = 10)
	public String getDeviceStatusDesc() {
		return this.deviceStatusDesc;
	}

	public void setDeviceStatusDesc(String deviceStatusDesc) {
		this.deviceStatusDesc = deviceStatusDesc;
	}

	@Column(name = "Remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDevicestatus")
	public Set<BtzStateeval> getBtzStateevals() {
		return this.btzStateevals;
	}

	public void setBtzStateevals(Set<BtzStateeval> btzStateevals) {
		this.btzStateevals = btzStateevals;
	}

}