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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BtbSubstation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_substation", catalog = "intecomp_display")
public class BtbSubstation implements java.io.Serializable {

	// Fields

	private Long substationId;
	private TVollevel TVollevel;
	private TbCominfo tbCominfo;
	private TCurrentquality TCurrentquality;
	private String stationName;
	private String substationCode;
	private Long comVolLevelId;
	private String stationQuality;
	private String stationAddress;
	private String runUnit;
	private String runTeam;
	private Date operaDate;
	private String remark;
	private Set<BtbSubstationdevice> btbSubstationdevices = new HashSet<BtbSubstationdevice>(
			0);

	// Constructors

	/** default constructor */
	public BtbSubstation() {
	}

	/** minimal constructor */
	public BtbSubstation(Long substationId, TVollevel TVollevel,
			TbCominfo tbCominfo, TCurrentquality TCurrentquality) {
		this.substationId = substationId;
		this.TVollevel = TVollevel;
		this.tbCominfo = tbCominfo;
		this.TCurrentquality = TCurrentquality;
	}

	/** full constructor */
	public BtbSubstation(Long substationId, TVollevel TVollevel,
			TbCominfo tbCominfo, TCurrentquality TCurrentquality,
			String stationName, String substationCode, Long comVolLevelId,
			String stationQuality, String stationAddress, String runUnit,
			String runTeam, Date operaDate, String remark,
			Set<BtbSubstationdevice> btbSubstationdevices) {
		this.substationId = substationId;
		this.TVollevel = TVollevel;
		this.tbCominfo = tbCominfo;
		this.TCurrentquality = TCurrentquality;
		this.stationName = stationName;
		this.substationCode = substationCode;
		this.comVolLevelId = comVolLevelId;
		this.stationQuality = stationQuality;
		this.stationAddress = stationAddress;
		this.runUnit = runUnit;
		this.runTeam = runTeam;
		this.operaDate = operaDate;
		this.remark = remark;
		this.btbSubstationdevices = btbSubstationdevices;
	}

	// Property accessors
	@Id
	@Column(name = "SubstationID", unique = true, nullable = false)
	public Long getSubstationId() {
		return this.substationId;
	}

	public void setSubstationId(Long substationId) {
		this.substationId = substationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VolLevelID", nullable = false)
	public TVollevel getTVollevel() {
		return this.TVollevel;
	}

	public void setTVollevel(TVollevel TVollevel) {
		this.TVollevel = TVollevel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ComInfoID", nullable = false)
	public TbCominfo getTbCominfo() {
		return this.tbCominfo;
	}

	public void setTbCominfo(TbCominfo tbCominfo) {
		this.tbCominfo = tbCominfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CurrentQualityID", nullable = false)
	public TCurrentquality getTCurrentquality() {
		return this.TCurrentquality;
	}

	public void setTCurrentquality(TCurrentquality TCurrentquality) {
		this.TCurrentquality = TCurrentquality;
	}

	@Column(name = "StationName", length = 50)
	public String getStationName() {
		return this.stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Column(name = "SubstationCode", length = 20)
	public String getSubstationCode() {
		return this.substationCode;
	}

	public void setSubstationCode(String substationCode) {
		this.substationCode = substationCode;
	}

	@Column(name = "Com_VolLevelID")
	public Long getComVolLevelId() {
		return this.comVolLevelId;
	}

	public void setComVolLevelId(Long comVolLevelId) {
		this.comVolLevelId = comVolLevelId;
	}

	@Column(name = "StationQuality", length = 30)
	public String getStationQuality() {
		return this.stationQuality;
	}

	public void setStationQuality(String stationQuality) {
		this.stationQuality = stationQuality;
	}

	@Column(name = "StationAddress", length = 200)
	public String getStationAddress() {
		return this.stationAddress;
	}

	public void setStationAddress(String stationAddress) {
		this.stationAddress = stationAddress;
	}

	@Column(name = "RunUnit", length = 50)
	public String getRunUnit() {
		return this.runUnit;
	}

	public void setRunUnit(String runUnit) {
		this.runUnit = runUnit;
	}

	@Column(name = "RunTeam", length = 50)
	public String getRunTeam() {
		return this.runTeam;
	}

	public void setRunTeam(String runTeam) {
		this.runTeam = runTeam;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OperaDate", length = 10)
	public Date getOperaDate() {
		return this.operaDate;
	}

	public void setOperaDate(Date operaDate) {
		this.operaDate = operaDate;
	}

	@Column(name = "Remark", length = 225)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbSubstation")
	@OrderBy(value="substationDeviceId")
	public Set<BtbSubstationdevice> getBtbSubstationdevices() {
		return this.btbSubstationdevices;
	}

	public void setBtbSubstationdevices(
			Set<BtbSubstationdevice> btbSubstationdevices) {
		this.btbSubstationdevices = btbSubstationdevices;
	}

}