package br.edu.ifrs.canoas.jee.jpaapp.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.jpaapp.dto.Account;
import br.edu.ifrs.canoas.jee.jpaapp.dto.Address;
import br.edu.ifrs.canoas.jee.jpaapp.dto.Customer;
import br.edu.ifrs.canoas.jee.jpaapp.dto.LineItem;
import br.edu.ifrs.canoas.jee.jpaapp.dto.OrderStatus;
import br.edu.ifrs.canoas.jee.jpaapp.dto.Payment;
import br.edu.ifrs.canoas.jee.jpaapp.dto.Pedido;
import br.edu.ifrs.canoas.jee.jpaapp.dto.WebUser;

public class CustomerDAOTest {

	private CustomerDAO customerDAO = new CustomerDAO();
	private Customer customerAux;
	
	@Before
	public void setUp() {
		
		Address address = new Address();
		AddressDAO addressDAO = new AddressDAO();
		addressDAO.save(address);
		
		Account account = new Account();
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.save(account);
		
		WebUser webUser = new WebUser();
		WebUserDAO webUserDao = new WebUserDAO();
		webUserDao.save(webUser);
		
		customerAux = new Customer(null, "123", "email", "thiago", address, account, webUser);
		
		customerDAO.save(customerAux);
		
	} 
	
	@Test
	public void testSaveCustomerCheio() {

		Address address = new Address();
		AddressDAO addressDAO = new AddressDAO();
		addressDAO.save(address);
		
		Account account = new Account();
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.save(account);
		
		WebUser webUser = new WebUser();
		WebUserDAO webUserDao = new WebUserDAO();
		webUserDao.save(webUser);
		
		Customer customer = new Customer(null, "123", "email", "thiago", address, account, webUser);
		
		customerDAO.save(customer);
		
		assertThat(customer.getId()).isNotNull();
		
	}
	
	@Test
	public void testSaveCustomerVazio() {
		
		Customer customer = new Customer();
		
		customerDAO.save(customer);
		
		assertThat(customer.getId()).isNotNull();
		
	}
	
	@Test
	public void testFindAllVazios() {
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		
		customerDAO.save(c1);
		customerDAO.save(c2);
		customerDAO.save(c3);
		
		List<Customer> customers = customerDAO.findAll();
		
		assertThat(customers).size().isGreaterThan(2);
		
	}
	
	@Test
	public void testFindAllCheios() {
		
		Address address = new Address();
		AddressDAO addressDAO = new AddressDAO();
		addressDAO.save(address);
		
		Account account = new Account();
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.save(account);
		
		WebUser webUser = new WebUser();
		WebUserDAO webUserDao = new WebUserDAO();
		webUserDao.save(webUser);
		
		Customer customer = new Customer(null, "123", "email", "thiago", address, account, webUser);
		Customer customer2 = new Customer(null, "123", "email", "thiago", address, account, webUser);
		Customer customer3 = new Customer(null, "123", "email", "thiago", address, account, webUser);
		
		customerDAO.save(customer);
		customerDAO.save(customer2);
		customerDAO.save(customer3);
		
	
		List<Customer> customers = customerDAO.findAll();
		
		assertThat(customers).size().isGreaterThan(2);
		
	}


}
