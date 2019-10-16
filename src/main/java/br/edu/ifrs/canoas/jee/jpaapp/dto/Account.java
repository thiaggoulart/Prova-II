package br.edu.ifrs.canoas.jee.jpaapp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Account implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private boolean isClosed;
	private Date open;
	private Date closed;
	
	@OneToOne
	@JoinColumn(name="ADDRESS_ACCOUNT")
	private Address billingAddress;
	
	@OneToMany (mappedBy = "account")
	private List<Payment> payments;
	
	@OneToOne
	@JoinColumn(name="CART_ACCOUNT")
	private ShoppingCart shoppingCart;
	
	@OneToOne
	@JoinColumn(name="CUSTUMER_ACCOUNT")
	private Customer customer;
	
	
}
