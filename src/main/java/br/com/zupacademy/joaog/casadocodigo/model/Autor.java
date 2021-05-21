package br.com.zupacademy.joaog.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotEmpty
	private String nome;
	@Email
	@NotEmpty
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	@NotNull
	private LocalDateTime instanteRegistro;

	public Autor(@NotNull @NotEmpty String nome, @Email @NotNull @NotEmpty String email,
			@NotNull @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.instanteRegistro = LocalDateTime.now();
	}

	@Deprecated
	public Autor() {

	}

	public String getEmail() {
		return this.email;
	}
}
