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

import br.com.zupacademy.joaog.casadocodigo.model.Categoria;
import br.com.zupacademy.joaog.casadocodigo.model.form.CategoriaForm;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@PostMapping
	public ResponseEntity<?> criaCategoria(@RequestBody @Valid CategoriaForm categoriaForm){
		try{
			System.out.println("OI");
			Categoria categoria = categoriaForm.toModel();
			System.out.println("OI2");
			entityManager.persist(categoria);
			System.out.println("OI3");
			return ResponseEntity.ok(categoria);
		}catch(Exception e) { 
			return ResponseEntity.badRequest().build();
		}		
	}
}
