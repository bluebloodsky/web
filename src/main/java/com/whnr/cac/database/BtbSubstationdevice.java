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
 * BtbSubstationdevice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "btb_substationdevice", catalog = "intecomp_display")
public class BtbSubstationdevice implements java.io.Serializable {

	// Fields

	private Long substationDeviceId;
	private TDevicetype TDevicetype;
	private BtbSubstation btbSubstation;
	private String deviceName;
	private String deviceCode;
	private String runState;
	private String assetUnit;
	private String gridLevel;
	private Double deviceVolume;
	private Double designLife;
	private Date operaDate;
	private Date returnDate;
	private String runNum;
	private Double assetNum;
	private String deviceDesc;
	private String deviceModel;
	private String runUnit;
	private String manuCountry;
	private String factoryNum;
	private Date factoryDate;
	private String dapUnit;
	private String factoryName;
	private Double specCurrent;
	private Double specRate;
	private Double specVol;
	private String remark;
	private Set<BtbRepairadvice> btbRepairadvices = new HashSet<BtbRepairadvice>(
			0);
	private Set<BtbFaultinfo> btbFaultinfos = new HashSet<BtbFaultinfo>(0);
	private Set<BtzStateeval> btzStateevals = new HashSet<BtzStateeval>(0);
	private Set<BtbSubdevice> btbSubdevices = new HashSet<BtbSubdevice>(0);

	// Constructors

	/** default constructor */
	public BtbSubstationdevice() {
	}

	/** minimal constructor */
	public BtbSubstationdevice(Long substationDeviceId,
			TDevicetype TDevicetype, BtbSubstation btbSubstation) {
		this.substationDeviceId = substationDeviceId;
		this.TDevicetype = TDevicetype;
		this.btbSubstation = btbSubstation;
	}

	/** full constructor */
	public BtbSubstationdevice(Long substationDeviceId,
			TDevicetype TDevicetype, BtbSubstation btbSubstation,
			String deviceName, String deviceCode, String runState,
			String assetUnit, String gridLevel, Double deviceVolume,
			Double designLife, Date operaDate, Date returnDate, String runNum,
			Double assetNum, String deviceDesc, String deviceModel,
			String runUnit, String manuCountry, String factoryNum,
			Date factoryDate, String dapUnit, String factoryName,
			Double specCurrent, Double specRate, Double specVol, String remark,
			Set<BtbRepairadvice> btbRepairadvices,
			Set<BtbFaultinfo> btbFaultinfos, Set<BtzStateeval> btzStateevals,
			Set<BtbSubdevice> btbSubdevices) {
		this.substationDeviceId = substationDeviceId;
		this.TDevicetype = TDevicetype;
		this.btbSubstation = btbSubstation;
		this.deviceName = deviceName;
		this.deviceCode = deviceCode;
		this.runState = runState;
		this.assetUnit = assetUnit;
		this.gridLevel = gridLevel;
		this.deviceVolume = deviceVolume;
		this.designLife = designLife;
		this.operaDate = operaDate;
		this.returnDate = returnDate;
		this.runNum = runNum;
		this.assetNum = assetNum;
		this.deviceDesc = deviceDesc;
		this.deviceModel = deviceModel;
		this.runUnit = runUnit;
		this.manuCountry = manuCountry;
		this.factoryNum = factoryNum;
		this.factoryDate = factoryDate;
		this.dapUnit = dapUnit;
		this.factoryName = factoryName;
		this.specCurrent = specCurrent;
		this.specRate = specRate;
		this.specVol = specVol;
		this.remark = remark;
		this.btbRepairadvices = btbRepairadvices;
		this.btbFaultinfos = btbFaultinfos;
		this.btzStateevals = btzStateevals;
		this.btbSubdevices = btbSubdevices;
	}

	// Property accessors
	@Id
	@Column(name = "SubstationDeviceID", unique = true, nullable = false)
	public Long getSubstationDeviceId() {
		return this.substationDeviceId;
	}

