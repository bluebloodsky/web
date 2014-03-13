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
 * BtzStateeval entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btz_stateeval", catalog = "intecomp_display")
public class BtzStateeval implements java.io.Serializable {

	// Fields

	private Long stateEvalId;
	private TDevicestatus TDevicestatus;
	private BtbSubstationdevice btbSubstationdevice;
	private Double stateEvalScore;
	private Long evaluatorId;
	private Date evalTime;
	private String advice;
	private String remark;
	private Set<BtbStateevelparainfo> btbStateevelparainfos = new HashSet<BtbStateevelparainfo>(
			0);

	// Constructors

	/** default constructor */
	public BtzStateeval() {
	}

	/** minimal constructor */
	public BtzStateeval(Long stateEvalId, TDevicestatus TDevicestatus,
			BtbSubstationdevice btbSubstationdevice) {
		this.stateEvalId = stateEvalId;
		this.TDevicestatus = TDevicestatus;
		this.btbSubstationdevice = btbSubstationdevice;
	}

	/** full constructor */
	public BtzStateeval(Long stateEvalId, TDevicestatus TDevicestatus,
			BtbSubstationdevice btbSubstationdevice, Double stateEvalScore,
			Long evaluatorId, Date evalTime, String advice, String remark,
			Set<BtbStateevelparainfo> btbStateevelparainfos) {
		this.stateEvalId = stateEvalId;
		this.TDevicestatus = TDevicestatus;
		this.btbSubstationdevice = btbSubstationdevice;
		this.stateEvalScore = stateEvalScore;
		this.evaluatorId = evaluatorId;
		this.evalTime = evalTime;
		this.advice = advice;
		this.remark = remark;
		this.btbStateevelparainfos = btbStateevelparainfos;
	}

	// Property accessors
	@Id
	@Column(name = "StateEvalID", unique = true, nullable = false)
	public Long getStateEvalId() {
		return this.stateEvalId;
	}

	public void setStateEvalId(Long stateEvalId) {
		this.stateEvalId = stateEvalId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DeviceStatusID", nullable = false)
	public TDevicestatus getTDevicestatus() {
		return this.TDevicestatus;
	}

	public void setTDevicestatus(TDevicestatus TDevicestatus) {
		this.TDevicestatus = TDevicestatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubstationDeviceID", nullable = false)
	public BtbSubstationdevice getBtbSubstationdevice() {
		return this.btbSubstationdevice;
	}

	public void setBtbSubstationdevice(BtbSubstationdevice btbSubstationdevice) {
		this.btbSubstationdevice = btbSubstationdevice;
	}

	@Column(name = "StateEvalScore", precision = 18, scale = 3)
	public Double getStateEvalScore() {
		return this.stateEvalScore;
	}

	public void setStateEvalScore(Double stateEvalScore) {
		this.stateEvalScore = stateEvalScore;
	}

	@Column(name = "EvaluatorID")
	public Long getEvaluatorId() {
		return this.evaluatorId;
	}

	public void setEvaluatorId(Long evaluatorId) {
		this.evaluatorId = evaluatorId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EvalTime", length = 10)
	public Date getEvalTime() {
		return this.evalTime;
	}

	public void setEvalTime(Date evalTime) {
		this.evalTime = evalTime;
	}

	@Column(name = "Advice")
	public String getAdvice() {
		return this.advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btzStateeval")
	public Set<BtbStateevelparainfo> getBtbStateevelparainfos() {
		return this.btbStateevelparainfos;
	}

	public void setBtbStateevelparainfos(
			Set<BtbStateevelparainfo> btbStateevelparainfos) {
		this.btbStateevelparainfos = btbStateevelparainfos;
	}

}