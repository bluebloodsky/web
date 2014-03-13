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
 * TDevicetype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.TDevicetype
 * @author MyEclipse Persistence Tools
 */
public class TDevicetypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TDevicetypeDAO.class);
	// property constants
	public static final String DEVICE_TYPE_NAME = "deviceTypeName";
	public static final String DEVICE_TYPE_DESC = "deviceTypeDesc";
	public static final String FATHER_ID = "fatherId";
	public static final String STATE_PARA_NUM = "stateParaNum";
	public static final String BOR_S = "borS";
	public static final String REMARK = "remark";

	public void save(TDevicetype transientInstance) {
		log.debug("saving TDevicetype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TDevicetype persistentInstance) {
		log.debug("deleting TDevicetype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TDevicetype findById(java.lang.Long id) {
		log.debug("getting TDevicetype instance with id: " + id);
		try {
			TDevicetype instance = (TDevicetype) getSession().get(
					"com.whnr.cac.database.TDevicetype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TDevicetype> findByExample(TDevicetype instance) {
		log.debug("finding TDevicetype instance by example");
		try {
			List<TDevicetype> results = (List<TDevicetype>) getSession()
					.createCriteria("com.whnr.cac.database.TDevicetype")
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
		log.debug("finding TDevicetype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TDevicetype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TDevicetype> findByDeviceTypeName(Object deviceTypeName) {
		return findByProperty(DEVICE_TYPE_NAME, deviceTypeName);
	}

	public List<TDevicetype> findByDeviceTypeDesc(Object deviceTypeDesc) {
		return findByProperty(DEVICE_TYPE_DESC, deviceTypeDesc);
	}

	public List<TDevicetype> findByFatherId(Object fatherId) {
		return findByProperty(FATHER_ID, fatherId);
	}

	public List<TDevicetype> findByStateParaNum(Object stateParaNum) {
		return findByProperty(STATE_PARA_NUM, stateParaNum);
	}

	public List<TDevicetype> findByBorS(Object borS) {
		return findByProperty(BOR_S, borS);
	}

	public List<TDevicetype> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all TDevicetype instances");
		try {
			String queryString = "from TDevicetype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TDevicetype merge(TDevicetype detachedInstance) {
		log.debug("merging TDevicetype instance");
		try {
			TDevicetype result = (TDevicetype) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TDevicetype instance) {
		log.debug("attaching dirty TDevicetype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TDevicetype instance) {
		log.debug("attaching clean TDevicetype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}