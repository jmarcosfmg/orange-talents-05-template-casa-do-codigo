package br.com.zupacademy.joaog.casadocodigo.validator;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD, TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { VerificaEstadoValidator.class })
public @interface VerificaEstado {

	String message()

	default "Erro na verificação do estado";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
