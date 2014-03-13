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
 * BtzStateeval entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.whnr.cac.database.BtzStateeval
 * @author MyEclipse Persistence Tools
 */
public class BtzStateevalDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BtzStateevalDAO.class);
	// property constants
	public static final String STATE_EVAL_SCORE = "stateEvalScore";
	public static final String EVALUATOR_ID = "evaluatorId";
	public static final String ADVICE = "advice";
	public static final String REMARK = "remark";

	public void save(BtzStateeval transientInstance) {
		log.debug("saving BtzStateeval instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BtzStateeval persistentInstance) {
		log.debug("deleting BtzStateeval instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BtzStateeval findById(java.lang.Long id) {
		log.debug("getting BtzStateeval instance with id: " + id);
		try {
			BtzStateeval instance = (BtzStateeval) getSession().get(
					"com.whnr.cac.database.BtzStateeval", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BtzStateeval> findByExample(BtzStateeval instance) {
		log.debug("finding BtzStateeval instance by example");
		try {
			List<BtzStateeval> results = (List<BtzStateeval>) getSession()
					.createCriteria("com.whnr.cac.database.BtzStateeval")
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
		log.debug("finding BtzStateeval instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BtzStateeval as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BtzStateeval> findByStateEvalScore(Object stateEvalScore) {
		return findByProperty(STATE_EVAL_SCORE, stateEvalScore);
	}

	public List<BtzStateeval> findByEvaluatorId(Object evaluatorId) {
		return findByProperty(EVALUATOR_ID, evaluatorId);
	}

	public List<BtzStateeval> findByAdvice(Object advice) {
		return findByProperty(ADVICE, advice);
	}

	public List<BtzStateeval> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all BtzStateeval instances");
		try {
			String queryString = "from BtzStateeval";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BtzStateeval merge(BtzStateeval detachedInstance) {
		log.debug("merging BtzStateeval instance");
		try {
			BtzStateeval result = (BtzStateeval) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BtzStateeval instance) {
		log.debug("attaching dirty BtzStateeval instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BtzStateeval instance) {
		log.debug("attaching clean BtzStateeval instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}