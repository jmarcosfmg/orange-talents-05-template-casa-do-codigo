package br.com.zupacademy.joaog.casadocodigo.model.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.joaog.casadocodigo.model.Pais;
import br.com.zupacademy.joaog.casadocodigo.validator.CampoVerificado;
import br.com.zupacademy.joaog.casadocodigo.validator.VerificaEstado;

@VerificaEstado
public class LocalizacaoForm {

	@NotNull
	@CampoVerificado(atributo = "id", classe = Pais.class)
	private Long pais;

	private Long estado;

	@NotBlank
	private String cidade;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cep;

	public LocalizacaoForm(@NotNull Long pais, Long estado, @NotBlank String cidade, @NotBlank String endereco,
			@NotBlank String complemento, @NotBlank String cep) {
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cep = cep;
	}

	public Long getPais() {
		return pais;
	}

	public Long getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

}
