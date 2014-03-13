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
 * TpUserroletype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.TpUserroletype
 * @author MyEclipse Persistence Tools
 */
public class TpUserroletypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TpUserroletypeDAO.class);
	// property constants
	public static final String USER_ROLE_NAME = "userRoleName";
	public static final String REMARK = "remark";

	public void save(TpUserroletype transientInstance) {
		log.debug("saving TpUserroletype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TpUserroletype persistentInstance) {
		log.debug("deleting TpUserroletype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TpUserroletype findById(java.lang.Long id) {
		log.debug("getting TpUserroletype instance with id: " + id);
		try {
			TpUserroletype instance = (TpUserroletype) getSession().get(
					"com.whnr.cac.database.TpUserroletype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TpUserroletype> findByExample(TpUserroletype instance) {
		log.debug("finding TpUserroletype instance by example");
		try {
			List<TpUserroletype> results = (List<TpUserroletype>) getSession()
					.createCriteria("com.whnr.cac.database.TpUserroletype")
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
		log.debug("finding TpUserroletype instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TpUserroletype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TpUserroletype> findByUserRoleName(Object userRoleName) {
		return findByProperty(USER_ROLE_NAME, userRoleName);
	}

	public List<TpUserroletype> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all TpUserroletype instances");
		try {
			String queryString = "from TpUserroletype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TpUserroletype merge(TpUserroletype detachedInstance) {
		log.debug("merging TpUserroletype instance");
		try {
			TpUserroletype result = (TpUserroletype) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TpUserroletype instance) {
		log.debug("attaching dirty TpUserroletype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TpUserroletype instance) {
		log.debug("attaching clean TpUserroletype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}