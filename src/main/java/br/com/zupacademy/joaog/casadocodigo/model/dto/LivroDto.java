package br.com.zupacademy.joaog.casadocodigo.model.dto;

import br.com.zupacademy.joaog.casadocodigo.model.Livro;

public class LivroDto {
	
	private Long id;
	private String nome;
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.nome = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
