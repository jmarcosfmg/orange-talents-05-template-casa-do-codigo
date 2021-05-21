package br.com.zupacademy.joaog.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import br.com.zupacademy.joaog.casadocodigo.validator.RestricaoEstadoPais;

@Validated
@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@ManyToOne
	private Pais pais;

	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	@Deprecated
	public Estado() {
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

}
