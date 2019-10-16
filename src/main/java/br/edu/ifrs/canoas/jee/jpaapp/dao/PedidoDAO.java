package br.edu.ifrs.canoas.jee.jpaapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpaapp.dto.OrderStatus;
import br.edu.ifrs.canoas.jee.jpaapp.dto.Pedido;
import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class PedidoDAO {

	private EntityManager em;
	
	public void save(Pedido order) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Pedido> findAllOrderByOrdered() {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		TypedQuery<Pedido> query = em.createQuery("SELECT pedido FROM Pedido pedido", Pedido.class);
		List<Pedido> pedidos = query.getResultList();
		return pedidos;
		
	}
	
	public List<Pedido> findAllOrderByOrderStatus(OrderStatus status) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		TypedQuery<Pedido> query = em.createQuery(
				"SELECT pedido FROM Pedido pedido  where lower(pedido.status = lower(:status)", Pedido.class);
		query.setParameter("status", status);
		List<Pedido> pedidos = query.getResultList();
		return pedidos;
		
	}
	
	public boolean edit(Pedido order) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();
		em.merge(order);
		em.getTransaction().commit();
		em.close();
		
		return true;
		
	}
	
	public boolean delete(Long id ) {
		
		if (em == null || !em.isOpen()) {
			em = EntityManagerUtil.getEM();
		}
		
		em.getTransaction().begin();    	
    	Pedido pedidoRecuperado = em.find(Pedido.class, id);
		em.remove(pedidoRecuperado);
		em.getTransaction().commit();
		em.close();
		
		return true;
		
	}
	
}
