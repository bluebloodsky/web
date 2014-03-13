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
 * TbCominfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.whnr.cac.database.TbCominfo
 * @author MyEclipse Persistence Tools
 */
public class TbCominfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbCominfoDAO.class);
	// property constants
	public static final String COMPANY_NAME = "companyName";
	public static final String COM_INFO_NAME = "comInfoName";

	public void save(TbCominfo transientInstance) {
		log.debug("saving TbCominfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbCominfo persistentInstance) {
		log.debug("deleting TbCominfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbCominfo findById(java.lang.Long id) {
		log.debug("getting TbCominfo instance with id: " + id);
		try {
			TbCominfo instance = (TbCominfo) getSession().get(
					"com.whnr.cac.database.TbCominfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TbCominfo> findByExample(TbCominfo instance) {
		log.debug("finding TbCominfo instance by example");
		try {
			List<TbCominfo> results = (List<TbCominfo>) getSession()
					.createCriteria("com.whnr.cac.database.TbCominfo")
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
		log.debug("finding TbCominfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbCominfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TbCominfo> findByCompanyName(Object companyName) {
		return findByProperty(COMPANY_NAME, companyName);
	}

	public List<TbCominfo> findByComInfoName(Object comInfoName) {
		return findByProperty(COM_INFO_NAME, comInfoName);
	}

	public List findAll() {
		log.debug("finding all TbCominfo instances");
		try {
			String queryString = "from TbCominfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbCominfo merge(TbCominfo detachedInstance) {
		log.debug("merging TbCominfo instance");
		try {
			TbCominfo result = (TbCominfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbCominfo instance) {
		log.debug("attaching dirty TbCominfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbCominfo instance) {
		log.debug("attaching clean TbCominfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}