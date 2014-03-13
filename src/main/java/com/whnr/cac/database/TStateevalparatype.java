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
 * TStateevalparatype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_stateevalparatype", catalog = "intecomp_display")
public class TStateevalparatype implements java.io.Serializable {

	// Fields

	private Long stateEvalParaTypeId;
	private String stateEvalParaTypeName;
	private String stateEvalParaTypeDesc;
	private String remark;
	private Set<BtbStateevelparainfo> btbStateevelparainfos = new HashSet<BtbStateevelparainfo>(
			0);

	// Constructors

	/** default constructor */
	public TStateevalparatype() {
	}

	/** minimal constructor */
	public TStateevalparatype(Long stateEvalParaTypeId) {
		this.stateEvalParaTypeId = stateEvalParaTypeId;
	}

	/** full constructor */
	public TStateevalparatype(Long stateEvalParaTypeId,
			String stateEvalParaTypeName, String stateEvalParaTypeDesc,
			String remark, Set<BtbStateevelparainfo> btbStateevelparainfos) {
		this.stateEvalParaTypeId = stateEvalParaTypeId;
		this.stateEvalParaTypeName = stateEvalParaTypeName;
		this.stateEvalParaTypeDesc = stateEvalParaTypeDesc;
		this.remark = remark;
		this.btbStateevelparainfos = btbStateevelparainfos;
	}

	// Property accessors
	@Id
	@Column(name = "StateEvalParaTypeID", unique = true, nullable = false)
	public Long getStateEvalParaTypeId() {
		return this.stateEvalParaTypeId;
	}

	public void setStateEvalParaTypeId(Long stateEvalParaTypeId) {
		this.stateEvalParaTypeId = stateEvalParaTypeId;
	}

	@Column(name = "StateEvalParaTypeName", length = 50)
	public String getStateEvalParaTypeName() {
		return this.stateEvalParaTypeName;
	}

	public void setStateEvalParaTypeName(String stateEvalParaTypeName) {
		this.stateEvalParaTypeName = stateEvalParaTypeName;
	}

	@Column(name = "StateEvalParaTypeDesc", length = 10)
	public String getStateEvalParaTypeDesc() {
		return this.stateEvalParaTypeDesc;
	}

	public void setStateEvalParaTypeDesc(String stateEvalParaTypeDesc) {
		this.stateEvalParaTypeDesc = stateEvalParaTypeDesc;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStateevalparatype")
	public Set<BtbStateevelparainfo> getBtbStateevelparainfos() {
		return this.btbStateevelparainfos;
	}

	public void setBtbStateevelparainfos(
			Set<BtbStateevelparainfo> btbStateevelparainfos) {
		this.btbStateevelparainfos = btbStateevelparainfos;
	}

}