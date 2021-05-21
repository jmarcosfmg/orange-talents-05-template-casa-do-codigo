package br.com.zupacademy.joaog.casadocodigo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joaog.casadocodigo.model.Livro;
import br.com.zupacademy.joaog.casadocodigo.model.dto.LivroDto;
import br.com.zupacademy.joaog.casadocodigo.model.form.LivroForm;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@PersistenceContext
	EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> criaLivro(@RequestBody @Valid LivroForm livroForm) {
		Livro livro = livroForm.toModel(this.em);
		em.persist(livro);
		return ResponseEntity.ok().build();

	}

	@GetMapping
	public List<LivroDto> listaLivros() {

		List<LivroDto> resultado = em.createQuery("Select l from Livro l", Livro.class).getResultStream()
				.map(LivroDto::new).collect(Collectors.toList());
		return resultado;

	}

}
