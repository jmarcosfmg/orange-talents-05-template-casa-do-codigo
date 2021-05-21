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

import br.com.zupacademy.joaog.casadocodigo.model.form.PaisForm;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@PersistenceContext	
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> criaPais(@RequestBody @Valid PaisForm pais){
		try {
			em.persist(pais.toModel());
			return ResponseEntity.ok().build();
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(e);			
		}
	}
}
