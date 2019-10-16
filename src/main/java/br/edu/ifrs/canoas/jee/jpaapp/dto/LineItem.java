package br.edu.ifrs.canoas.jee.jpaapp.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: LineItem
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LineItem implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private int quantity;
	private float price;
	@ManyToOne 
	@JoinColumn (name = "LINE_PROD")
	private Product product;
	@ManyToOne 
	@JoinColumn (name = "LINE_ORDER")
	private Pedido order;
	
	@ManyToOne 
	@JoinColumn (name = "CART_LINE")
	private ShoppingCart shoppingCart;
}
