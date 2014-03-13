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
 * BtMonitorparatype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bt_monitorparatype", catalog = "intecomp_display")
public class BtMonitorparatype implements java.io.Serializable {

	// Fields

	private Long monitorParaTypeId;
	private BtMonitortype btMonitortype;
	private String monitorParaName;
	private String monitorParaUnit;
	private String remark;
	private Set<DtsDatainfo> dtsDatainfos = new HashSet<DtsDatainfo>(0);
	private Set<DtsMonitorstate> dtsMonitorstates = new HashSet<DtsMonitorstate>(
			0);

	// Constructors

	/** default constructor */
	public BtMonitorparatype() {
	}

	/** minimal constructor */
	public BtMonitorparatype(BtMonitortype btMonitortype) {
		this.btMonitortype = btMonitortype;
	}

	/** full constructor */
	public BtMonitorparatype(BtMonitortype btMonitortype,
			String monitorParaName, String monitorParaUnit, String remark,
			Set<DtsDatainfo> dtsDatainfos, Set<DtsMonitorstate> dtsMonitorstates) {
		this.btMonitortype = btMonitortype;
		this.monitorParaName = monitorParaName;
		this.monitorParaUnit = monitorParaUnit;
		this.remark = remark;
		this.dtsDatainfos = dtsDatainfos;
		this.dtsMonitorstates = dtsMonitorstates;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MonitorParaTypeID", unique = true, nullable = false)
	public Long getMonitorParaTypeId() {
		return this.monitorParaTypeId;
	}

	public void setMonitorParaTypeId(Long monitorParaTypeId) {
		this.monitorParaTypeId = monitorParaTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MonitorTypeID", nullable = false)
	public BtMonitortype getBtMonitortype() {
		return this.btMonitortype;
	}

	public void setBtMonitortype(BtMonitortype btMonitortype) {
		this.btMonitortype = btMonitortype;
	}

	@Column(name = "MonitorParaName", length = 100)
	public String getMonitorParaName() {
		return this.monitorParaName;
	}

	public void setMonitorParaName(String monitorParaName) {
		this.monitorParaName = monitorParaName;
	}

	@Column(name = "MonitorParaUnit", length = 10)
	public String getMonitorParaUnit() {
		return this.monitorParaUnit;
	}

	public void setMonitorParaUnit(String monitorParaUnit) {
		this.monitorParaUnit = monitorParaUnit;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btMonitorparatype")
	public Set<DtsDatainfo> getDtsDatainfos() {
		return this.dtsDatainfos;
	}

	public void setDtsDatainfos(Set<DtsDatainfo> dtsDatainfos) {
		this.dtsDatainfos = dtsDatainfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btMonitorparatype")
	public Set<DtsMonitorstate> getDtsMonitorstates() {
		return this.dtsMonitorstates;
	}

	public void setDtsMonitorstates(Set<DtsMonitorstate> dtsMonitorstates) {
		this.dtsMonitorstates = dtsMonitorstates;
	}

}