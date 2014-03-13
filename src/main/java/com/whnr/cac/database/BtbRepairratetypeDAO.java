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
 * BtbRepairratetype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtbRepairratetype
 * @author MyEclipse Persistence Tools
 */
public class BtbRepairratetypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbRepairratetypeDAO.class);
	// property constants
	public static final String REPAIR_RATE_TYPE_NAME = "repairRateTypeName";

	public void save(BtbRepairratetype transientInstance) {
		log.debug("saving BtbRepairratetype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbRepairratetype persistentInstance) {
		log.debug("deleting BtbRepairratetype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbRepairratetype findById(java.lang.String id) {
		log.debug("getting BtbRepairratetype instance with id: " + id);
		try {
			BtbRepairratetype instance = (BtbRepairratetype) getSession().get(
					"com.whnr.cac.database.BtbRepairratetype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbRepairratetype> findByExample(BtbRepairratetype instance) {
		log.debug("finding BtbRepairratetype instance by example");
		try {
			List<BtbRepairratetype> results = (List<BtbRepairratetype>) getSession()
					.createCriteria("com.whnr.cac.database.BtbRepairratetype")
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
		log.debug("finding BtbRepairratetype instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbRepairratetype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbRepairratetype> findByRepairRateTypeName(
			Object repairRateTypeName) {
		return findByProperty(REPAIR_RATE_TYPE_NAME, repairRateTypeName);
	}

	public List findAll() {
		log.debug("finding all BtbRepairratetype instances");
		try {
			String queryString = "from BtbRepairratetype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbRepairratetype merge(BtbRepairratetype detachedInstance) {
		log.debug("merging BtbRepairratetype instance");
		try {
			BtbRepairratetype result = (BtbRepairratetype) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbRepairratetype instance) {
		log.debug("attaching dirty BtbRepairratetype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbRepairratetype instance) {
		log.debug("attaching clean BtbRepairratetype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}