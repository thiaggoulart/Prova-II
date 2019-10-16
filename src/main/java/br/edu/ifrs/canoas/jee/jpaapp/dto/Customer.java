package br.edu.ifrs.canoas.jee.jpaapp.dto;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String phone;
	private String email;
	private String name;
	
	@OneToOne
	@JoinColumn(name="CUSTOMER_ADDRESS")
	private Address address;
	
	@OneToOne
	@JoinColumn(name="CUSTUMER_ACCOUNT")
	private Account account;
	
	@OneToOne
	@JoinColumn(name="CUSTUMER_WEBUSER")
	private WebUser webUser;
   
}
