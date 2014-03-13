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
 * BtMonitordevphase entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtMonitordevphase
 * @author MyEclipse Persistence Tools
 */
public class BtMonitordevphaseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtMonitordevphaseDAO.class);
	// property constants
	public static final String PHASE_NAME = "phaseName";
	public static final String REMARK = "remark";

	public void save(BtMonitordevphase transientInstance) {
		log.debug("saving BtMonitordevphase instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtMonitordevphase persistentInstance) {
		log.debug("deleting BtMonitordevphase instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtMonitordevphase findById(java.lang.Long id) {
		log.debug("getting BtMonitordevphase instance with id: " + id);
		try {
			BtMonitordevphase instance = (BtMonitordevphase) getSession().get(
					"com.whnr.cac.database.BtMonitordevphase", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtMonitordevphase> findByExample(BtMonitordevphase instance) {
		log.debug("finding BtMonitordevphase instance by example");
		try {
			List<BtMonitordevphase> results = (List<BtMonitordevphase>) getSession()
					.createCriteria("com.whnr.cac.database.BtMonitordevphase")
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
		log.debug("finding BtMonitordevphase instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtMonitordevphase as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtMonitordevphase> findByPhaseName(Object phaseName) {
		return findByProperty(PHASE_NAME, phaseName);
	}

	public List<BtMonitordevphase> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BtMonitordevphase instances");
		try {
			String queryString = "from BtMonitordevphase";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtMonitordevphase merge(BtMonitordevphase detachedInstance) {
		log.debug("merging BtMonitordevphase instance");
		try {
			BtMonitordevphase result = (BtMonitordevphase) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtMonitordevphase instance) {
		log.debug("attaching dirty BtMonitordevphase instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtMonitordevphase instance) {
		log.debug("attaching clean BtMonitordevphase instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}