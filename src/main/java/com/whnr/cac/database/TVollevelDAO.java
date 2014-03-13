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
 * TVollevel entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.whnr.cac.database.TVollevel
 * @author MyEclipse Persistence Tools
 */
public class TVollevelDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TVollevelDAO.class);
	// property constants
	public static final String VOL_LEVEL = "volLevel";
	public static final String REMARK = "remark";

	public void save(TVollevel transientInstance) {
		log.debug("saving TVollevel instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TVollevel persistentInstance) {
		log.debug("deleting TVollevel instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TVollevel findById(java.lang.Long id) {
		log.debug("getting TVollevel instance with id: " + id);
		try {
			TVollevel instance = (TVollevel) getSession().get(
					"com.whnr.cac.database.TVollevel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TVollevel> findByExample(TVollevel instance) {
		log.debug("finding TVollevel instance by example");
		try {
			List<TVollevel> results = (List<TVollevel>) getSession()
					.createCriteria("com.whnr.cac.database.TVollevel")
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
		log.debug("finding TVollevel instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TVollevel as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TVollevel> findByVolLevel(Object volLevel) {
		return findByProperty(VOL_LEVEL, volLevel);
	}

	public List<TVollevel> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all TVollevel instances");
		try {
			String queryString = "from TVollevel";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TVollevel merge(TVollevel detachedInstance) {
		log.debug("merging TVollevel instance");
		try {
			TVollevel result = (TVollevel) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TVollevel instance) {
		log.debug("attaching dirty TVollevel instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TVollevel instance) {
		log.debug("attaching clean TVollevel instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}