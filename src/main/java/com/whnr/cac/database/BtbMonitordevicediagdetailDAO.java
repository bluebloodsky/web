package com.whnr.cac.database;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BtbMonitordevicediagdetail entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.whnr.cac.database.BtbMonitordevicediagdetail
 * @author MyEclipse Persistence Tools
 */
public class BtbMonitordevicediagdetailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbMonitordevicediagdetailDAO.class);
	// property constants
	public static final String MONITOR_DEVICE_DIAG_RESULT = "monitorDeviceDiagResult";

	public void save(BtbMonitordevicediagdetail transientInstance) {
		log.debug("saving BtbMonitordevicediagdetail instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbMonitordevicediagdetail persistentInstance) {
		log.debug("deleting BtbMonitordevicediagdetail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediagdetail findById(java.lang.String id) {
		log.debug("getting BtbMonitordevicediagdetail instance with id: " + id);
		try {
			BtbMonitordevicediagdetail instance = (BtbMonitordevicediagdetail) getSession()
					.get("com.whnr.cac.database.BtbMonitordevicediagdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediagdetail> findByExample(
			BtbMonitordevicediagdetail instance) {
		log.debug("finding BtbMonitordevicediagdetail instance by example");
		try {
			List<BtbMonitordevicediagdetail> results = (List<BtbMonitordevicediagdetail>) getSession()
					.createCriteria(
							"com.whnr.cac.database.BtbMonitordevicediagdetail")
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
		log.debug("finding BtbMonitordevicediagdetail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbMonitordevicediagdetail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediagdetail> findByMonitorDeviceDiagResult(
			Object monitorDeviceDiagResult) {
		return findByProperty(MONITOR_DEVICE_DIAG_RESULT,
				monitorDeviceDiagResult);
	}

	public List findAll() {
		log.debug("finding all BtbMonitordevicediagdetail instances");
		try {
			String queryString = "from BtbMonitordevicediagdetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediagdetail merge(
			BtbMonitordevicediagdetail detachedInstance) {
		log.debug("merging BtbMonitordevicediagdetail instance");
		try {
			BtbMonitordevicediagdetail result = (BtbMonitordevicediagdetail) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbMonitordevicediagdetail instance) {
		log.debug("attaching dirty BtbMonitordevicediagdetail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbMonitordevicediagdetail instance) {
		log.debug("attaching clean BtbMonitordevicediagdetail instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}