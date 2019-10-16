package br.edu.ifrs.canoas.jee.jpaapp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Payment
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	private Date paid;
	private float total;
	private String details;
	
	@ManyToOne 
	@JoinColumn (name = "PAY_ORDER")
	private Pedido order;
	
	@ManyToOne 
	@JoinColumn (name = "PAY_ACCOUNT")
	private Account account;
   
}
