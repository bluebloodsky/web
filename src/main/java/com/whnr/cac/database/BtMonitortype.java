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
 * BtMonitortype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bt_monitortype", catalog = "intecomp_display")
public class BtMonitortype implements java.io.Serializable {

	// Fields

	private Long monitorTypeId;
	private String monitorTypeName;
	private String moniTorTypeDesc;
	private Integer showMethod;
	private String remark;
	private Set<BtbMonitordeviceinfo> btbMonitordeviceinfos = new HashSet<BtbMonitordeviceinfo>(
			0);
	private Set<BtMonitorparatype> btMonitorparatypes = new HashSet<BtMonitorparatype>(
			0);

	// Constructors

	/** default constructor */
	public BtMonitortype() {
	}

	/** full constructor */
	public BtMonitortype(String monitorTypeName, String moniTorTypeDesc,
			Integer showMethod, String remark,
			Set<BtbMonitordeviceinfo> btbMonitordeviceinfos,
			Set<BtMonitorparatype> btMonitorparatypes) {
		this.monitorTypeName = monitorTypeName;
		this.moniTorTypeDesc = moniTorTypeDesc;
		this.showMethod = showMethod;
		this.remark = remark;
		this.btbMonitordeviceinfos = btbMonitordeviceinfos;
		this.btMonitorparatypes = btMonitorparatypes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MonitorTypeID", unique = true, nullable = false)
	public Long getMonitorTypeId() {
		return this.monitorTypeId;
	}

	public void setMonitorTypeId(Long monitorTypeId) {
		this.monitorTypeId = monitorTypeId;
	}

	@Column(name = "MonitorTypeName", length = 20)
	public String getMonitorTypeName() {
		return this.monitorTypeName;
	}

	public void setMonitorTypeName(String monitorTypeName) {
		this.monitorTypeName = monitorTypeName;
	}

	@Column(name = "MoniTorTypeDesc", length = 20)
	public String getMoniTorTypeDesc() {
		return this.moniTorTypeDesc;
	}

	public void setMoniTorTypeDesc(String moniTorTypeDesc) {
		this.moniTorTypeDesc = moniTorTypeDesc;
	}

	@Column(name = "ShowMethod")
	public Integer getShowMethod() {
		return this.showMethod;
	}

	public void setShowMethod(Integer showMethod) {
		this.showMethod = showMethod;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btMonitortype")
	public Set<BtbMonitordeviceinfo> getBtbMonitordeviceinfos() {
		return this.btbMonitordeviceinfos;
	}

	public void setBtbMonitordeviceinfos(
			Set<BtbMonitordeviceinfo> btbMonitordeviceinfos) {
		this.btbMonitordeviceinfos = btbMonitordeviceinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btMonitortype")
	public Set<BtMonitorparatype> getBtMonitorparatypes() {
		return this.btMonitorparatypes;
	}

	public void setBtMonitorparatypes(Set<BtMonitorparatype> btMonitorparatypes) {
		this.btMonitorparatypes = btMonitorparatypes;
	}

}