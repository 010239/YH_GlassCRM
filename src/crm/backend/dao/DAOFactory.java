package crm.backend.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {
    private static AccountDao accountDao;
    private static CustomerDao customerDao;

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManager getEntityManager(){
    	if (entityManager == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("crm.backend");
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }    

    public static void close(){
        if(entityManager.isOpen()){
            entityManager.close();
        }
        if(entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    /**
     * 获取账户DAO
     * @return AccountDao
     */
    public static AccountDao getAccountDao(EntityManager entityManager) {
        if(accountDao == null){
            accountDao = new AccountDaoImpl(entityManager);
        }
        return accountDao;
    }

    /**
     * 获取客户管理DAO
     * @return CustomerDao
     */
    public static CustomerDao getCustomerDao(EntityManager entityManager) {
        if(customerDao == null){
            customerDao = new CustomerDaoImpl(entityManager);
        }
        return customerDao;
    }

    // public static void main(String[] args) {
    // 	 Account account = new Account();
    //      account.setName("admin");
    //      account.setPassword("123456");
    //
    //      getAccountDao().save(account);
    //
    //      getAccountDao().close();
	// }
}
