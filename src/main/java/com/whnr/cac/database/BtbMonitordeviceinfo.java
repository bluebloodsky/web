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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BtbMonitordeviceinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_monitordeviceinfo", catalog = "intecomp_display")
public class BtbMonitordeviceinfo implements java.io.Serializable {

	// Fields

	private Long monitorDeviceInfoId;
	private BtbSubdevice btbSubdevice;
	private BtMonitortype btMonitortype;
	private BtMonitordevphase btMonitordevphase;
	private String remark;
	private Set<DtsMonitorstate> dtsMonitorstates = new HashSet<DtsMonitorstate>(
			0);
	private Set<BtbMonitordevicediagnose> btbMonitordevicediagnoses = new HashSet<BtbMonitordevicediagnose>(
			0);
	private Set<DtsDatainfo> dtsDatainfos = new HashSet<DtsDatainfo>(0);

	// Constructors

	/** default constructor */
	public BtbMonitordeviceinfo() {
	}

	/** minimal constructor */
	public BtbMonitordeviceinfo(BtbSubdevice btbSubdevice,
			BtMonitortype btMonitortype, BtMonitordevphase btMonitordevphase) {
		this.btbSubdevice = btbSubdevice;
		this.btMonitortype = btMonitortype;
		this.btMonitordevphase = btMonitordevphase;
	}

	/** full constructor */
	public BtbMonitordeviceinfo(BtbSubdevice btbSubdevice,
			BtMonitortype btMonitortype, BtMonitordevphase btMonitordevphase,
			String remark, Set<DtsMonitorstate> dtsMonitorstates,
			Set<BtbMonitordevicediagnose> btbMonitordevicediagnoses,
			Set<DtsDatainfo> dtsDatainfos) {
		this.btbSubdevice = btbSubdevice;
		this.btMonitortype = btMonitortype;
		this.btMonitordevphase = btMonitordevphase;
		this.remark = remark;
		this.dtsMonitorstates = dtsMonitorstates;
		this.btbMonitordevicediagnoses = btbMonitordevicediagnoses;
		this.dtsDatainfos = dtsDatainfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MonitorDeviceInfoID", unique = true, nullable = false)
	public Long getMonitorDeviceInfoId() {
		return this.monitorDeviceInfoId;
	}

	public void setMonitorDeviceInfoId(Long monitorDeviceInfoId) {
		this.monitorDeviceInfoId = monitorDeviceInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubDeviceID", nullable = false)
	public BtbSubdevice getBtbSubdevice() {
		return this.btbSubdevice;
	}

	public void setBtbSubdevice(BtbSubdevice btbSubdevice) {
		this.btbSubdevice = btbSubdevice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MonitorTypeID", nullable = false)
	public BtMonitortype getBtMonitortype() {
		return this.btMonitortype;
	}

	public void setBtMonitortype(BtMonitortype btMonitortype) {
		this.btMonitortype = btMonitortype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MonitorDevPhaseID", nullable = false)
	public BtMonitordevphase getBtMonitordevphase() {
		return this.btMonitordevphase;
	}

	public void setBtMonitordevphase(BtMonitordevphase btMonitordevphase) {
		this.btMonitordevphase = btMonitordevphase;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbMonitordeviceinfo")
	public Set<DtsMonitorstate> getDtsMonitorstates() {
		return this.dtsMonitorstates;
	}

	public void setDtsMonitorstates(Set<DtsMonitorstate> dtsMonitorstates) {
		this.dtsMonitorstates = dtsMonitorstates;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbMonitordeviceinfo")
	public Set<BtbMonitordevicediagnose> getBtbMonitordevicediagnoses() {
		return this.btbMonitordevicediagnoses;
	}

	public void setBtbMonitordevicediagnoses(
			Set<BtbMonitordevicediagnose> btbMonitordevicediagnoses) {
		this.btbMonitordevicediagnoses = btbMonitordevicediagnoses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbMonitordeviceinfo")
	public Set<DtsDatainfo> getDtsDatainfos() {
		return this.dtsDatainfos;
	}

	public void setDtsDatainfos(Set<DtsDatainfo> dtsDatainfos) {
		this.dtsDatainfos = dtsDatainfos;
	}

}