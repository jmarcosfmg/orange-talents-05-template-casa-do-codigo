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

import br.com.zupacademy.joaog.casadocodigo.model.Estado;
import br.com.zupacademy.joaog.casadocodigo.model.form.EstadoForm;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> criaEstado(@RequestBody @Valid EstadoForm estado) {
		try {
			Estado novoEstado = estado.toModel(this.em);
			em.persist(novoEstado);
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
