package br.com.zupacademy.joaog.casadocodigo.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
@Target({ FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { })
public @interface CPFouCNPJ {

	String message()

	default "Documento inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}