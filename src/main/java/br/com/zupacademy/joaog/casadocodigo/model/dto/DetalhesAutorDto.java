package br.com.zupacademy.joaog.casadocodigo.model.dto;

public class DetalhesAutorDto {
	private String nome;
	private String descricao;

	public DetalhesAutorDto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}