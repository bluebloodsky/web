package com.whnr.cac.database;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BtbRepairadvice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_repairadvice", catalog = "intecomp_display")
public class BtbRepairadvice implements java.io.Serializable {

	// Fields

	private Long repairAdviceId;
	private BtbSubstationdevice btbSubstationdevice;
	private BtbRepairratetype btbRepairratetype;
	private Date adviceDate;
	private String repairTime;
	private Set<BtbRepaircontent> btbRepaircontents = new HashSet<BtbRepaircontent>(
			0);

	// Constructors

	/** default constructor */
	public BtbRepairadvice() {
	}

	/** minimal constructor */
	public BtbRepairadvice(Long repairAdviceId,
			BtbSubstationdevice btbSubstationdevice,
			BtbRepairratetype btbRepairratetype) {
		this.repairAdviceId = repairAdviceId;
		this.btbSubstationdevice = btbSubstationdevice;
		this.btbRepairratetype = btbRepairratetype;
	}

	/** full constructor */
	public BtbRepairadvice(Long repairAdviceId,
			BtbSubstationdevice btbSubstationdevice,
			BtbRepairratetype btbRepairratetype, Date adviceDate,
			String repairTime, Set<BtbRepaircontent> btbRepaircontents) {
		this.repairAdviceId = repairAdviceId;
		this.btbSubstationdevice = btbSubstationdevice;
		this.btbRepairratetype = btbRepairratetype;
		this.adviceDate = adviceDate;
		this.repairTime = repairTime;
		this.btbRepaircontents = btbRepaircontents;
	}

	// Property accessors
	@Id
	@Column(name = "RepairAdviceID", unique = true, nullable = false)
	public Long getRepairAdviceId() {
		return this.repairAdviceId;
	}

	public void setRepairAdviceId(Long repairAdviceId) {
		this.repairAdviceId = repairAdviceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubstationDeviceID", nullable = false)
	public BtbSubstationdevice getBtbSubstationdevice() {
		return this.btbSubstationdevice;
	}

	public void setBtbSubstationdevice(BtbSubstationdevice btbSubstationdevice) {
		this.btbSubstationdevice = btbSubstationdevice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RepairRateTypeID", nullable = false)
	public BtbRepairratetype getBtbRepairratetype() {
		return this.btbRepairratetype;
	}

	public void setBtbRepairratetype(BtbRepairratetype btbRepairratetype) {
		this.btbRepairratetype = btbRepairratetype;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AdviceDate", length = 10)
	public Date getAdviceDate() {
		return this.adviceDate;
	}

	public void setAdviceDate(Date adviceDate) {
		this.adviceDate = adviceDate;
	}

	@Column(name = "RepairTime", length = 20)
	public String getRepairTime() {
		return this.repairTime;
	}

	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbRepairadvice")
	public Set<BtbRepaircontent> getBtbRepaircontents() {
		return this.btbRepaircontents;
	}

	public void setBtbRepaircontents(Set<BtbRepaircontent> btbRepaircontents) {
		this.btbRepaircontents = btbRepaircontents;
	}

}