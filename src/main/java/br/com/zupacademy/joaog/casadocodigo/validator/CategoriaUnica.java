package br.com.zupacademy.joaog.casadocodigo.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {CategoriaUnicaValidator.class})
public @interface CategoriaUnica {
	String message() default "Já existe uma categoria com o nome informado";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
