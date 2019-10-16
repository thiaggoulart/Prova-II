package br.edu.ifrs.canoas.jee.jpaapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpaapp.dto.Customer;
import br.edu.ifrs.canoas.jee.jpaapp.dto.Pedido;
import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class CustomerDAO {

	private EntityManager em;
	
	public void save(Customer customer) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Customer> findAll() {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		TypedQuery<Customer> query = em.createQuery("SELECT customer FROM Customer customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
		
	}
	
	public List<Customer> findByNameUsingLike(String name) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		TypedQuery<Customer> query = em.createQuery(
				"SELECT pedido FROM Pedido pedido  where lower(pedido.name like lower(%:name%)", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
		
	}
	
	public boolean delete(Pedido order) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();    	
    	Pedido pedidoRecuperado = em.find(Pedido.class, order.getId());
		em.remove(pedidoRecuperado);
		em.getTransaction().commit();
		em.close();
		
		return true;
		
	}
	
}
