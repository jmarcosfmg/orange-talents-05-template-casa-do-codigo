package br.com.zupacademy.joaog.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	@Size(max = 500)
	private String resumo;

	@Lob
	private String sumario;

	@NotNull
	@Min(value = 20L)
	private BigDecimal preco;

	@NotNull
	@Min(value = 100)
	private int numeroDePaginas;

	@ISBN
	private String isbn;

	@Future
	private LocalDate lancamento;

	@NotNull
	@ManyToOne
	private Categoria categoria;

	@NotNull
	@ManyToOne
	private Autor autor;

	public Livro(@NotBlank String titulo, @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroDePaginas, @ISBN String isbn,
			@Future LocalDate lancamento, @NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.lancamento = lancamento;
		this.categoria = categoria;
		this.autor = autor;
	}

}
