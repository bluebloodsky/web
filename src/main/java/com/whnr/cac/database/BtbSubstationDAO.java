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
 * BtbSubstation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtbSubstation
 * @author MyEclipse Persistence Tools
 */
public class BtbSubstationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbSubstationDAO.class);
	// property constants
	public static final String STATION_NAME = "stationName";
	public static final String SUBSTATION_CODE = "substationCode";
	public static final String COM_VOL_LEVEL_ID = "comVolLevelId";
	public static final String STATION_QUALITY = "stationQuality";
	public static final String STATION_ADDRESS = "stationAddress";
	public static final String RUN_UNIT = "runUnit";
	public static final String RUN_TEAM = "runTeam";
	public static final String REMARK = "remark";

	public void save(BtbSubstation transientInstance) {
		log.debug("saving BtbSubstation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbSubstation persistentInstance) {
		log.debug("deleting BtbSubstation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbSubstation findById(java.lang.Long id) {
		log.debug("getting BtbSubstation instance with id: " + id);
		try {
			BtbSubstation instance = (BtbSubstation) getSession().get(
					"com.whnr.cac.database.BtbSubstation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbSubstation> findByExample(BtbSubstation instance) {
		log.debug("finding BtbSubstation instance by example");
		try {
			List<BtbSubstation> results = (List<BtbSubstation>) getSession()
					.createCriteria("com.whnr.cac.database.BtbSubstation")
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
		log.debug("finding BtbSubstation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbSubstation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbSubstation> findByStationName(Object stationName) {
		return findByProperty(STATION_NAME, stationName);
	}

	public List<BtbSubstation> findBySubstationCode(Object substationCode) {
		return findByProperty(SUBSTATION_CODE, substationCode);
	}

	public List<BtbSubstation> findByComVolLevelId(Object comVolLevelId) {
		return findByProperty(COM_VOL_LEVEL_ID, comVolLevelId);
	}

	public List<BtbSubstation> findByStationQuality(Object stationQuality) {
		return findByProperty(STATION_QUALITY, stationQuality);
	}

	public List<BtbSubstation> findByStationAddress(Object stationAddress) {
		return findByProperty(STATION_ADDRESS, stationAddress);
	}

	public List<BtbSubstation> findByRunUnit(Object runUnit) {
		return findByProperty(RUN_UNIT, runUnit);
	}

	public List<BtbSubstation> findByRunTeam(Object runTeam) {
		return findByProperty(RUN_TEAM, runTeam);
	}

	public List<BtbSubstation> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BtbSubstation instances");
		try {
			String queryString = "from BtbSubstation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbSubstation merge(BtbSubstation detachedInstance) {
		log.debug("merging BtbSubstation instance");
		try {
			BtbSubstation result = (BtbSubstation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbSubstation instance) {
		log.debug("attaching dirty BtbSubstation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbSubstation instance) {
		log.debug("attaching clean BtbSubstation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}