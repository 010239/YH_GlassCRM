package crm.backend.dao;

import java.util.List;

import crm.backend.entity.Account;

public interface AccountDao extends BaseDao{
	
	Account findByNameAndPassword(String name, String password);

	List<Account> findAll();
}
