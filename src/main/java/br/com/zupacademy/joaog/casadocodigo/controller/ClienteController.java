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

import br.com.zupacademy.joaog.casadocodigo.model.Cliente;
import br.com.zupacademy.joaog.casadocodigo.model.form.ClienteForm;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> criaCliente(@RequestBody @Valid ClienteForm cliente) {
		try {
			Cliente novoCliente = cliente.toModel(this.em);
			em.persist(novoCliente);
			em.flush();
			return ResponseEntity.ok().body(novoCliente.getId());

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
