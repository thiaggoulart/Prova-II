package br.edu.ifrs.canoas.jee.jpaapp.dao;

import javax.persistence.EntityManager;

import br.edu.ifrs.canoas.jee.jpaapp.dto.Account;
import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class AccountDAO {

	private EntityManager em;
	
	public void save(Account account) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		em.close();
		
	}

}
