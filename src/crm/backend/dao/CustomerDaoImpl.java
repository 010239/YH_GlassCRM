package crm.backend.dao;

import crm.backend.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CustomerDaoImpl extends BaseDaoImpl implements CustomerDao{

//    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm.backend");
//    private EntityManager em;

    // public static CustomerDao customerDao = new CustomerDaoImpl();

    public CustomerDaoImpl(EntityManager em) {
        super(em);
    }

//    private CustomerDaoImpl() {
//        em = emf.createEntityManager();
//    }

//    public void init() {
//
//    }

//    public Customer create(Customer customer) {
//        em.getTransaction().begin();
//        em.persist(customer);
//        em.getTransaction().commit();
//        // em.close();
//        return customer;
//    }

//    public Customer find(Long id) {
//        em.getTransaction().begin();
//        Customer customer = em.find(Customer.class, id);
//        em.getTransaction().commit();
//        // em.close();
//        return customer;
//    }

    public List<Customer> findByNameOrPhone(String name, String phone) {
    	em.getTransaction().begin();

        Query query = em.createQuery("from Customer where name like :name or mobilephone =:phone");
//        query.setParameter("name", name);
        query.setParameter("phone", phone);
        query.setParameter("name", "%" + name + "%");
        List<Customer> list = query.getResultList();

        em.getTransaction().commit();
        // em.close();
        return list;
    }

    public List<Customer> find(int first,int max) {
        em.getTransaction().begin();

        Query query = em.createQuery("from Customer");
        query.setFirstResult(first);
        query.setMaxResults(max);
        List<Customer> list = query.getResultList();

        em.getTransaction().commit();
        // em.close();
        return list;
    }

//    public List<Customer> findByName(String name) {
//        em.getTransaction().begin();
//
//        Query query = em.createQuery("from Customer where name = :name");
//        query.setParameter("name", name);
//        List<Customer> list = query.getResultList();
//
//        em.getTransaction().commit();
//        // em.close();
//        return list;
//    }
//
//    public List<Customer> findByPhone(String phone) {
//        em.getTransaction().begin();
//
//        Query query = em.createQuery("from Customer where mobilephone = :phone");
//        query.setParameter("phone", phone);
//        // query.setParameter("custAddress", "%1%");
//        List<Customer> list = query.getResultList();
//
//        em.getTransaction().commit();
//        // em.close();
//        return list;
//    }

//    public Customer update(Customer customer) {
//        em.getTransaction().begin();
//        customer = em.merge(customer);
//        em.getTransaction().commit();
//        // em.close();
//        return customer;
//    }

//    public void delete(Customer customer) {
//        em.getTransaction().begin();
//        em.remove(customer);
//        em.getTransaction().commit();
//        // em.close();
//    }

//    public void delete(Long customerId) {
//        em.getTransaction().begin();
//        Customer customer = em.find(Customer.class, customerId);
//        em.remove(customer);
//        em.getTransaction().commit();
//        // em.close();
//    }


}
