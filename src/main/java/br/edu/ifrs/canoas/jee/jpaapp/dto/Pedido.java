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
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Pedido implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private Date ordered;
	private Date shipped;
	private float total;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@OneToMany (mappedBy = "order")
	private List<LineItem> lineItens;
	
	@OneToOne
	@JoinColumn(name="ADDRESS_ORDER")
	private Address shipTo; 
	
	@OneToMany (mappedBy = "order")
	private List<Payment> payments;
	
	@ManyToOne 
	@JoinColumn (name = "PROD_LINE")
	private Account account;
	
}
