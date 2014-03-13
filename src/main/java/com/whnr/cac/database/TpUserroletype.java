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
 * TpUserroletype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tp_userroletype", catalog = "intecomp_display")
public class TpUserroletype implements java.io.Serializable {

	// Fields

	private Long userRoleTypeId;
	private String userRoleName;
	private String remark;
	private Set<TpUser> tpUsers = new HashSet<TpUser>(0);

	// Constructors

	/** default constructor */
	public TpUserroletype() {
	}

	/** full constructor */
	public TpUserroletype(String userRoleName, String remark,
			Set<TpUser> tpUsers) {
		this.userRoleName = userRoleName;
		this.remark = remark;
		this.tpUsers = tpUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UserRoleTypeID", unique = true, nullable = false)
	public Long getUserRoleTypeId() {
		return this.userRoleTypeId;
	}

	public void setUserRoleTypeId(Long userRoleTypeId) {
		this.userRoleTypeId = userRoleTypeId;
	}

	@Column(name = "UserRoleName", length = 10)
	public String getUserRoleName() {
		return this.userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tpUserroletype")
	public Set<TpUser> getTpUsers() {
		return this.tpUsers;
	}

	public void setTpUsers(Set<TpUser> tpUsers) {
		this.tpUsers = tpUsers;
	}

}