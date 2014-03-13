package com.whnr.cac.database;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * DtsMonitorstate entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.DtsMonitorstate
 * @author MyEclipse Persistence Tools
 */
public class DtsMonitorstateDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DtsMonitorstateDAO.class);
	// property constants
	public static final String MONITOR_STATE_VALUE = "monitorStateValue";

	public void save(DtsMonitorstate transientInstance) {
		log.debug("saving DtsMonitorstate instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DtsMonitorstate persistentInstance) {
		log.debug("deleting DtsMonitorstate instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DtsMonitorstate findById(java.lang.Long id) {
		log.debug("getting DtsMonitorstate instance with id: " + id);
		try {
			DtsMonitorstate instance = (DtsMonitorstate) getSession().get(
					"com.whnr.cac.database.DtsMonitorstate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DtsMonitorstate> findByExample(DtsMonitorstate instance) {
		log.debug("finding DtsMonitorstate instance by example");
		try {
			List<DtsMonitorstate> results = (List<DtsMonitorstate>) getSession()
					.createCriteria("com.whnr.cac.database.DtsMonitorstate")
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
		log.debug("finding DtsMonitorstate instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DtsMonitorstate as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<DtsMonitorstate> findByMonitorStateValue(
			Object monitorStateValue) {
		return findByProperty(MONITOR_STATE_VALUE, monitorStateValue);
	}

	public List findAll() {
		log.debug("finding all DtsMonitorstate instances");
		try {
			String queryString = "from DtsMonitorstate";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DtsMonitorstate merge(DtsMonitorstate detachedInstance) {
		log.debug("merging DtsMonitorstate instance");
		try {
			DtsMonitorstate result = (DtsMonitorstate) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DtsMonitorstate instance) {
		log.debug("attaching dirty DtsMonitorstate instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DtsMonitorstate instance) {
		log.debug("attaching clean DtsMonitorstate instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}