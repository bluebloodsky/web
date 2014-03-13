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
 * BtbSubdevice entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtbSubdevice
 * @author MyEclipse Persistence Tools
 */
public class BtbSubdeviceDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbSubdeviceDAO.class);
	// property constants
	public static final String REMARK = "remark";

	public void save(BtbSubdevice transientInstance) {
		log.debug("saving BtbSubdevice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbSubdevice persistentInstance) {
		log.debug("deleting BtbSubdevice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbSubdevice findById(java.lang.Long id) {
		log.debug("getting BtbSubdevice instance with id: " + id);
		try {
			BtbSubdevice instance = (BtbSubdevice) getSession().get(
					"com.whnr.cac.database.BtbSubdevice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbSubdevice> findByExample(BtbSubdevice instance) {
		log.debug("finding BtbSubdevice instance by example");
		try {
			List<BtbSubdevice> results = (List<BtbSubdevice>) getSession()
					.createCriteria("com.whnr.cac.database.BtbSubdevice")
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
		log.debug("finding BtbSubdevice instance with property: "
				+ propertyName + ", value: " + value );
		try {
			String queryString = "from BtbSubdevice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbSubdevice> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BtbSubdevice instances");
		try {
			String queryString = "from BtbSubdevice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbSubdevice merge(BtbSubdevice detachedInstance) {
		log.debug("merging BtbSubdevice instance");
		try {
			BtbSubdevice result = (BtbSubdevice) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbSubdevice instance) {
		log.debug("attaching dirty BtbSubdevice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbSubdevice instance) {
		log.debug("attaching clean BtbSubdevice instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}