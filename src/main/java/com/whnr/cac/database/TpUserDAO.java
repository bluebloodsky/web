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
 * TpUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.whnr.cac.database.TpUser
 * @author MyEclipse Persistence Tools
 */
public class TpUserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TpUserDAO.class);
	// property constants
	public static final String LOGIN_NAME = "loginName";
	public static final String REAL_NAME = "realName";
	public static final String PASSWORD = "password";
	public static final String TELEPHONE = "telephone";
	public static final String POST = "post";
	public static final String EMAIL = "email";
	public static final String REMARK = "remark";

	public void save(TpUser transientInstance) {
		log.debug("saving TpUser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TpUser persistentInstance) {
		log.debug("deleting TpUser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TpUser findById(java.lang.Long id) {
		log.debug("getting TpUser instance with id: " + id);
		try {
			TpUser instance = (TpUser) getSession().get(
					"com.whnr.cac.database.TpUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TpUser> findByExample(TpUser instance) {
		log.debug("finding TpUser instance by example");
		try {
			List<TpUser> results = (List<TpUser>) getSession()
					.createCriteria("com.whnr.cac.database.TpUser")
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
		log.debug("finding TpUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TpUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TpUser> findByLoginName(Object loginName) {
		return findByProperty(LOGIN_NAME, loginName);
	}

	public List<TpUser> findByRealName(Object realName) {
		return findByProperty(REAL_NAME, realName);
	}

	public List<TpUser> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<TpUser> findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List<TpUser> findByPost(Object post) {
		return findByProperty(POST, post);
	}

	public List<TpUser> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<TpUser> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all TpUser instances");
		try {
			String queryString = "from TpUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TpUser merge(TpUser detachedInstance) {
		log.debug("merging TpUser instance");
		try {
			TpUser result = (TpUser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TpUser instance) {
		log.debug("attaching dirty TpUser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TpUser instance) {
		log.debug("attaching clean TpUser instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}