package br.com.zupacademy.joaog.casadocodigo.model.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.joaog.casadocodigo.model.Pais;
import br.com.zupacademy.joaog.casadocodigo.validator.Unico;

public class PaisForm {

	@NotBlank
	@Unico(atributo = "nome", classe = Pais.class)
	private String nome;

	public PaisForm(@NotBlank String nome) {
		this.nome = nome;
	}

	@Deprecated
	public PaisForm() {
	}

	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
}
