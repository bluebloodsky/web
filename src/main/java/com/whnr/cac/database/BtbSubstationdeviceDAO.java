package com.whnr.cac.database;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BtbSubstationdevice entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtbSubstationdevice
 * @author MyEclipse Persistence Tools
 */
public class BtbSubstationdeviceDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbSubstationdeviceDAO.class);
	// property constants
	public static final String DEVICE_NAME = "deviceName";
	public static final String DEVICE_CODE = "deviceCode";
	public static final String RUN_STATE = "runState";
	public static final String ASSET_UNIT = "assetUnit";
	public static final String GRID_LEVEL = "gridLevel";
	public static final String DEVICE_VOLUME = "deviceVolume";
	public static final String DESIGN_LIFE = "designLife";
	public static final String RUN_NUM = "runNum";
	public static final String ASSET_NUM = "assetNum";
	public static final String DEVICE_DESC = "deviceDesc";
	public static final String DEVICE_MODEL = "deviceModel";
	public static final String RUN_UNIT = "runUnit";
	public static final String MANU_COUNTRY = "manuCountry";
	public static final String FACTORY_NUM = "factoryNum";
	public static final String DAP_UNIT = "dapUnit";
	public static final String FACTORY_NAME = "factoryName";
	public static final String SPEC_CURRENT = "specCurrent";
	public static final String SPEC_RATE = "specRate";
	public static final String SPEC_VOL = "specVol";
	public static final String REMARK = "remark";

	public void save(BtbSubstationdevice transientInstance) {
		log.debug("saving BtbSubstationdevice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbSubstationdevice persistentInstance) {
		log.debug("deleting BtbSubstationdevice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbSubstationdevice findById(java.lang.Long id) {
		log.debug("getting BtbSubstationdevice instance with id: " + id);
		try {
			BtbSubstationdevice instance = (BtbSubstationdevice) getSession()
					.get("com.whnr.cac.database.BtbSubstationdevice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbSubstationdevice> findByExample(BtbSubstationdevice instance) {
		log.debug("finding BtbSubstationdevice instance by example");
		try {
			List<BtbSubstationdevice> results = (List<BtbSubstationdevice>) getSession()
					.createCriteria("com.whnr.cac.database.BtbSubstationdevice")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BtbSubstationdevice instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbSubstationdevice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbSubstationdevice> findByDeviceName(Object deviceName) {
		return findByProperty(DEVICE_NAME, deviceName);
	}

	public List<BtbSubstationdevice> findByDeviceCode(Object deviceCode) {
		return findByProperty(DEVICE_CODE, deviceCode);
	}

	public List<BtbSubstationdevice> findByRunState(Object runState) {
		return findByProperty(RUN_STATE, runState);
	}

	public List<BtbSubstationdevice> findByAssetUnit(Object assetUnit) {
		return findByProperty(ASSET_UNIT, assetUnit);
	}

	public List<BtbSubstationdevice> findByGridLevel(Object gridLevel) {
		return findByProperty(GRID_LEVEL, gridLevel);
	}

	public List<BtbSubstationdevice> findByDeviceVolume(Object deviceVolume) {
		return findByProperty(DEVICE_VOLUME, deviceVolume);
	}

	public List<BtbSubstationdevice> findByDesignLife(Object designLife) {
		return findByProperty(DESIGN_LIFE, designLife);
	}

	public List<BtbSubstationdevice> findByRunNum(Object runNum) {
		return findByProperty(RUN_NUM, runNum);
	}

	public List<BtbSubstationdevice> findByAssetNum(Object assetNum) {
		return findByProperty(ASSET_NUM, assetNum);
	}

	public List<BtbSubstationdevice> findByDeviceDesc(Object deviceDesc) {
		return findByProperty(DEVICE_DESC, deviceDesc);
	}

	public List<BtbSubstationdevice> findByDeviceModel(Object deviceModel) {
		return findByProperty(DEVICE_MODEL, deviceModel);
	}

	public List<BtbSubstationdevice> findByRunUnit(Object runUnit) {
		return findByProperty(RUN_UNIT, runUnit);
	}

	public List<BtbSubstationdevice> findByManuCountry(Object manuCountry) {
		return findByProperty(MANU_COUNTRY, manuCountry);
	}

	public List<BtbSubstationdevice> findByFactoryNum(Object factoryNum) {
		return findByProperty(FACTORY_NUM, factoryNum);
	}

	public List<BtbSubstationdevice> findByDapUnit(Object dapUnit) {
		return findByProperty(DAP_UNIT, dapUnit);
	}

	public List<BtbSubstationdevice> findByFactoryName(Object factoryName) {
		return findByProperty(FACTORY_NAME, factoryName);
	}

	public List<BtbSubstationdevice> findBySpecCurrent(Object specCurrent) {
		return findByProperty(SPEC_CURRENT, specCurrent);
	}

	public List<BtbSubstationdevice> findBySpecRate(Object specRate) {
		return findByProperty(SPEC_RATE, specRate);
	}

	public List<BtbSubstationdevice> findBySpecVol(Object specVol) {
		return findByProperty(SPEC_VOL, specVol);
	}

	public List<BtbSubstationdevice> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BtbSubstationdevice instances");
		try {
			String queryString = "from BtbSubstationdevice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbSubstationdevice merge(BtbSubstationdevice detachedInstance) {
		log.debug("merging BtbSubstationdevice instance");
		try {
			BtbSubstationdevice result = (BtbSubstationdevice) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbSubstationdevice instance) {
		log.debug("attaching dirty BtbSubstationdevice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbSubstationdevice instance) {
		log.debug("attaching clean BtbSubstationdevice instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}