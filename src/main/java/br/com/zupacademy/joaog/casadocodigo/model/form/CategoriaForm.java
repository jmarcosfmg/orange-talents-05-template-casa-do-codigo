package br.com.zupacademy.joaog.casadocodigo.model.form;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.joaog.casadocodigo.model.Categoria;
import br.com.zupacademy.joaog.casadocodigo.validator.Unico;

public class CategoriaForm {

	@Unico(atributo = "nome", classe = Categoria.class)
	@NotBlank
	private String nome;

	@JsonCreator
	public CategoriaForm(@NotBlank @JsonProperty("nome") String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

}
