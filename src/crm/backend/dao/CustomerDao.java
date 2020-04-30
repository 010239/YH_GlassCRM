package crm.backend.dao;

import crm.backend.entity.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao{

//    Customer create(Customer customer);
//
//    Customer find(Long id);

    List<Customer> findByNameOrPhone(String name, String phone);

    /**
     *
     * @param first 开始
     * @param max
     * @return
     */
    List<Customer> find(int first, int max);

//    List<Customer> findByName(String name);
//
//    List<Customer> findByPhone(String phone);


//    Customer update(Customer customer);
//
//
//    void delete(Customer customer);
//
//    public void delete(Long customerId);
//
//    public void init();

    /**
     * close the entity manager factory
     */
//    void close();
}
