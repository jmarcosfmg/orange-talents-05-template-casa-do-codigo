package br.com.zupacademy.joaog.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.joaog.casadocodigo.model.form.LocalizacaoForm;

public class VerificaEstadoValidator implements ConstraintValidator<VerificaEstado, Object> {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		LocalizacaoForm localizacao = (LocalizacaoForm) value;
		if (localizacao.getEstado() == null) {
			Long a = em.createQuery("Select count(e) from Estado e where (e.pais.id = :pais)", Long.class)
					.setParameter("pais", localizacao.getPais()).getSingleResult();
			if (a > 0) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("Estado não pode ser nulo").addConstraintViolation();
				return false;
			}
			return true;
		}

		Long resultados = em
				.createQuery("Select count(e) from Estado e where (e.id = :estado) and (e.pais.id = :pais)", Long.class)
				.setParameter("estado", localizacao.getEstado()).setParameter("pais", localizacao.getPais())
				.getSingleResult();
		if (resultados > 0) {
			return true;
		}
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate("Estado não encontrado no país").addConstraintViolation();
		return false;
	}

}
