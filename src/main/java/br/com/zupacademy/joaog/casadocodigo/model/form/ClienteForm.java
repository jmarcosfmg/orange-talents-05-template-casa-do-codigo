package br.com.zupacademy.joaog.casadocodigo.model.form;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import br.com.zupacademy.joaog.casadocodigo.model.Cliente;
import br.com.zupacademy.joaog.casadocodigo.model.Estado;
import br.com.zupacademy.joaog.casadocodigo.model.Pais;
import br.com.zupacademy.joaog.casadocodigo.validator.CPFouCNPJ;
import br.com.zupacademy.joaog.casadocodigo.validator.Unico;
import br.com.zupacademy.joaog.casadocodigo.validator.VerificaEstado;

@Validated
public class ClienteForm {
	@Email
	@NotBlank
	@Unico(atributo = "email", classe = Cliente.class)
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CPFouCNPJ
	@NotBlank
	@Unico(atributo = "documento", classe = Cliente.class)
	private String documento;
	
	@VerificaEstado
	@Valid
	private LocalizacaoForm localizacao;

	@NotBlank
	private String telefone;

	public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, LocalizacaoForm localizacao, @NotBlank String telefone) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.localizacao = localizacao;
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public LocalizacaoForm getLocalizacao() {
		return localizacao;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public Cliente toModel(EntityManager em) {
		Pais pais = em.find(Pais.class, this.localizacao.getPais());
		Estado estado = null;
		if (this.localizacao.getEstado() != null) {
			estado = em.find(Estado.class, this.localizacao.getEstado());
		}
		
		return new Cliente(this.email, this.nome, this.sobrenome,
			this.documento, this.localizacao.getEndereco(), this.localizacao.getComplemento(),
			this.localizacao.getCidade(), pais, estado, this.telefone,
			this.localizacao.getCep());
	}

}
