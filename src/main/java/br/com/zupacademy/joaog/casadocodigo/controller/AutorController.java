package br.com.zupacademy.joaog.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joaog.casadocodigo.model.Autor;
import br.com.zupacademy.joaog.casadocodigo.model.form.AutorForm;
import br.com.zupacademy.joaog.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.joaog.casadocodigo.validator.EmailUnicoValidator;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private EmailUnicoValidator emailUnicoValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailUnicoValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> adicionaAutor(@RequestBody @Valid AutorForm autorForm) {
		System.out.println("OII");
		Autor autor = autorForm.toModel();
		// System.out.println(autorRepository.existsByEmailIgnoreCase("joao@joao.com.br"));
		System.out.println("OII");
		autorRepository.save(autor);
		return ResponseEntity.ok().build();
	}

}
