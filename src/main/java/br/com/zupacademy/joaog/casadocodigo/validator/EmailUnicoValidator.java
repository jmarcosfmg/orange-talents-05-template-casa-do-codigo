package br.com.zupacademy.joaog.casadocodigo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.joaog.casadocodigo.model.form.AutorForm;
import br.com.zupacademy.joaog.casadocodigo.repository.AutorRepository;

@Component
public class EmailUnicoValidator implements Validator{
	
	@Autowired
	private AutorRepository autorRepository;
	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("Classe = "+clazz);
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm autor = (AutorForm) target;
		boolean emailPresente = autorRepository.existsByEmailIgnoreCase(autor.getEmail());
		if(emailPresente) {
			errors.rejectValue("email", null, "Email já cadastrado");
		}
	}

	

}
