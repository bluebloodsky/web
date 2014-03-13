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
 * BtbRepairratetype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_repairratetype", catalog = "intecomp_display")
public class BtbRepairratetype implements java.io.Serializable {

	// Fields

	private String repairRateTypeId;
	private String repairRateTypeName;
	private Set<BtbRepairadvice> btbRepairadvices = new HashSet<BtbRepairadvice>(
			0);

	// Constructors

	/** default constructor */
	public BtbRepairratetype() {
	}

	/** minimal constructor */
	public BtbRepairratetype(String repairRateTypeId) {
		this.repairRateTypeId = repairRateTypeId;
	}

	/** full constructor */
	public BtbRepairratetype(String repairRateTypeId,
			String repairRateTypeName, Set<BtbRepairadvice> btbRepairadvices) {
		this.repairRateTypeId = repairRateTypeId;
		this.repairRateTypeName = repairRateTypeName;
		this.btbRepairadvices = btbRepairadvices;
	}

	// Property accessors
	@Id
	@Column(name = "RepairRateTypeID", unique = true, nullable = false)
	public String getRepairRateTypeId() {
		return this.repairRateTypeId;
	}

	public void setRepairRateTypeId(String repairRateTypeId) {
		this.repairRateTypeId = repairRateTypeId;
	}

	@Column(name = "RepairRateTypeName", length = 1)
	public String getRepairRateTypeName() {
		return this.repairRateTypeName;
	}

	public void setRepairRateTypeName(String repairRateTypeName) {
		this.repairRateTypeName = repairRateTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbRepairratetype")
	public Set<BtbRepairadvice> getBtbRepairadvices() {
		return this.btbRepairadvices;
	}

	public void setBtbRepairadvices(Set<BtbRepairadvice> btbRepairadvices) {
		this.btbRepairadvices = btbRepairadvices;
	}

}