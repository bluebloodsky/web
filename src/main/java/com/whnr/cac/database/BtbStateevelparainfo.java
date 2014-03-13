package com.whnr.cac.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BtbStateevelparainfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_stateevelparainfo", catalog = "intecomp_display")
public class BtbStateevelparainfo implements java.io.Serializable {

	// Fields

	private Long stateEvelParaInfoId;
	private TStateevalparatype TStateevalparatype;
	private BtzStateeval btzStateeval;
	private String stateEvelParaResult;

	// Constructors

	/** default constructor */
	public BtbStateevelparainfo() {
	}

	/** minimal constructor */
	public BtbStateevelparainfo(Long stateEvelParaInfoId,
			TStateevalparatype TStateevalparatype, BtzStateeval btzStateeval) {
		this.stateEvelParaInfoId = stateEvelParaInfoId;
		this.TStateevalparatype = TStateevalparatype;
		this.btzStateeval = btzStateeval;
	}

	/** full constructor */
	public BtbStateevelparainfo(Long stateEvelParaInfoId,
			TStateevalparatype TStateevalparatype, BtzStateeval btzStateeval,
			String stateEvelParaResult) {
		this.stateEvelParaInfoId = stateEvelParaInfoId;
		this.TStateevalparatype = TStateevalparatype;
		this.btzStateeval = btzStateeval;
		this.stateEvelParaResult = stateEvelParaResult;
	}

	// Property accessors
	@Id
	@Column(name = "StateEvelParaInfoID", unique = true, nullable = false)
	public Long getStateEvelParaInfoId() {
		return this.stateEvelParaInfoId;
	}

	public void setStateEvelParaInfoId(Long stateEvelParaInfoId) {
		this.stateEvelParaInfoId = stateEvelParaInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StateEvalParaTypeID", nullable = false)
	public TStateevalparatype getTStateevalparatype() {
		return this.TStateevalparatype;
	}

	public void setTStateevalparatype(TStateevalparatype TStateevalparatype) {
		this.TStateevalparatype = TStateevalparatype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StateEvalID", nullable = false)
	public BtzStateeval getBtzStateeval() {
		return this.btzStateeval;
	}

	public void setBtzStateeval(BtzStateeval btzStateeval) {
		this.btzStateeval = btzStateeval;
	}

	@Column(name = "StateEvelParaResult", length = 20)
	public String getStateEvelParaResult() {
		return this.stateEvelParaResult;
	}

	public void setStateEvelParaResult(String stateEvelParaResult) {
		this.stateEvelParaResult = stateEvelParaResult;
	}

}