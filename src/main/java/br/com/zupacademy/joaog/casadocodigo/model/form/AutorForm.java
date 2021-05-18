package br.com.zupacademy.joaog.casadocodigo.model.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.joaog.casadocodigo.model.Autor;

public class AutorForm {
	@NotNull @NotEmpty
	private String nome;
	@Email @NotNull @NotEmpty
	private String email;
	@NotBlank @Size(max=400)
	private String descricao;	

	
	public AutorForm(@NotNull @NotEmpty String nome, @Email @NotNull @NotEmpty String email,
			@NotNull @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
	public String getEmail() {
		return this.email;
	}
	
}
