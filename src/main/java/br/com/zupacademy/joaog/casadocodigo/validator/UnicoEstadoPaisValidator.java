package br.com.zupacademy.joaog.casadocodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.joaog.casadocodigo.model.Estado;
import br.com.zupacademy.joaog.casadocodigo.model.form.EstadoForm;

public class UnicoEstadoPaisValidator implements ConstraintValidator<RestricaoEstadoPais, Object> {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		EstadoForm estado = (EstadoForm) value;
		List<Estado> resultados = em
				.createQuery("Select e from Estado e where (lower(e.nome) like lower(:nome)) and (e.pais.id = :pais)",
						Estado.class)
				.setParameter("nome", estado.getNome()).setParameter("pais", estado.getPais()).getResultList();
		if (resultados.isEmpty()) {
			return true;
		}
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate("Estado já existe").addConstraintViolation();
		return false;
	}

}
