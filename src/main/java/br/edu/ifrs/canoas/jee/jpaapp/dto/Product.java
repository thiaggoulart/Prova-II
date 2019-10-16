package br.edu.ifrs.canoas.jee.jpaapp.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Product implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String name;
	private String supplier;
	@OneToMany (mappedBy = "product")
	private List<LineItem> lineItens;
}
