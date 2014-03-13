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
 * TDevicestatus entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.TDevicestatus
 * @author MyEclipse Persistence Tools
 */
public class TDevicestatusDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TDevicestatusDAO.class);
	// property constants
	public static final String DEVICE_STATUS_NAME = "deviceStatusName";
	public static final String DEVICE_STATUS_DESC = "deviceStatusDesc";
	public static final String REMARK = "remark";

	public void save(TDevicestatus transientInstance) {
		log.debug("saving TDevicestatus instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDevicestatus persistentInstance) {
		log.debug("deleting TDevicestatus instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDevicestatus findById(java.lang.Long id) {
		log.debug("getting TDevicestatus instance with id: " + id);
		try {
			TDevicestatus instance = (TDevicestatus) getSession().get(
					"com.whnr.cac.database.TDevicestatus", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TDevicestatus> findByExample(TDevicestatus instance) {
		log.debug("finding TDevicestatus instance by example");
		try {
			List<TDevicestatus> results = (List<TDevicestatus>) getSession()
					.createCriteria("com.whnr.cac.database.TDevicestatus")
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
		log.debug("finding TDevicestatus instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TDevicestatus as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TDevicestatus> findByDeviceStatusName(Object deviceStatusName) {
		return findByProperty(DEVICE_STATUS_NAME, deviceStatusName);
	}

	public List<TDevicestatus> findByDeviceStatusDesc(Object deviceStatusDesc) {
		return findByProperty(DEVICE_STATUS_DESC, deviceStatusDesc);
	}

	public List<TDevicestatus> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all TDevicestatus instances");
		try {
			String queryString = "from TDevicestatus";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDevicestatus merge(TDevicestatus detachedInstance) {
		log.debug("merging TDevicestatus instance");
		try {
			TDevicestatus result = (TDevicestatus) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDevicestatus instance) {
		log.debug("attaching dirty TDevicestatus instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDevicestatus instance) {
		log.debug("attaching clean TDevicestatus instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}