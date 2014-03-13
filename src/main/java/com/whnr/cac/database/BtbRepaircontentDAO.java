package com.whnr.cac.database;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * BtbRepaircontent entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtbRepaircontent
 * @author MyEclipse Persistence Tools
 */
public class BtbRepaircontentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtbRepaircontentDAO.class);
	// property constants
	public static final String REPAIR_NUM = "repairNum";
	public static final String REPAIR_CONTENT_DESC = "repairContentDesc";
	public static final String REPAIR_REASON = "repairReason";

	public void save(BtbRepaircontent transientInstance) {
		log.debug("saving BtbRepaircontent instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtbRepaircontent persistentInstance) {
		log.debug("deleting BtbRepaircontent instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtbRepaircontent findById(java.lang.Long id) {
		log.debug("getting BtbRepaircontent instance with id: " + id);
		try {
			BtbRepaircontent instance = (BtbRepaircontent) getSession().get(
					"com.whnr.cac.database.BtbRepaircontent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtbRepaircontent> findByExample(BtbRepaircontent instance) {
		log.debug("finding BtbRepaircontent instance by example");
		try {
			List<BtbRepaircontent> results = (List<BtbRepaircontent>) getSession()
					.createCriteria("com.whnr.cac.database.BtbRepaircontent")
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
		log.debug("finding BtbRepaircontent instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtbRepaircontent as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtbRepaircontent> findByRepairNum(Object repairNum) {
		return findByProperty(REPAIR_NUM, repairNum);
	}

	public List<BtbRepaircontent> findByRepairContentDesc(
			Object repairContentDesc) {
		return findByProperty(REPAIR_CONTENT_DESC, repairContentDesc);
	}

	public List<BtbRepaircontent> findByRepairReason(Object repairReason) {
		return findByProperty(REPAIR_REASON, repairReason);
	}

	public List findAll() {
		log.debug("finding all BtbRepaircontent instances");
		try {
			String queryString = "from BtbRepaircontent";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtbRepaircontent merge(BtbRepaircontent detachedInstance) {
		log.debug("merging BtbRepaircontent instance");
		try {
			BtbRepaircontent result = (BtbRepaircontent) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtbRepaircontent instance) {
		log.debug("attaching dirty BtbRepaircontent instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtbRepaircontent instance) {
		log.debug("attaching clean BtbRepaircontent instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}