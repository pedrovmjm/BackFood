package com.food.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;


//@Table(name="tab_cozinha") é para dar nome a tabela criada no mysql
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Entity
public class Cozinha {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue	(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=true)
	private String nome;

	
	
}
