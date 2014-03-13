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
 * TCurrentquality entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.TCurrentquality
 * @author MyEclipse Persistence Tools
 */
public class TCurrentqualityDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TCurrentqualityDAO.class);
	// property constants
	public static final String CURRENT_NAME = "currentName";
	public static final String REMARK = "remark";

	public void save(TCurrentquality transientInstance) {
		log.debug("saving TCurrentquality instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TCurrentquality persistentInstance) {
		log.debug("deleting TCurrentquality instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TCurrentquality findById(java.lang.Long id) {
		log.debug("getting TCurrentquality instance with id: " + id);
		try {
			TCurrentquality instance = (TCurrentquality) getSession().get(
					"com.whnr.cac.database.TCurrentquality", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TCurrentquality> findByExample(TCurrentquality instance) {
		log.debug("finding TCurrentquality instance by example");
		try {
			List<TCurrentquality> results = (List<TCurrentquality>) getSession()
					.createCriteria("com.whnr.cac.database.TCurrentquality")
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
		log.debug("finding TCurrentquality instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TCurrentquality as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TCurrentquality> findByCurrentName(Object currentName) {
		return findByProperty(CURRENT_NAME, currentName);
	}

	public List<TCurrentquality> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all TCurrentquality instances");
		try {
			String queryString = "from TCurrentquality";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCurrentquality merge(TCurrentquality detachedInstance) {
		log.debug("merging TCurrentquality instance");
		try {
			TCurrentquality result = (TCurrentquality) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCurrentquality instance) {
		log.debug("attaching dirty TCurrentquality instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TCurrentquality instance) {
		log.debug("attaching clean TCurrentquality instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}