package com.whnr.cac.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BtbRepaircontent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_repaircontent", catalog = "intecomp_display")
public class BtbRepaircontent implements java.io.Serializable {

	// Fields

	private Long repairContentId;
	private BtbRepairadvice btbRepairadvice;
	private Integer repairNum;
	private String repairContentDesc;
	private String repairReason;

	// Constructors

	/** default constructor */
	public BtbRepaircontent() {
	}

	/** minimal constructor */
	public BtbRepaircontent(Long repairContentId,
			BtbRepairadvice btbRepairadvice) {
		this.repairContentId = repairContentId;
		this.btbRepairadvice = btbRepairadvice;
	}

	/** full constructor */
	public BtbRepaircontent(Long repairContentId,
			BtbRepairadvice btbRepairadvice, Integer repairNum,
			String repairContentDesc, String repairReason) {
		this.repairContentId = repairContentId;
		this.btbRepairadvice = btbRepairadvice;
		this.repairNum = repairNum;
		this.repairContentDesc = repairContentDesc;
		this.repairReason = repairReason;
	}

	// Property accessors
	@Id
	@Column(name = "RepairContentID", unique = true, nullable = false)
	public Long getRepairContentId() {
		return this.repairContentId;
	}

	public void setRepairContentId(Long repairContentId) {
		this.repairContentId = repairContentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RepairAdviceID", nullable = false)
	public BtbRepairadvice getBtbRepairadvice() {
		return this.btbRepairadvice;
	}

	public void setBtbRepairadvice(BtbRepairadvice btbRepairadvice) {
		this.btbRepairadvice = btbRepairadvice;
	}

	@Column(name = "RepairNum")
	public Integer getRepairNum() {
		return this.repairNum;
	}

	public void setRepairNum(Integer repairNum) {
		this.repairNum = repairNum;
	}

	@Column(name = "RepairContentDesc", length = 100)
	public String getRepairContentDesc() {
		return this.repairContentDesc;
	}

	public void setRepairContentDesc(String repairContentDesc) {
		this.repairContentDesc = repairContentDesc;
	}

	@Column(name = "RepairReason", length = 100)
	public String getRepairReason() {
		return this.repairReason;
	}

	public void setRepairReason(String repairReason) {
		this.repairReason = repairReason;
	}

}