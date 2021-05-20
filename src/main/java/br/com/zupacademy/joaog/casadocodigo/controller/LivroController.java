package br.com.zupacademy.joaog.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joaog.casadocodigo.model.Livro;
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

}
