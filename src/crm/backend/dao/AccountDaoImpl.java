package crm.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import crm.backend.entity.Account;

public class AccountDaoImpl extends BaseDaoImpl implements AccountDao {

	public AccountDaoImpl(EntityManager em) {
		super(em);
	}

	public Account findByNameAndPassword(String name, String password) {
		Query query = em.createQuery("from Account where name like :name or password =:password");
		query.setParameter("name", name);
		query.setParameter("password", password);

		Account account = (Account) query.getSingleResult();

		return account;
	}

//	@Override
	public List<Account> findAll(){
		Query query = em.createQuery("from Account");

		List<Account> accountList = (List<Account>) query.getResultList();

		return accountList;
	}

}
