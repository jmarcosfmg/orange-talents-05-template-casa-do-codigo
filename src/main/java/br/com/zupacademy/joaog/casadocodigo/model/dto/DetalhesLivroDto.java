package br.com.zupacademy.joaog.casadocodigo.model.dto;

import java.math.BigDecimal;

import br.com.zupacademy.joaog.casadocodigo.model.Livro;

public class DetalhesLivroDto {

	private DetalhesAutorDto autor;
	private String titulo;
	private String sumario;
	private String isbn;
	private String resumo;
	private BigDecimal preco;
	private Integer nroPaginas;

	public DetalhesLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.sumario = livro.getSumario();
		this.isbn = livro.getIsbn();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.nroPaginas = livro.getNumeroDePaginas();
		this.autor = new DetalhesAutorDto(livro.getAutor().getNome(), livro.getAutor().getDescricao());
	}

	public DetalhesAutorDto getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSumario() {
		return sumario;
	}

	public String getIsbn() {
		return isbn;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNroPaginas() {
		return nroPaginas;
	}
	
	public String getResumo() {
		return resumo;
	}

}
