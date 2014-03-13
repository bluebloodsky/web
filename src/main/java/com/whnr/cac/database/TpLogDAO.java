package com.whnr.cac.database;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for TpLog
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.whnr.cac.database.TpLog
 * @author MyEclipse Persistence Tools
 */
public class TpLogDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TpLogDAO.class);
	// property constants
	public static final String TARGET = "target";
	public static final String METHOD = "method";
	public static final String RESULT = "result";
	public static final String DETAILS = "details";

	public void save(TpLog transientInstance) {
		log.debug("saving TpLog instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TpLog persistentInstance) {
		log.debug("deleting TpLog instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TpLog findById(java.lang.Long id) {
		log.debug("getting TpLog instance with id: " + id);
		try {
			TpLog instance = (TpLog) getSession().get(
					"com.whnr.cac.database.TpLog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TpLog> findByExample(TpLog instance) {
		log.debug("finding TpLog instance by example");
		try {
			List<TpLog> results = (List<TpLog>) getSession()
					.createCriteria("com.whnr.cac.database.TpLog")
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
		log.debug("finding TpLog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TpLog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TpLog> findByTarget(Object target) {
		return findByProperty(TARGET, target);
	}

	public List<TpLog> findByMethod(Object method) {
		return findByProperty(METHOD, method);
	}

	public List<TpLog> findByResult(Object result) {
		return findByProperty(RESULT, result);
	}

	public List<TpLog> findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	public List findAll() {
		log.debug("finding all TpLog instances");
		try {
			String queryString = "from TpLog";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TpLog merge(TpLog detachedInstance) {
		log.debug("merging TpLog instance");
		try {
			TpLog result = (TpLog) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TpLog instance) {
		log.debug("attaching dirty TpLog instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TpLog instance) {
		log.debug("attaching clean TpLog instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}