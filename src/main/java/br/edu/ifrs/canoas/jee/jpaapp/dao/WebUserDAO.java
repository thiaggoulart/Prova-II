package br.edu.ifrs.canoas.jee.jpaapp.dao;

import javax.persistence.EntityManager;

import br.edu.ifrs.canoas.jee.jpaapp.dto.Pedido;
import br.edu.ifrs.canoas.jee.jpaapp.dto.WebUser;
import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class WebUserDAO {
	
	private EntityManager em;
	
	public void save(WebUser webUser) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();
		em.persist(webUser);
		em.getTransaction().commit();
		em.close();
		
	}

}
