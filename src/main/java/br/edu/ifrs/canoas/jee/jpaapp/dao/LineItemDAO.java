package br.edu.ifrs.canoas.jee.jpaapp.dao;

import javax.persistence.EntityManager;

import br.edu.ifrs.canoas.jee.jpaapp.dto.LineItem;
import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class LineItemDAO {

	private EntityManager em;
	
	public void save(LineItem item) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		em.close();
		
	}
	
}
