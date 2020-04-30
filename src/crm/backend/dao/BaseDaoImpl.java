package crm.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import crm.backend.entity.Customer;

@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao{

	protected EntityManager em;

	public BaseDaoImpl(EntityManager em) {
	    this.em = em;
	}

    public void save(Object entity) {
		em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void update(Object entity) {
    	em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public <T> void delete(Class<T> entityClass, Object entityid) {
        delete(entityClass, new Object[]{entityid});
    }


    public <T> void delete(Class<T> entityClass, Object[] entityids) {
        for(Object entityid : entityids) {
            em.remove(em.getReference(entityClass, entityid));
        }
    }

	public <T> T find(Class<T> entityClass, Object entityid) {
		 return em.find(entityClass, entityid);
	}


//	public T create(T t) {
//		em.getTransaction().begin();
//		em.persist(t);
//		em.getTransaction().commit();
//		// em.close();
//		return t;
//	}
//
//	public T find(Long id) {
//		em.getTransaction().begin();
//		T customer = em.find(T.class, id);
//		em.getTransaction().commit();
//		// em.close();
//		return customer;
//	}
}
