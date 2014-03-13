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
 * BtbMonitordevicediaparatype entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.whnr.cac.database.BtbMonitordevicediaparatype
 * @author MyEclipse Persistence Tools
 */
public class BtbMonitordevicediaparatypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbMonitordevicediaparatypeDAO.class);
	// property constants
	public static final String MONITOR_DEVICE_DIA_PARA_NAME = "monitorDeviceDiaParaName";
	public static final String MONITOR_DEVICE_DIA_PARA_TYPE_DESC = "monitorDeviceDiaParaTypeDesc";

	public void save(BtbMonitordevicediaparatype transientInstance) {
		log.debug("saving BtbMonitordevicediaparatype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbMonitordevicediaparatype persistentInstance) {
		log.debug("deleting BtbMonitordevicediaparatype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediaparatype findById(java.lang.String id) {
		log.debug("getting BtbMonitordevicediaparatype instance with id: " + id);
		try {
			BtbMonitordevicediaparatype instance = (BtbMonitordevicediaparatype) getSession()
					.get("com.whnr.cac.database.BtbMonitordevicediaparatype",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediaparatype> findByExample(
			BtbMonitordevicediaparatype instance) {
		log.debug("finding BtbMonitordevicediaparatype instance by example");
		try {
			List<BtbMonitordevicediaparatype> results = (List<BtbMonitordevicediaparatype>) getSession()
					.createCriteria(
							"com.whnr.cac.database.BtbMonitordevicediaparatype")
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
		log.debug("finding BtbMonitordevicediaparatype instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbMonitordevicediaparatype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbMonitordevicediaparatype> findByMonitorDeviceDiaParaName(
			Object monitorDeviceDiaParaName) {
		return findByProperty(MONITOR_DEVICE_DIA_PARA_NAME,
				monitorDeviceDiaParaName);
	}

	public List<BtbMonitordevicediaparatype> findByMonitorDeviceDiaParaTypeDesc(
			Object monitorDeviceDiaParaTypeDesc) {
		return findByProperty(MONITOR_DEVICE_DIA_PARA_TYPE_DESC,
				monitorDeviceDiaParaTypeDesc);
	}

	public List findAll() {
		log.debug("finding all BtbMonitordevicediaparatype instances");
		try {
			String queryString = "from BtbMonitordevicediaparatype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbMonitordevicediaparatype merge(
			BtbMonitordevicediaparatype detachedInstance) {
		log.debug("merging BtbMonitordevicediaparatype instance");
		try {
			BtbMonitordevicediaparatype result = (BtbMonitordevicediaparatype) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbMonitordevicediaparatype instance) {
		log.debug("attaching dirty BtbMonitordevicediaparatype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbMonitordevicediaparatype instance) {
		log.debug("attaching clean BtbMonitordevicediaparatype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}