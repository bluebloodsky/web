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
 * BtMonitorparatype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtMonitorparatype
 * @author MyEclipse Persistence Tools
 */
public class BtMonitorparatypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtMonitorparatypeDAO.class);
	// property constants
	public static final String MONITOR_PARA_NAME = "monitorParaName";
	public static final String MONITOR_PARA_UNIT = "monitorParaUnit";
	public static final String REMARK = "remark";

	public void save(BtMonitorparatype transientInstance) {
		log.debug("saving BtMonitorparatype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtMonitorparatype persistentInstance) {
		log.debug("deleting BtMonitorparatype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtMonitorparatype findById(java.lang.Long id) {
		log.debug("getting BtMonitorparatype instance with id: " + id);
		try {
			BtMonitorparatype instance = (BtMonitorparatype) getSession().get(
					"com.whnr.cac.database.BtMonitorparatype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtMonitorparatype> findByExample(BtMonitorparatype instance) {
		log.debug("finding BtMonitorparatype instance by example");
		try {
			List<BtMonitorparatype> results = (List<BtMonitorparatype>) getSession()
					.createCriteria("com.whnr.cac.database.BtMonitorparatype")
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
		log.debug("finding BtMonitorparatype instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtMonitorparatype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtMonitorparatype> findByMonitorParaName(Object monitorParaName) {
		return findByProperty(MONITOR_PARA_NAME, monitorParaName);
	}

	public List<BtMonitorparatype> findByMonitorParaUnit(Object monitorParaUnit) {
		return findByProperty(MONITOR_PARA_UNIT, monitorParaUnit);
	}

	public List<BtMonitorparatype> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BtMonitorparatype instances");
		try {
			String queryString = "from BtMonitorparatype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtMonitorparatype merge(BtMonitorparatype detachedInstance) {
		log.debug("merging BtMonitorparatype instance");
		try {
			BtMonitorparatype result = (BtMonitorparatype) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtMonitorparatype instance) {
		log.debug("attaching dirty BtMonitorparatype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtMonitorparatype instance) {
		log.debug("attaching clean BtMonitorparatype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}