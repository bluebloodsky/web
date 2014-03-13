package com.whnr.cac.database;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BtbMonitordevicediapara entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtbMonitordevicediapara
 * @author MyEclipse Persistence Tools
 */
public class BtbMonitordevicediaparaDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbMonitordevicediaparaDAO.class);
	// property constants
	public static final String MONITOR_DEVICE_DIA_PARA_VALUE = "monitorDeviceDiaParaValue";
	public static final String MONITOR_DEVICE_DIA_PARA_STATUS = "monitorDeviceDiaParaStatus";

	public void save(BtbMonitordevicediapara transientInstance) {
		log.debug("saving BtbMonitordevicediapara instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbMonitordevicediapara persistentInstance) {
		log.debug("deleting BtbMonitordevicediapara instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediapara findById(java.lang.Long id) {
		log.debug("getting BtbMonitordevicediapara instance with id: " + id);
		try {
			BtbMonitordevicediapara instance = (BtbMonitordevicediapara) getSession()
					.get("com.whnr.cac.database.BtbMonitordevicediapara", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediapara> findByExample(
			BtbMonitordevicediapara instance) {
		log.debug("finding BtbMonitordevicediapara instance by example");
		try {
			List<BtbMonitordevicediapara> results = (List<BtbMonitordevicediapara>) getSession()
					.createCriteria(
							"com.whnr.cac.database.BtbMonitordevicediapara")
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
		log.debug("finding BtbMonitordevicediapara instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbMonitordevicediapara as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediapara> findByMonitorDeviceDiaParaValue(
			Object monitorDeviceDiaParaValue) {
		return findByProperty(MONITOR_DEVICE_DIA_PARA_VALUE,
				monitorDeviceDiaParaValue);
	}

	public List<BtbMonitordevicediapara> findByMonitorDeviceDiaParaStatus(
			Object monitorDeviceDiaParaStatus) {
		return findByProperty(MONITOR_DEVICE_DIA_PARA_STATUS,
				monitorDeviceDiaParaStatus);
	}

	public List findAll() {
		log.debug("finding all BtbMonitordevicediapara instances");
		try {
			String queryString = "from BtbMonitordevicediapara";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediapara merge(
			BtbMonitordevicediapara detachedInstance) {
		log.debug("merging BtbMonitordevicediapara instance");
		try {
			BtbMonitordevicediapara result = (BtbMonitordevicediapara) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbMonitordevicediapara instance) {
		log.debug("attaching dirty BtbMonitordevicediapara instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbMonitordevicediapara instance) {
		log.debug("attaching clean BtbMonitordevicediapara instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}