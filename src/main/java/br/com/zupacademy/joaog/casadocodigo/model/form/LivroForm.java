package br.com.zupacademy.joaog.casadocodigo.model.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.joaog.casadocodigo.model.Autor;
import br.com.zupacademy.joaog.casadocodigo.model.Categoria;
import br.com.zupacademy.joaog.casadocodigo.model.Livro;
import br.com.zupacademy.joaog.casadocodigo.validator.CampoVerificado;
import br.com.zupacademy.joaog.casadocodigo.validator.Unico;

public class LivroForm {
	@NotBlank
	@Unico(atributo = "titulo", classe = Livro.class)
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
	@Id
	@Unico(atributo = "isbn", classe = Livro.class)
	private String isbn;

	@Future
	@DateTimeFormat
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate lancamento;

	@CampoVerificado(classe = Categoria.class, atributo = "id")
	@NotNull
	private Long categoria;

	@CampoVerificado(classe = Autor.class, atributo = "id")
	@NotNull
	private Long autor;

	public LivroForm(@NotBlank String titulo, @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroDePaginas, @ISBN String isbn,
			@NotNull Long categoria, @NotNull Long autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Livro toModel(EntityManager em) {
		Autor autorDB = em.find(Autor.class, autor);
		Categoria categoriaDB = em.find(Categoria.class, categoria);

		Assert.isTrue(autor != null, "Autor não encontrado");
		Assert.isTrue(categoria != null, "Categoria não encontrada");

		Livro novoLivro = new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroDePaginas, this.isbn,
				this.lancamento, categoriaDB, autorDB);

		return novoLivro;
	}

	public void setLancamento(@Future LocalDate lancamento) {
		this.lancamento = lancamento;
	}
}
