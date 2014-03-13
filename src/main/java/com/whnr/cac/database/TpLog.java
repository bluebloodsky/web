package com.whnr.cac.database;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TpLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tp_log", catalog = "intecomp_display")
public class TpLog implements java.io.Serializable {

	// Fields

	private Long logId;
	private TpUser tpUser;
	private String target;
	private String method;
	private String result;
	private String details;
	private Timestamp operaTime;

	// Constructors

	/** default constructor */
	public TpLog() {
	}

	/** minimal constructor */
	public TpLog(TpUser tpUser, String target, String method, String result,
			Timestamp operaTime) {
		this.tpUser = tpUser;
		this.target = target;
		this.method = method;
		this.result = result;
		this.operaTime = operaTime;
	}

	/** full constructor */
	public TpLog(TpUser tpUser, String target, String method, String result,
			String details, Timestamp operaTime) {
		this.tpUser = tpUser;
		this.target = target;
		this.method = method;
		this.result = result;
		this.details = details;
		this.operaTime = operaTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "LogID", unique = true, nullable = false)
	public Long getLogId() {
		return this.logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	public TpUser getTpUser() {
		return this.tpUser;
	}

	public void setTpUser(TpUser tpUser) {
		this.tpUser = tpUser;
	}

	@Column(name = "Target", nullable = false)
	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Column(name = "Method", nullable = false)
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(name = "Result", nullable = false)
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "Details")
	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Column(name = "OperaTime", nullable = false, length = 19)
	public Timestamp getOperaTime() {
		return this.operaTime;
	}

	public void setOperaTime(Timestamp operaTime) {
		this.operaTime = operaTime;
	}

}