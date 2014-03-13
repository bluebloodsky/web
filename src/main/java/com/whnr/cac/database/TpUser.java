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
 * TpUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tp_user", catalog = "intecomp_display")
public class TpUser implements java.io.Serializable {

	// Fields

	private Long userId;
	private TpUserroletype tpUserroletype;
	private String loginName;
	private String realName;
	private String password;
	private String telephone;
	private String post;
	private String email;
	private String remark;
	private Set<TpLog> tpLogs = new HashSet<TpLog>(0);

	// Constructors

	/** default constructor */
	public TpUser() {
	}

	/** minimal constructor */
	public TpUser(TpUserroletype tpUserroletype, String loginName) {
		this.tpUserroletype = tpUserroletype;
		this.loginName = loginName;
	}

	/** full constructor */
	public TpUser(TpUserroletype tpUserroletype, String loginName,
			String realName, String password, String telephone, String post,
			String email, String remark, Set<TpLog> tpLogs) {
		this.tpUserroletype = tpUserroletype;
		this.loginName = loginName;
		this.realName = realName;
		this.password = password;
		this.telephone = telephone;
		this.post = post;
		this.email = email;
		this.remark = remark;
		this.tpLogs = tpLogs;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UserID", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserRoleTypeID", nullable = false)
	public TpUserroletype getTpUserroletype() {
		return this.tpUserroletype;
	}

	public void setTpUserroletype(TpUserroletype tpUserroletype) {
		this.tpUserroletype = tpUserroletype;
	}

	@Column(name = "LoginName", nullable = false, length = 50)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "RealName", length = 50)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "Password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Telephone", length = 100)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "Post", length = 50)
	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@Column(name = "Email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tpUser")
	public Set<TpLog> getTpLogs() {
		return this.tpLogs;
	}

	public void setTpLogs(Set<TpLog> tpLogs) {
		this.tpLogs = tpLogs;
	}

}