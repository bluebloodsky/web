package com.whnr.cac.database;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BtbMonitordevicediagmode entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.whnr.cac.database.BtbMonitordevicediagmode
 * @author MyEclipse Persistence Tools
 */
public class BtbMonitordevicediagmodeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbMonitordevicediagmodeDAO.class);
	// property constants
	public static final String MONITOR_DEVICE_DIAG_MODE_NAME = "monitorDeviceDiagModeName";
	public static final String MONITOR_DEVICE_DIAG_TYPE_DESC = "monitorDeviceDiagTypeDesc";

	public void save(BtbMonitordevicediagmode transientInstance) {
		log.debug("saving BtbMonitordevicediagmode instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbMonitordevicediagmode persistentInstance) {
		log.debug("deleting BtbMonitordevicediagmode instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediagmode findById(java.lang.Long id) {
		log.debug("getting BtbMonitordevicediagmode instance with id: " + id);
		try {
			BtbMonitordevicediagmode instance = (BtbMonitordevicediagmode) getSession()
					.get("com.whnr.cac.database.BtbMonitordevicediagmode", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediagmode> findByExample(
			BtbMonitordevicediagmode instance) {
		log.debug("finding BtbMonitordevicediagmode instance by example");
		try {
			List<BtbMonitordevicediagmode> results = (List<BtbMonitordevicediagmode>) getSession()
					.createCriteria(
							"com.whnr.cac.database.BtbMonitordevicediagmode")
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
		log.debug("finding BtbMonitordevicediagmode instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbMonitordevicediagmode as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediagmode> findByMonitorDeviceDiagModeName(
			Object monitorDeviceDiagModeName) {
		return findByProperty(MONITOR_DEVICE_DIAG_MODE_NAME,
				monitorDeviceDiagModeName);
	}

	public List<BtbMonitordevicediagmode> findByMonitorDeviceDiagTypeDesc(
			Object monitorDeviceDiagTypeDesc) {
		return findByProperty(MONITOR_DEVICE_DIAG_TYPE_DESC,
				monitorDeviceDiagTypeDesc);
	}

	public List findAll() {
		log.debug("finding all BtbMonitordevicediagmode instances");
		try {
			String queryString = "from BtbMonitordevicediagmode";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediagmode merge(
			BtbMonitordevicediagmode detachedInstance) {
		log.debug("merging BtbMonitordevicediagmode instance");
		try {
			BtbMonitordevicediagmode result = (BtbMonitordevicediagmode) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbMonitordevicediagmode instance) {
		log.debug("attaching dirty BtbMonitordevicediagmode instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbMonitordevicediagmode instance) {
		log.debug("attaching clean BtbMonitordevicediagmode instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}