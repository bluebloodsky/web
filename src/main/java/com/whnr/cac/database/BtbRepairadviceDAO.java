package com.whnr.cac.database;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BtbRepairadvice entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtbRepairadvice
 * @author MyEclipse Persistence Tools
 */
public class BtbRepairadviceDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbRepairadviceDAO.class);
	// property constants
	public static final String REPAIR_TIME = "repairTime";

	public void save(BtbRepairadvice transientInstance) {
		log.debug("saving BtbRepairadvice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbRepairadvice persistentInstance) {
		log.debug("deleting BtbRepairadvice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbRepairadvice findById(java.lang.Long id) {
		log.debug("getting BtbRepairadvice instance with id: " + id);
		try {
			BtbRepairadvice instance = (BtbRepairadvice) getSession().get(
					"com.whnr.cac.database.BtbRepairadvice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbRepairadvice> findByExample(BtbRepairadvice instance) {
		log.debug("finding BtbRepairadvice instance by example");
		try {
			List<BtbRepairadvice> results = (List<BtbRepairadvice>) getSession()
					.createCriteria("com.whnr.cac.database.BtbRepairadvice")
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
		log.debug("finding BtbRepairadvice instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbRepairadvice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbRepairadvice> findByRepairTime(Object repairTime) {
		return findByProperty(REPAIR_TIME, repairTime);
	}

	public List findAll() {
		log.debug("finding all BtbRepairadvice instances");
		try {
			String queryString = "from BtbRepairadvice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbRepairadvice merge(BtbRepairadvice detachedInstance) {
		log.debug("merging BtbRepairadvice instance");
		try {
			BtbRepairadvice result = (BtbRepairadvice) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbRepairadvice instance) {
		log.debug("attaching dirty BtbRepairadvice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbRepairadvice instance) {
		log.debug("attaching clean BtbRepairadvice instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}