package br.com.zupacademy.joaog.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

	@Deprecated
	public Pais() {

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
