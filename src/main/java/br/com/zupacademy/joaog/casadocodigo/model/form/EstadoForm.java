package br.com.zupacademy.joaog.casadocodigo.model.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.joaog.casadocodigo.model.Estado;
import br.com.zupacademy.joaog.casadocodigo.model.Pais;
import br.com.zupacademy.joaog.casadocodigo.validator.CampoVerificado;
import br.com.zupacademy.joaog.casadocodigo.validator.RestricaoEstadoPais;

@RestricaoEstadoPais
public class EstadoForm {

	@NotNull
	@CampoVerificado(atributo = "id", classe = Pais.class)
	private Long pais;

	@NotBlank
	private String nome;

	public EstadoForm(Long pais, String nome) {
		this.pais = pais;
		this.nome = nome;
	}

	@Deprecated
	public EstadoForm() {

	}

	public Long getPais() {
		return pais;
	}

	public String getNome() {
		return nome;
	}

	public Estado toModel(EntityManager em) {
		Pais pais = em.find(Pais.class, this.pais);
		return new Estado(this.nome, pais);
	}

	@Override
	public String toString() {
		return "EstadoForm [pais=" + pais + ", nome=" + nome + "]";
	}

}
