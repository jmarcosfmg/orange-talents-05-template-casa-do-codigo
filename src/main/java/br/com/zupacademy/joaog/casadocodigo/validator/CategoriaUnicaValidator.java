package br.com.zupacademy.joaog.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoriaUnicaValidator implements ConstraintValidator<CategoriaUnica, String>{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			em.createQuery("Select 1 from Categoria c where lower(c.nome) like lower(:nome)")
				.setParameter("nome", value).getSingleResult();
			return false;
		}
		catch(NoResultException e) {
			return true;
		}
	}

}
