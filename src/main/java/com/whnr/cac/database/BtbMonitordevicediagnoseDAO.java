package com.whnr.cac.database;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BtbMonitordevicediagnose entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.whnr.cac.database.BtbMonitordevicediagnose
 * @author MyEclipse Persistence Tools
 */
public class BtbMonitordevicediagnoseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbMonitordevicediagnoseDAO.class);
	// property constants
	public static final String MONITOR_DEVICE_DIA_RESULT = "monitorDeviceDiaResult";

	public void save(BtbMonitordevicediagnose transientInstance) {
		log.debug("saving BtbMonitordevicediagnose instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbMonitordevicediagnose persistentInstance) {
		log.debug("deleting BtbMonitordevicediagnose instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediagnose findById(java.lang.Long id) {
		log.debug("getting BtbMonitordevicediagnose instance with id: " + id);
		try {
			BtbMonitordevicediagnose instance = (BtbMonitordevicediagnose) getSession()
					.get("com.whnr.cac.database.BtbMonitordevicediagnose", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediagnose> findByExample(
			BtbMonitordevicediagnose instance) {
		log.debug("finding BtbMonitordevicediagnose instance by example");
		try {
			List<BtbMonitordevicediagnose> results = (List<BtbMonitordevicediagnose>) getSession()
					.createCriteria(
							"com.whnr.cac.database.BtbMonitordevicediagnose")
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
		log.debug("finding BtbMonitordevicediagnose instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbMonitordevicediagnose as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediagnose> findByMonitorDeviceDiaResult(
			Object monitorDeviceDiaResult) {
		return findByProperty(MONITOR_DEVICE_DIA_RESULT, monitorDeviceDiaResult);
	}

	public List findAll() {
		log.debug("finding all BtbMonitordevicediagnose instances");
		try {
			String queryString = "from BtbMonitordevicediagnose";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediagnose merge(
			BtbMonitordevicediagnose detachedInstance) {
		log.debug("merging BtbMonitordevicediagnose instance");
		try {
			BtbMonitordevicediagnose result = (BtbMonitordevicediagnose) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbMonitordevicediagnose instance) {
		log.debug("attaching dirty BtbMonitordevicediagnose instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbMonitordevicediagnose instance) {
		log.debug("attaching clean BtbMonitordevicediagnose instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}