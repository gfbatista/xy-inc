package com.luizalabs.desafioapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Poi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	@Range(min=0)
	private Long coordenadaX;

	@NotNull
	@Range(min=0)
	private Long coordenadaY;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(Long coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public Long getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(Long coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

}
