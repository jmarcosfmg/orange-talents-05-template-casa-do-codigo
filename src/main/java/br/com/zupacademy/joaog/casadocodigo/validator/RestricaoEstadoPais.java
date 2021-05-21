package br.com.zupacademy.joaog.casadocodigo.validator;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { UnicoEstadoPaisValidator.class })
public @interface RestricaoEstadoPais {

	String message()

	default "Estado já existe";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
