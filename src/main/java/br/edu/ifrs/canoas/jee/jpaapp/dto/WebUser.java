package br.edu.ifrs.canoas.jee.jpaapp.dto;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: WebUser
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class WebUser implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserState userState;
   
	@OneToOne
	@JoinColumn(name="CUSTUMER_WEBUSER")
	private Customer customer;
	
}
