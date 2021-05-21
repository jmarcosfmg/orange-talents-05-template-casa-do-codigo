package br.com.zupacademy.joaog.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joaog.casadocodigo.model.Autor;
import br.com.zupacademy.joaog.casadocodigo.model.form.AutorForm;
import br.com.zupacademy.joaog.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> adicionaAutor(@RequestBody @Valid AutorForm autorForm) {
		Autor autor = autorForm.toModel();
		autorRepository.save(autor);
		return ResponseEntity.ok().build();
	}

}
