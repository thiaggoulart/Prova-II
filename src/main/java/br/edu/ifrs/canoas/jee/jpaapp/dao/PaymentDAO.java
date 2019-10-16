package br.edu.ifrs.canoas.jee.jpaapp.dao;

import javax.persistence.EntityManager;

import br.edu.ifrs.canoas.jee.jpaapp.dto.Payment;
import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class PaymentDAO {

	private EntityManager em;
	
	public void save(Payment payment) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();
		em.persist(payment);
		em.getTransaction().commit();
		em.close();
		
	}
	
}
