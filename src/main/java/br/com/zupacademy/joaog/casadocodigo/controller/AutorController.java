package br.com.zupacademy.joaog.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joaog.casadocodigo.model.Autor;
import br.com.zupacademy.joaog.casadocodigo.model.form.AutorForm;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@PostMapping
	public ResponseEntity<?> adicionaAutor(@RequestBody @Valid AutorForm autorForm){
			Autor autor = autorForm.toModel();
			entityManager.persist(autor);
			return ResponseEntity.ok().build();
	}

}
