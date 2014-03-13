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
 * BtbMonitordeviceinfo entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtbMonitordeviceinfo
 * @author MyEclipse Persistence Tools
 */
public class BtbMonitordeviceinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbMonitordeviceinfoDAO.class);
	// property constants
	public static final String REMARK = "remark";

	public void save(BtbMonitordeviceinfo transientInstance) {
		log.debug("saving BtbMonitordeviceinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbMonitordeviceinfo persistentInstance) {
		log.debug("deleting BtbMonitordeviceinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbMonitordeviceinfo findById(java.lang.Long id) {
		log.debug("getting BtbMonitordeviceinfo instance with id: " + id);
		try {
			BtbMonitordeviceinfo instance = (BtbMonitordeviceinfo) getSession()
					.get("com.whnr.cac.database.BtbMonitordeviceinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbMonitordeviceinfo> findByExample(
			BtbMonitordeviceinfo instance) {
		log.debug("finding BtbMonitordeviceinfo instance by example");
		try {
			List<BtbMonitordeviceinfo> results = (List<BtbMonitordeviceinfo>) getSession()
					.createCriteria(
							"com.whnr.cac.database.BtbMonitordeviceinfo")
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
		log.debug("finding BtbMonitordeviceinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbMonitordeviceinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbMonitordeviceinfo> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BtbMonitordeviceinfo instances");
		try {
			String queryString = "from BtbMonitordeviceinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbMonitordeviceinfo merge(BtbMonitordeviceinfo detachedInstance) {
		log.debug("merging BtbMonitordeviceinfo instance");
		try {
			BtbMonitordeviceinfo result = (BtbMonitordeviceinfo) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbMonitordeviceinfo instance) {
		log.debug("attaching dirty BtbMonitordeviceinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbMonitordeviceinfo instance) {
		log.debug("attaching clean BtbMonitordeviceinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}