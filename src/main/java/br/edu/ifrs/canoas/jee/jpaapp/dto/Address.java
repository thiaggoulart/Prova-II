package br.edu.ifrs.canoas.jee.jpaapp.dto;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Adress
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Address implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
   
}
