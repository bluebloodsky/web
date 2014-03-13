package com.whnr.cac.database;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BtbStateevelparainfo entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtbStateevelparainfo
 * @author MyEclipse Persistence Tools
 */
public class BtbStateevelparainfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbStateevelparainfoDAO.class);
	// property constants
	public static final String STATE_EVEL_PARA_RESULT = "stateEvelParaResult";

	public void save(BtbStateevelparainfo transientInstance) {
		log.debug("saving BtbStateevelparainfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbStateevelparainfo persistentInstance) {
		log.debug("deleting BtbStateevelparainfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbStateevelparainfo findById(java.lang.Long id) {
		log.debug("getting BtbStateevelparainfo instance with id: " + id);
		try {
			BtbStateevelparainfo instance = (BtbStateevelparainfo) getSession()
					.get("com.whnr.cac.database.BtbStateevelparainfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbStateevelparainfo> findByExample(
			BtbStateevelparainfo instance) {
		log.debug("finding BtbStateevelparainfo instance by example");
		try {
			List<BtbStateevelparainfo> results = (List<BtbStateevelparainfo>) getSession()
					.createCriteria(
							"com.whnr.cac.database.BtbStateevelparainfo")
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
		log.debug("finding BtbStateevelparainfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbStateevelparainfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbStateevelparainfo> findByStateEvelParaResult(
			Object stateEvelParaResult) {
		return findByProperty(STATE_EVEL_PARA_RESULT, stateEvelParaResult);
	}

	public List findAll() {
		log.debug("finding all BtbStateevelparainfo instances");
		try {
			String queryString = "from BtbStateevelparainfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbStateevelparainfo merge(BtbStateevelparainfo detachedInstance) {
		log.debug("merging BtbStateevelparainfo instance");
		try {
			BtbStateevelparainfo result = (BtbStateevelparainfo) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbStateevelparainfo instance) {
		log.debug("attaching dirty BtbStateevelparainfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbStateevelparainfo instance) {
		log.debug("attaching clean BtbStateevelparainfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}