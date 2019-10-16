package br.edu.ifrs.canoas.jee.jpaapp.dao;

import javax.persistence.EntityManager;

import br.edu.ifrs.canoas.jee.jpaapp.dto.Address;
import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class AddressDAO {

	private EntityManager em;
	
	public void save(Address address) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
		em.close();
		
	}
	
}