	public void setSubstationDeviceId(Long substationDeviceId) {
		this.substationDeviceId = substationDeviceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DeviceTypeID", nullable = false)
	public TDevicetype getTDevicetype() {
		return this.TDevicetype;
	}

	public void setTDevicetype(TDevicetype TDevicetype) {
		this.TDevicetype = TDevicetype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubstationID", nullable = false)
	public BtbSubstation getBtbSubstation() {
		return this.btbSubstation;
	}

	public void setBtbSubstation(BtbSubstation btbSubstation) {
		this.btbSubstation = btbSubstation;
	}

	@Column(name = "DeviceName", length = 30)
	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Column(name = "DeviceCode", length = 50)
	public String getDeviceCode() {
		return this.deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	@Column(name = "RunState", length = 30)
	public String getRunState() {
		return this.runState;
	}

	public void setRunState(String runState) {
		this.runState = runState;
	}

	@Column(name = "AssetUnit", length = 100)
	public String getAssetUnit() {
		return this.assetUnit;
	}

	public void setAssetUnit(String assetUnit) {
		this.assetUnit = assetUnit;
	}

	@Column(name = "GridLevel", length = 30)
	public String getGridLevel() {
		return this.gridLevel;
	}

	public void setGridLevel(String gridLevel) {
		this.gridLevel = gridLevel;
	}

	@Column(name = "DeviceVolume", precision = 20, scale = 3)
	public Double getDeviceVolume() {
		return this.deviceVolume;
	}

	public void setDeviceVolume(Double deviceVolume) {
		this.deviceVolume = deviceVolume;
	}

	@Column(name = "DesignLife", precision = 10, scale = 3)
	public Double getDesignLife() {
		return this.designLife;
	}

	public void setDesignLife(Double designLife) {
		this.designLife = designLife;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OperaDate", length = 10)
	public Date getOperaDate() {
		return this.operaDate;
	}

	public void setOperaDate(Date operaDate) {
		this.operaDate = operaDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ReturnDate", length = 10)
	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Column(name = "RunNum", length = 50)
	public String getRunNum() {
		return this.runNum;
	}

	public void setRunNum(String runNum) {
		this.runNum = runNum;
	}

	@Column(name = "AssetNum", precision = 20, scale = 3)
	public Double getAssetNum() {
		return this.assetNum;
	}

	public void setAssetNum(Double assetNum) {
		this.assetNum = assetNum;
	}

	@Column(name = "DeviceDesc")
	public String getDeviceDesc() {
		return this.deviceDesc;
	}

	public void setDeviceDesc(String deviceDesc) {
		this.deviceDesc = deviceDesc;
	}

	@Column(name = "DeviceModel", length = 50)
	public String getDeviceModel() {
		return this.deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	@Column(name = "RunUnit", length = 100)
	public String getRunUnit() {
		return this.runUnit;
	}

	public void setRunUnit(String runUnit) {
		this.runUnit = runUnit;
	}

	@Column(name = "ManuCountry", length = 50)
	public String getManuCountry() {
		return this.manuCountry;
	}

	public void setManuCountry(String manuCountry) {
		this.manuCountry = manuCountry;
	}

	@Column(name = "FactoryNum", length = 20)
	public String getFactoryNum() {
		return this.factoryNum;
	}

	public void setFactoryNum(String factoryNum) {
		this.factoryNum = factoryNum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FactoryDate", length = 10)
	public Date getFactoryDate() {
		return this.factoryDate;
	}

	public void setFactoryDate(Date factoryDate) {
		this.factoryDate = factoryDate;
	}

	@Column(name = "DapUnit", length = 50)
	public String getDapUnit() {
		return this.dapUnit;
	}

	public void setDapUnit(String dapUnit) {
		this.dapUnit = dapUnit;
	}

	@Column(name = "FactoryName", length = 100)
	public String getFactoryName() {
		return this.factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	@Column(name = "SpecCurrent", precision = 20, scale = 3)
	public Double getSpecCurrent() {
		return this.specCurrent;
	}

	public void setSpecCurrent(Double specCurrent) {
		this.specCurrent = specCurrent;
	}

	@Column(name = "SpecRate", precision = 20, scale = 3)
	public Double getSpecRate() {
		return this.specRate;
	}

	public void setSpecRate(Double specRate) {
		this.specRate = specRate;
	}

	@Column(name = "SpecVol", precision = 20, scale = 3)
	public Double getSpecVol() {
		return this.specVol;
	}

	public void setSpecVol(Double specVol) {
		this.specVol = specVol;
	}

	@Column(name = "Remark", length = 225)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbSubstationdevice")
	public Set<BtbRepairadvice> getBtbRepairadvices() {
		return this.btbRepairadvices;
	}

	public void setBtbRepairadvices(Set<BtbRepairadvice> btbRepairadvices) {
		this.btbRepairadvices = btbRepairadvices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbSubstationdevice")
	public Set<BtbFaultinfo> getBtbFaultinfos() {
		return this.btbFaultinfos;
	}

	public void setBtbFaultinfos(Set<BtbFaultinfo> btbFaultinfos) {
		this.btbFaultinfos = btbFaultinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbSubstationdevice")
	public Set<BtzStateeval> getBtzStateevals() {
		return this.btzStateevals;
	}

	public void setBtzStateevals(Set<BtzStateeval> btzStateevals) {
		this.btzStateevals = btzStateevals;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "btbSubstationdevice")
	public Set<BtbSubdevice> getBtbSubdevices() {
		return this.btbSubdevices;
	}

	public void setBtbSubdevices(Set<BtbSubdevice> btbSubdevices) {
		this.btbSubdevices = btbSubdevices;
	}

}