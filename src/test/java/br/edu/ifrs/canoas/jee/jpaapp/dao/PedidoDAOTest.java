package br.edu.ifrs.canoas.jee.jpaapp.dao;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.jpaapp.dto.Account;
import br.edu.ifrs.canoas.jee.jpaapp.dto.Address;
import br.edu.ifrs.canoas.jee.jpaapp.dto.LineItem;
import br.edu.ifrs.canoas.jee.jpaapp.dto.OrderStatus;
import br.edu.ifrs.canoas.jee.jpaapp.dto.Payment;
import br.edu.ifrs.canoas.jee.jpaapp.dto.Pedido;

public class PedidoDAOTest {

	private PedidoDAO pedidoDAO = new PedidoDAO();
	private Pedido pedidoAux;
	
	@Before
	public void setUp() {
		
		Date data1 = new Date();
		Date data2 = new Date();
		
		LineItem item = new LineItem();
		LineItemDAO lineItemDAO = new LineItemDAO();
		lineItemDAO.save(item);
		List<LineItem> lineItens = new ArrayList<>();
		lineItens.add(item);
		
		Address address = new Address();
		AddressDAO addressDAO = new AddressDAO();
		addressDAO.save(address);
		
		Payment payment = new Payment();
		PaymentDAO paymentDAO = new PaymentDAO();
		paymentDAO.save(payment);
		List<Payment> payments = new ArrayList<>();
		payments.add(payment);
		
		Account account = new Account();
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.save(account);
		
		pedidoAux = new Pedido(null, data1, data2, 18f, OrderStatus.CLOSED , lineItens, address, payments, account);
		
		pedidoDAO.save(pedidoAux);
		
	} 
	
	@Test
	public void testSavePedidoCheio() {

		Date data1 = new Date();
		Date data2 = new Date();
		
		LineItem item = new LineItem();
		LineItemDAO lineItemDAO = new LineItemDAO();
		lineItemDAO.save(item);
		List<LineItem> lineItens = new ArrayList<>();
		lineItens.add(item);
		
		Address address = new Address();
		AddressDAO addressDAO = new AddressDAO();
		addressDAO.save(address);
		
		Payment payment = new Payment();
		PaymentDAO paymentDAO = new PaymentDAO();
		paymentDAO.save(payment);
		List<Payment> payments = new ArrayList<>();
		payments.add(payment);
		
		Account account = new Account();
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.save(account);
		
		Pedido pedido = new Pedido(null, data1, data2, 18f, OrderStatus.CLOSED , lineItens, address, payments, account);
		
		pedidoDAO.save(pedido);
		
		assertThat(pedido.getId()).isNotNull();
		
	}
	
	@Test
	public void testSavePedidoVazio() {
		
		Pedido pedido = new Pedido();
		
		pedidoDAO.save(pedido);
		
		assertThat(pedido.getId()).isNotNull();
		
	}
	
	@Test
	public void testFindAllOrderByOrderedVazios() {
		
		Pedido p1 = new Pedido();
		Pedido p2 = new Pedido();
		Pedido p3 = new Pedido();
		
		pedidoDAO.save(p1);
		pedidoDAO.save(p2);
		pedidoDAO.save(p3);
		
		List<Pedido> pedidos = pedidoDAO.findAllOrderByOrdered();
		
		assertThat(pedidos).size().isGreaterThan(2);
		
	}
	
	@Test
	public void testFindAllOrderByOrderedCheios() {
		
		Date data1 = new Date();
		Date data2 = new Date();
		
		LineItem item = new LineItem();
		LineItemDAO lineItemDAO = new LineItemDAO();
		lineItemDAO.save(item);
		List<LineItem> lineItens = new ArrayList<>();
		lineItens.add(item);
		
		Address address = new Address();
		AddressDAO addressDAO = new AddressDAO();
		addressDAO.save(address);
		
		Payment payment = new Payment();
		PaymentDAO paymentDAO = new PaymentDAO();
		paymentDAO.save(payment);
		List<Payment> payments = new ArrayList<>();
		payments.add(payment);
		
		Account account = new Account();
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.save(account);
		
		Pedido pedido = new Pedido(null, data1, null, 18f, OrderStatus.CLOSED , lineItens, address, payments, account);
		Pedido p2 = new Pedido(null, data1, null, 18f, OrderStatus.CLOSED , lineItens, address, payments, account);
		Pedido p3 = new Pedido(null, data1, null, 18f, OrderStatus.CLOSED , lineItens, address, payments, account);
		
		pedidoDAO.save(pedido);
		pedidoDAO.save(p2);
		pedidoDAO.save(p3);
		
		List<Pedido> pedidos = pedidoDAO.findAllOrderByOrdered();
		
		assertThat(pedidos).size().isGreaterThan(2);
		
	}
	
	@Test
	public void testFindAllOrderByOrderStatusCheio() {
		
		Pedido pedidoRecuperado = pedidoDAO.findAllOrderByOrderStatus(pedidoAux.getStatus()).get(0);
		assertThat(pedidoRecuperado.getStatus()).isEqualTo(OrderStatus.CLOSED);
		assertThat(pedidoRecuperado.getId()).isNotNull();
		
	}
	
	@Test
	public void testFindAllOrderByOrderStatusVazio() {
		
		pedidoAux.setStatus(null);
		List<Pedido> pedidosRecuperados = pedidoDAO.findAllOrderByOrderStatus(pedidoAux.getStatus());
		assertThat(pedidosRecuperados).size().isEqualTo(0);
		
	}
	
	@Test 
	public void testEditCheio() {
		
		assertThat(pedidoAux.getId()).isNotNull();
		assertThat(pedidoAux.getStatus()).as("CLOSED");
		
		pedidoAux.setStatus(OrderStatus.HOLD);;
		pedidoDAO.edit(pedidoAux);
		assertThat(pedidoAux.getStatus()).isEqualTo(OrderStatus.HOLD);
		
	}
	
	@Test 
	public void testEditVazio() {
		
		assertThat(pedidoAux.getId()).isNotNull();
		assertThat(pedidoAux.getStatus()).as("CLOSED");
		
		pedidoAux.setStatus(null);
		pedidoDAO.edit(pedidoAux);
		assertThat(pedidoAux.getStatus()).isEqualTo(null);
		
	}
	
	@Test
	public void testDeleteCheio() {
		
		assertThat(pedidoAux.getId()).isNotNull();
		assertThat(pedidoAux.getStatus()).as("CLOSED");
		
		pedidoAux.setStatus(OrderStatus.NEW);;
		pedidoDAO.edit(pedidoAux);
		assertThat(pedidoAux.getStatus()).as("NEW");
		
		pedidoDAO.delete(pedidoAux.getId());

		assertThat(pedidoDAO.findAllOrderByOrderStatus(OrderStatus.NEW)).size().isEqualTo(0);
		
	}
	
	
}
