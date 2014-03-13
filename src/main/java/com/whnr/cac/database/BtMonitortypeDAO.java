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
 * BtMonitortype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtMonitortype
 * @author MyEclipse Persistence Tools
 */
public class BtMonitortypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtMonitortypeDAO.class);
	// property constants
	public static final String MONITOR_TYPE_NAME = "monitorTypeName";
	public static final String MONI_TOR_TYPE_DESC = "moniTorTypeDesc";
	public static final String SHOW_METHOD = "showMethod";
	public static final String REMARK = "remark";

	public void save(BtMonitortype transientInstance) {
		log.debug("saving BtMonitortype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtMonitortype persistentInstance) {
		log.debug("deleting BtMonitortype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtMonitortype findById(java.lang.Long id) {
		log.debug("getting BtMonitortype instance with id: " + id);
		try {
			BtMonitortype instance = (BtMonitortype) getSession().get(
					"com.whnr.cac.database.BtMonitortype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtMonitortype> findByExample(BtMonitortype instance) {
		log.debug("finding BtMonitortype instance by example");
		try {
			List<BtMonitortype> results = (List<BtMonitortype>) getSession()
					.createCriteria("com.whnr.cac.database.BtMonitortype")
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
		log.debug("finding BtMonitortype instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtMonitortype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtMonitortype> findByMonitorTypeName(Object monitorTypeName) {
		return findByProperty(MONITOR_TYPE_NAME, monitorTypeName);
	}

	public List<BtMonitortype> findByMoniTorTypeDesc(Object moniTorTypeDesc) {
		return findByProperty(MONI_TOR_TYPE_DESC, moniTorTypeDesc);
	}

	public List<BtMonitortype> findByShowMethod(Object showMethod) {
		return findByProperty(SHOW_METHOD, showMethod);
	}

	public List<BtMonitortype> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BtMonitortype instances");
		try {
			String queryString = "from BtMonitortype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtMonitortype merge(BtMonitortype detachedInstance) {
		log.debug("merging BtMonitortype instance");
		try {
			BtMonitortype result = (BtMonitortype) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtMonitortype instance) {
		log.debug("attaching dirty BtMonitortype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtMonitortype instance) {
		log.debug("attaching clean BtMonitortype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}