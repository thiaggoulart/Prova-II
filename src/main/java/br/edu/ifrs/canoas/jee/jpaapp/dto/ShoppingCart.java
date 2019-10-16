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
 * Entity implementation class for Entity: ShoppingCart
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ShoppingCart implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	private Date created;
	
	@OneToMany (mappedBy = "shoppingCart")
	private List<LineItem> lineItens;
	
	@OneToOne
	@JoinColumn(name="CART_ACCOUNT")
	private Account account;
	
	@OneToOne
	@JoinColumn(name="WEBUSER_ACCOUNT")
	private WebUser webUser;
	
}
